package utils;

import com.google.gson.Gson;

public class BookingBodyGenerator {

    public static String generateBookingBody(String bodyType) {
        return switch (bodyType.toUpperCase()) {
            case "VALID", "INVALID" -> generateBody(bodyType);
            case "EMPTY" -> generateEmptyBody();
            default -> throw new IllegalArgumentException("Unsupported body type: " + bodyType);
        };
    }

    public static String generateBody(String bodyType) {
        BookingData bookingData = new BookingData(bodyType);
        Gson gson = new Gson();
        return gson.toJson(bookingData);
    }

    public static String generateEmptyBody() {
        return "{}";
    }
}
