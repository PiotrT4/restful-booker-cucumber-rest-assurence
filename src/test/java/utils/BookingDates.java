package utils;

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
        bookingDates.checkin = null;
        bookingDates.checkout = null;
    }

    private void validBookingDatesConstructor(BookingDates bookingDates) {
        bookingDates.checkin = DataFaker.validCheckIn();
        bookingDates.checkout = DataFaker.validCheckOut();
    }
}
