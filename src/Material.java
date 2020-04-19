import java.text.ParseException;

import java.util.Date;

public abstract class Material   {
    private int ID;
    private String name;
    private double weight;
    private String unit;
    private double price;
    protected String date;

    public Material(int ID, String name, double weight, String unit, double price,String date) {
        this.ID = ID;
        this.name = name;
        this.weight = weight;
        this.unit = unit;
        this.price = price;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }


    public abstract Date getExpiryDate() throws ParseException;

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double charge();
}