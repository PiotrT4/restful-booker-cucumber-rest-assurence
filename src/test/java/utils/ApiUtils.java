package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;
import java.util.Random;

public class ApiUtils {
    public static Response response;

    public static String getBookingId(Response response) {
        String jsonString = response.asString();
        List<Integer> listOfBookingIds = JsonPath.from(jsonString).getList("bookingid");
        Random random = new Random();
        Integer randomBookingId = listOfBookingIds.get(random.nextInt(listOfBookingIds.size()));
        return randomBookingId.toString();
    }
}
