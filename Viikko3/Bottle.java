package Viikko3;

public class Bottle {
    private String name;
    private String manufacturer;
    private double total_energy;
    private double size;
    private float price;
    public Bottle(String n, String manuf, float totE, float s, float p){
        name = n;
        manufacturer = manuf;
        total_energy = totE;
        size = s;
        price = p;
    }
    public String getName(){
        return name;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public double getEnergy(){
        return total_energy;
    }
    public double getSize(){
        return size;
    }
    public float getPrice(){
        return price;
    }
}