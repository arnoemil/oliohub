package Viikko3;

import java.util.ArrayList;
import java.util.Scanner;

public class BottleDispenser {
    private int bottles;
    private ArrayList<Bottle> bottle_array = new ArrayList();
    private int money;
    
    public BottleDispenser() {
        bottles = 5;
        money = 0;
        
        for(int i = 0;i<bottles;i++) {
            bottle_array.add(new Bottle("Pepsi Max", "Pepsi", 0.3f, 0.5f, 1.80f));
        }
    }


    public void listBottles() {
        for(int i = 1; i<=bottles;i++) {
            /* System.out.println(i + ". Name: " + bottle_array.get(bottle_array.size() - i).getName() + 
            "\n\tSize: " + bottle_array.get(bottle_array.size() - 1).getSize() + "\tPrice: " + String.format("%,.1f", bottle_array.get(bottle_array.size() - 1).getPrice())); */
            System.out.printf("%d. Name: %s\n\tSize: %.3s\tPrice: %.3s\n", i, bottle_array.get(bottle_array.size() - i).getName(), bottle_array.get(bottle_array.size() - 1).getSize(),
            bottle_array.get(bottle_array.size() - 1).getPrice());
        }
    }

    public static int bottleMenu() {
        System.out.println("\n*** BOTTLE DISPENSER ***");
        System.out.println("1) Add money to the machine");
        System.out.println("2) Buy a bottle");
        System.out.println("3) Take money out");
        System.out.println("4) List bottles in the dispenser");
        System.out.println("0) End");
        System.out.print("Your choice: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Added more money!");
    }
    
    public void buyBottle() {
        if (bottles == 0) {
            System.out.println("There are no bottles left in the dispenser. :(");
        } else if (money < bottle_array.get(bottle_array.size() - 1).getPrice()) {
            System.out.println("Add money first!");
        } else {
            bottles -= 1; //number of bottles reduced
            bottle_array.remove(bottle_array.size() - 1); //removes bottle from the machine's list
            money -= bottle_array.get(bottle_array.size() - 1).getPrice();
            System.out.println("KACHUNK! " + bottle_array.get(bottle_array.size() - 1).getName() + " came out of the dispenser!");        
        }
    }
    
    public void returnMoney() {
        money = 0;
        System.out.println("Klink klink. Money came out!");
    }


}