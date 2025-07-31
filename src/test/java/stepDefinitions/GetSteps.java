package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;
import utils.ApiUtils;
import utils.TestContext;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static utils.ApiUtils.getBookingId;

public class GetSteps {
    private TestContext testContext;

    @When("User sends the GET request for booking")
    public void user_sends_the_get_request_for_booking() {
        ApiUtils.response = RestAssured
                .given()
                .get("/booking");
    }

    @And("The response should contain a list of the booking IDs")
    public void the_response_should_contain_a_list_of_all_booking_ids() {
        String actualJsonArray = ApiUtils.response.getBody().asString();
        Assert.assertTrue(
                "Response body does not contain any bookingid",
                actualJsonArray.contains("bookingid")
        );
    }

    @When("User sends the GET request for booking with name filter {string} {string}")
    public void user_sends_the_request_for_booking_with_name_filter_first_name_second_name(String firstName, String lastName) {
        ApiUtils.response = RestAssured
                .given()
                .queryParam("firstname", firstName)
                .queryParam("lastname", lastName)
                .when()
                .get("/booking");
    }

    @And("The response body should have empty JSON array")
    public void the_response_body_should_have_empty_json_array() {
        String expectedJsonArray = "[]";
        String actualJsonArray = ApiUtils.response.getBody().asString();

        Assert.assertEquals(
                "Response body contains some bookingid",
                expectedJsonArray, actualJsonArray
        );
    }

    @When("User sends the GET request booking with the check in date filter {string}")
    public void user_sends_the_get_request_for_booking_with_check_in_date_filter(String checkInDate) {
        ApiUtils.response = RestAssured
                .given()
                .queryParam("checkin", checkInDate)
                .when()
                .get("/booking");
    }

    @When("User sends the GET request for booking with the check in date filter {string}")
    public void user_sends_the_get_request_for_booking_with_check_out_date_filter(String checkOutDate) {
        ApiUtils.response = RestAssured
                .given()
                .queryParam("checkout", checkOutDate)
                .when()
                .get("/booking");
    }

    @When("User sends the GET request for booking with filters: check in {string} and check out {string}")
    public void user_sends_the_get_request_for_booking_with_filters_check_in_and_check_out(String checkInDate, String checkOutDate) {
        ApiUtils.response = RestAssured
                .given()
                .queryParam("checkin", checkInDate)
                .queryParam("checkout", checkOutDate)
                .when()
                .get("/booking");
    }

    @And("The response body should have {string} text")
    public void the_response_body_should_have_text(String expectedResponseText) {
        String actualResponseText = ApiUtils.response.getBody().asString();

        Assert.assertEquals(
                "Response body contains different text",
                expectedResponseText, actualResponseText
        );
    }

    @When("User sends the GET request for booking with an incorrect name filter {string} {string}")
    public void user_sends_the_get_request_for_booking_with_an_incorrect_name_filter(String firstName, String lastName) {
        ApiUtils.response = RestAssured
                .given()
                .queryParam("firstname", firstName)
                .queryParam("lastname", lastName)
                .when()
                .get("/booking");
    }

    @When("User sends the GET request for booking with ID {int}")
    public void userSendsTheGETRequestForBookingWithID(int bookingId) {
        ApiUtils.response = RestAssured
                .get("/booking/" + bookingId);
    }

    @Given("Select one existing booking ID")
    public void select_one_existing_booking_id() {
        ApiUtils.response = RestAssured
                .get("/booking");
        testContext = new TestContext(getBookingId(ApiUtils.response));
    }

    @When("The user sends the GET request for booking with the existing booking ID")
    public void the_user_sends_the_get_request_for_booking_with_the_existing_booking_id() {
        ApiUtils.response = RestAssured
                .get("/booking/" + testContext.getCapturedValue());
    }

    @And("The response should have booking details")
    public void the_response_should_have_booking_details() {
        assertAll(
                "Response validation:",
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("firstname")),
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("lastname")),
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("totalprice")),
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("depositpaid")),
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("bookingdates.checkin")),
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("bookingdates.checkout")),
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("additionalneeds"))
        );
    }

}
