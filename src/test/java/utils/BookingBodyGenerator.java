package utils;

import com.google.gson.Gson;

public class BookingBodyGenerator {

    public static String generateBookingBody() {
        BookingData bookingData = new BookingData();
        Gson gson = new Gson();
        System.out.println(gson.toJson(bookingData));
        return gson.toJson(bookingData);
    }
}
