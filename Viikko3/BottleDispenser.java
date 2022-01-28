package Viikko3;

import java.util.ArrayList;
import java.util.Scanner;

public class BottleDispenser {
    private int bottles;
    private ArrayList<Bottle> bottle_array = new ArrayList();
    private float money;
    
    public BottleDispenser() {
        bottles = 5;
        money = 0;
        
        bottle_array.add(0,new Bottle("Pepsi Max", "Pepsi", 0.3f, 0.5f, 1.80f));
        bottle_array.add(1,new Bottle("Pepsi Max", "Pepsi", 0.3f, 1.5f, 2.20f));
        bottle_array.add(2,new Bottle("Coca-Cola Zero", "Cola-Cola", 0.3f, 0.5f, 2.00f));
        bottle_array.add(3,new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3f, 1.5f, 2.50f));
        bottle_array.add(4,new Bottle("Fanta Zero", "Coca-Cola", 0.3f, 0.5f, 1.95f));
    }


    public void listBottles() {
        for(int i = 1; i<=bottles;i++) {
            System.out.printf("%d. Name: %s\n\tSize: %.3s\tPrice: %.4s\n", i, bottle_array.get(i-1).getName(), bottle_array.get(i-1).getSize(),
            bottle_array.get(i-1).getPrice());
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
        Scanner sc1 = new Scanner(System.in);
        return sc1.nextInt();
    }
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Added more money!");
    }
    
    public void buyBottle(int bottleNum) {
        if (bottles == 0) {
            System.out.println("There are no bottles left in the dispenser. :(");
        } else if (money < bottle_array.get(bottleNum).getPrice()) {
            System.out.println("Add money first!");
        } else {
            bottles -= 1; //number of bottles reduced
            money -= bottle_array.get(bottleNum).getPrice();
            System.out.println("KACHUNK! " + bottle_array.get(bottleNum).getName() + " came out of the dispenser!");
            bottle_array.remove(bottleNum); //removes bottle from the machine's list        
        }
    }
    
    public void returnMoney() {
        System.out.printf("Klink klink. Money came out! You got %.2f€ back\n", money);
        money = 0;
    }


}