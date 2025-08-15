package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.ApiUtils;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommonSteps {

    @Then("The response status code should be {int}")
    public void the_response_status_code_should_be_integer(int expectedStatusCode) {
        int actualStatusCode = ApiUtils.response.getStatusCode();

        Assert.assertEquals(
                "Expected status code: " + expectedStatusCode + ", but got: " + actualStatusCode,
                expectedStatusCode, actualStatusCode);
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
