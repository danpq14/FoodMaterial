import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CrispyFlour extends Material implements Discount {
    public CrispyFlour(int ID, String name, double weight, String unit, int price, String date) {
        super(ID, name, weight, unit, price,date);
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
        calendar.add(Calendar.MONTH, -4);
        Date discountDate20 = calendar.getTime();
        calendar.add(Calendar.MONTH, 2);
        Date discountDate40 = calendar.getTime();
        int isDiscounted20 = now.compareTo(discountDate20);
        int isDiscounted40 = now.compareTo(discountDate40);
        if (isDiscounted20 >= 0 && isDiscounted40 < 0) {
            return charge()*0.8;
        }

        if (isDiscounted40 >=0) {
            return charge()*0.6;
        }
        else {
            return charge()*0.95;
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
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }


}