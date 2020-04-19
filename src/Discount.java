import java.text.ParseException;

public interface Discount {

    double chargeDiscount() throws ParseException;
    void priceDifferent() throws ParseException;
}