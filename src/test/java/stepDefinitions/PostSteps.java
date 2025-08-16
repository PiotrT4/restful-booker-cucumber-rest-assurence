package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import utils.ApiUtils;
import utils.BookingBodyGenerator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PostSteps {
    private static String requestBody;

    @Given("Generate {string} body of booking data")
    public void generate_a_an_string_body_of_booking_data(String bodyType) {
        requestBody = BookingBodyGenerator.generateBookingBody(bodyType);
    }

    @When("The user send POST request with generated body")
    public void the_user_send_get_request_with_generated_body() {
        ApiUtils.response = RestAssured
                .given()
                    .contentType("application/json")
                    .body(requestBody)
                .post("/booking");
    }

    @And("The response should have created booking details")
    public void the_response_should_have_created_booking_details() {
        assertAll(
                "Response validation:",
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("bookingid")),
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("booking.firstname")),
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("booking.lastname")),
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("booking.totalprice")),
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("booking.depositpaid")),
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("booking.bookingdates.checkin")),
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("booking.bookingdates.checkout")),
                () -> assertNotNull(ApiUtils.response.jsonPath().getString("booking.additionalneeds"))
        );
    }
}
