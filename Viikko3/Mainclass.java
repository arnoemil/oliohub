package Viikko3;

import java.util.Scanner;

public class Mainclass {
    public static void main(String[] args){
        int selection = 1;
        int bottle_number;

        BottleDispenser machine1 = new BottleDispenser();
        while(selection != 0) {
            selection = BottleDispenser.bottleMenu();
            if (selection == 1) {
                machine1.addMoney();
                continue;
            } else if (selection == 2) {
                machine1.listBottles();
                System.out.print("Your choice: ");
                Scanner sc2 = new Scanner(System.in);
                bottle_number = sc2.nextInt()-1;
                machine1.buyBottle(bottle_number);
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