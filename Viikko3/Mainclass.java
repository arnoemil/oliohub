package Viikko3;

public class Mainclass {
    
    public static void main(String[] args){
        BottleDispenser machine1 = new BottleDispenser();
        machine1.addMoney();
        machine1.buyBottle();
        machine1.buyBottle();
        machine1.addMoney();
        machine1.addMoney();
        machine1.buyBottle();
        machine1.returnMoney();
    }
}

