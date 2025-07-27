package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.TestContext;

import static utils.ApiUtils.checkStatusCode;
import static utils.ApiUtils.getBookingId;

public class GetBookingSteps {
    public static Response response;
    private TestContext testContext;

    @Given("Select one existing booking ID")
    public void select_one_existing_booking_id() {
        response = RestAssured
                .get("/booking");
        testContext = new TestContext(getBookingId(response));
    }

    @When("The user sends the GET request for booking with the existing booking ID")
    public void the_user_sends_the_get_request_for_booking_with_the_existing_booking_id() {
        response = RestAssured
                .get("/booking/" + testContext.getCapturedValue());
    }

    @Then("The response status code be {int}")
    public void the_response_status_code_should_be_integer(int expectedStatusCode) {
        checkStatusCode(expectedStatusCode, response);
    }
}
