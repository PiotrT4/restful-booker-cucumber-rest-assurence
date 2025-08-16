package utils;

import javax.xml.crypto.Data;

public class BookingData {
    public String firstname;
    public String lastname;
    public int totalprice;
    public boolean depositpaid;
    public BookingDates bookingdates;
    public String additionalneeds;

    public BookingData(){
        firstname = DataFaker.generateFirstName();
        lastname = DataFaker.generateLastName();
        totalprice = DataFaker.generateTotalPrice();
        depositpaid = DataFaker.generateDepositPaid();
        bookingdates = new BookingDates();
        additionalneeds = DataFaker.generateAddictionalNeeds();
    }
}
