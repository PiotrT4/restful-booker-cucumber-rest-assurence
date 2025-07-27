package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static utils.ApiUtils.checkStatusCode;

public class GetBookingIdsSteps {
    public static Response response;

    @When("User sends the GET request for booking")
    public void user_sends_the_get_request_for_booking() {
        response = RestAssured
                .get("/booking");
    }

    @And("The response should contain a list of the booking IDs")
    public void the_response_should_contain_a_list_of_all_booking_ids() {
        String actualJsonArray = response.getBody().asString();
        Assert.assertTrue("Response body does not contain any bookingid",
                actualJsonArray.contains("bookingid"));
    }

    @When("User sends the GET request for booking with name filter {string} {string}")
    public void user_sends_the_request_for_booking_with_name_filter_first_name_second_name(String firstName, String lastName) {
        response = RestAssured
                .given()
                .queryParam("firstname", firstName)
                .queryParam("lastname", lastName)
                .when()
                .get("/booking");
    }

    @And("The response body should have empty JSON array")
    public void the_response_body_should_have_empty_json_array() {
        String expectedJsonArray = "[]";
        String actualJsonArray = response.getBody().asString();
        Assert.assertEquals("Response body contains some bookingid",
                expectedJsonArray, actualJsonArray);
    }

    @When("User sends the GET request booking with the check in date filter {string}")
    public void user_sends_the_get_request_for_booking_with_check_in_date_filter(String checkInDate) {
        response = RestAssured
                .given()
                .queryParam("checkin", checkInDate)
                .when()
                .get("/booking");
    }

    @When("User sends the GET request for booking with the check in date filter {string}")
    public void user_sends_the_get_request_for_booking_with_check_out_date_filter(String checkOutDate) {
        response = RestAssured
                .given()
                .queryParam("checkout", checkOutDate)
                .when()
                .get("/booking");
    }

    @When("User sends the GET request for booking with filters: check in {string} and check out {string}")
    public void user_sends_the_get_request_for_booking_with_filters_check_in_and_check_out(String checkInDate, String checkOutDate) {
        response = RestAssured
                .given()
                .queryParam("checkin", checkInDate)
                .queryParam("checkout", checkOutDate)
                .when()
                .get("/booking");
    }

    @And("The response body should have {string} text")
    public void the_response_body_should_have_text(String expectedResponseText) {
        String actualResponseText = response.getBody().asString();
        Assert.assertEquals("Response body contains different text",
                expectedResponseText, actualResponseText);
    }

    @When("User sends the GET request for booking with an incorrect name filter {string} {string}")
    public void user_sends_the_get_request_for_booking_with_an_incorrect_name_filter(String firstName, String lastName) {
        response = RestAssured
                .given()
                .queryParam("firstname", firstName)
                .queryParam("lastname", lastName)
                .when()
                .get("/booking");
    }

    @When("User sends the GET request for booking with ID {int}")
    public void userSendsTheGETRequestForBookingWithID(int bookingId) {
        response = RestAssured
                .get("/booking/" + bookingId);
    }

    @And("The response should have booking details")
    public void the_response_should_have_booking_details() {
        assertAll("Response validation:",
                () -> assertNotNull(response.jsonPath().getString("firstname")),
                () -> assertNotNull(response.jsonPath().getString("lastname")),
                () -> assertNotNull(response.jsonPath().getString("totalprice")),
                () -> assertNotNull(response.jsonPath().getString("depositpaid")),
                () -> assertNotNull(response.jsonPath().getString("bookingdates.checkin")),
                () -> assertNotNull(response.jsonPath().getString("bookingdates.checkout")),
                () -> assertNotNull(response.jsonPath().getString("additionalneeds"))
                );
    }

    @Then("The response status code should be {int}")
    public void the_response_status_code_should_be_integer(int expectedStatusCode) {
        checkStatusCode(expectedStatusCode, response);
    }
}
