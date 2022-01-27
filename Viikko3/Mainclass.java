package Viikko3;

public class Mainclass {
    public static void main(String[] args){
        int selection = 1;

        BottleDispenser machine1 = new BottleDispenser();
        while(selection != 0) {
            selection = BottleDispenser.bottleMenu();
            if (selection == 1) {
                machine1.addMoney();
                continue;
            } else if (selection == 2) {
                machine1.buyBottle();
                continue;
            } else if (selection == 3) {
                machine1.returnMoney();
                continue;
            } else if (selection == 4) {
                machine1.listBottles();
                continue;
            } else if (selection == 0) {
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}