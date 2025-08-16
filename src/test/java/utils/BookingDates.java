package utils;

public class BookingDates {
    public String checkin;
    public String checkout;

    BookingDates() {
        checkin = DataFaker.generateCheckIn();
        checkout = DataFaker.generateCheckOut();
    }
}
