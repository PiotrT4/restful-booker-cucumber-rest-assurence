package utils;

import javax.xml.crypto.Data;

public class BookingDates {
    protected String checkin;
    protected String checkout;

    BookingDates(String bodyType) {
        switch (bodyType.toUpperCase()){
            case "VALID":
                validBookingDatesConstructor(this);
                break;
            case "INVALID":
                invalidBookingDatesConstructor(this);
                break;
            default:
                break;
        };
    }

    private void invalidBookingDatesConstructor(BookingDates bookingDates) {
        bookingDates.checkin = DataFaker.invalidCheckIn();
        bookingDates.checkout = DataFaker.invalidCheckOut();
    }

    private void validBookingDatesConstructor(BookingDates bookingDates) {
        bookingDates.checkin = DataFaker.validCheckIn();
        bookingDates.checkout = DataFaker.validCheckOut();
    }
}
