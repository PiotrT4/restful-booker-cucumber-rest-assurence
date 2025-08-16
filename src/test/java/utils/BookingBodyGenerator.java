package utils;

import com.google.gson.Gson;

public class BookingBodyGenerator {

    public static String generateBookingBody() {
        BookingData bookingData = new BookingData();
        Gson gson = new Gson();
        return gson.toJson(bookingData);
    }

    public static String generateEmptyBody() {
        return "{}";
    }
}
