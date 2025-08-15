package utils;

public class BookingData {
    public String firstname;
    public String lastname;
    public int totalprice;
    public boolean depositpaid;
    public BookingDates bookingdates;
    public String additionalneeds;

    public BookingData(){
        firstname = "Thoms";
        lastname = "Kovalevskaya";
        totalprice = 199;
        depositpaid = true;
        bookingdates = new BookingDates();
        additionalneeds = "Dishwasher";
    }
}
