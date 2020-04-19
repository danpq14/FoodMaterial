import java.text.ParseException;

public class Test {
    public static void main(String[] args) throws ParseException {
        Material[] store = new Material[6];
        store[0] = new CrispyFlour(01,"Bột 200g", 200, "g", 100000, "19/8/2019");
        store[1] = new CrispyFlour(02,"Bột 200g", 200, "g", 100000, "19/6/2019");
        store[2] = new CrispyFlour(03,"Bột 200g", 200, "g", 100000, "10/1/2020");
        store[3] = new Meat(11,"Thịt Lợn 5 lạng", 500,"g",20000, "15/4/2020");
        store[4] = new Meat(12,"Thịt Lợn 5 lạng", 500,"g",20000, "8/4/2020");
        store[5] = new Meat(13,"Thịt Lợn 5 lạng", 500,"g",20000, "6/4/2020");

        for (Material material : store) {
            if (material instanceof Meat) {
                System.out.println("Thành tiền của sản phẩm " + material.getName()+ " sau chiết khấu là : " + ((Meat) material).chargeDiscount() );
                ((Meat) material).priceDifferent();
                System.out.println("------------------------------");
            }

            if (material instanceof CrispyFlour) {
                System.out.println("Thành tiền của sản phẩm " + material.getName()+ " sau chiết khấu là : " + ((CrispyFlour) material).chargeDiscount());
                ((CrispyFlour) material).priceDifferent();
                System.out.println("------------------------------");
            }
        }
    }
}
