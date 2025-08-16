package utils;

public class BookingData {
    public String firstname;
    public String lastname;
    public int totalprice;
    public boolean depositpaid;
    public BookingDates bookingdates;
    public String additionalneeds;

    public BookingData(String bodyType){
        this.firstname = DataFaker.validFirstName();
        this.lastname = DataFaker.validLastName();
        this.totalprice = DataFaker.validTotalPrice();
        this.depositpaid = DataFaker.validDepositPaid();
        this.bookingdates = new BookingDates(bodyType);
        this.additionalneeds = DataFaker.validAddictionalNeeds();
    }
}
