import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Meat extends Material implements  Discount{

    public Meat(int ID, String name, double weight, String unit, double price, String date) {
        super(ID, name, weight, unit, price, date);
    }

    @Override
    public double charge() {
        double cost = 0.0;
        if (getUnit() == "kg") {
            cost = getWeight()*getPrice();
        }
        if (getUnit() == "g") {
            cost = (getWeight()/1000)*getPrice();
        }
        return cost;
    }

    @Override
    public double chargeDiscount() throws ParseException {
        Date now = new Date();
        Date expiryDate = getExpiryDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expiryDate);
        calendar.add(Calendar.DATE, -5);
        Date discountDate30 = calendar.getTime();
        calendar.add(Calendar.DATE, 2);
        Date discountDate50 = calendar.getTime();
        int isDiscounted30 = now.compareTo(discountDate30);
        int isDiscounted50 = now.compareTo(discountDate50);
        if (isDiscounted30 >= 0 && isDiscounted50 < 0) {
            return charge()*0.7;
        }

        if (isDiscounted50 >=0) {
            return charge()*0.5;
        }
        else {
            return charge()*0.9;
        }
    };

    @Override
    public void priceDifferent() throws ParseException {
        System.out.println("Số tiền tiết kiệm được so với giá gốc : " + (charge()-chargeDiscount()));
    }

    @Override
    public Date getExpiryDate() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateOfManufacture = formatter.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfManufacture);
        calendar.add(Calendar.DATE, 15);
        return calendar.getTime();
    }
}