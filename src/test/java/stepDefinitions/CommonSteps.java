package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.ApiUtils;

public class CommonSteps {

    @Then("The response status code should be {int}")
    public void the_response_status_code_should_be_integer(int expectedStatusCode) {
        int actualStatusCode = ApiUtils.response.getStatusCode();

        Assert.assertEquals(
                "Expected status code: " + expectedStatusCode + ", but got: " + actualStatusCode,
                expectedStatusCode, actualStatusCode);
    }

    @And("The response body should have {string} text")
    public void the_response_body_should_have_text(String expectedResponseText) {
        String actualResponseText = ApiUtils.response.getBody().asString();

        Assert.assertEquals(
                "Response body contains different text",
                expectedResponseText, actualResponseText
        );
    }
}
