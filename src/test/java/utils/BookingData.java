package utils;

public class BookingData {
    protected final String firstname;
    protected final String lastname;
    protected final int totalprice;
    protected final boolean depositpaid;
    protected final BookingDates bookingdates;
    protected final String additionalneeds;

    public BookingData(String bodyType){
        this.firstname = DataFaker.validFirstName();
        this.lastname = DataFaker.validLastName();
        this.totalprice = DataFaker.validTotalPrice();
        this.depositpaid = DataFaker.validDepositPaid();
        this.bookingdates = new BookingDates(bodyType);
        this.additionalneeds = DataFaker.validAddictionalNeeds();
    }
}
