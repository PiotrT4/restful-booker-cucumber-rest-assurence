package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class ApiUtils {
    public static void checkStatusCode(int expectedStatusCode, Response response) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(
                "Expected status code: " + expectedStatusCode + ", but got: " + actualStatusCode,
                expectedStatusCode, actualStatusCode);
    }

    public static String getBookingId(Response response) {
        String jsonString = response.asString();
        List<Integer> bookingIds = JsonPath.from(jsonString).getList("bookingid");
        return bookingIds.get(0).toString();
    }
}
