package hook;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Hook {

    @Before
    public void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        //Health Checker
        Response response = RestAssured.get("/ping");
        if(response.getStatusCode() != 201) {
            throw new RuntimeException("Restful Booker API do not respond! Status: " + response.getStatusCode());
        }
    }

}
