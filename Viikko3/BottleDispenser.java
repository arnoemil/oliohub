package Viikko3;

public class BottleDispenser {
    private int bottles;
    private Bottle[] bottle_array;
    private int money;
    
    public BottleDispenser() {
        bottles = 50;
        money = 0;
        
        // Initialize the array
        bottle_array = new Bottle[bottles];
        // Add Bottle-objects to the array
        for(int i = 0;i<bottles;i++) {
            // Use the default constructor to create new Bottles
            bottle_array[i] = new Bottle("Pepsi Max", "Pepsi", 0.3f);
        }
    }
    
    public void addMoney() {
        money += 1;
        System.out.println("Klink! Added more money!");
    }
    
    public void buyBottle() {
        if (bottles == 0) {
            System.out.println("There are no bottles left in the dispenser. :(");
        } else if (money == 0) {
            System.out.println("Add money first!");
        } else {
        bottles -= 1;
        money -= 1;
        System.out.println("KACHUNK! " + bottle_array[bottles].getName() + " came out of the dispenser!");        
        }
    }
    
    public void returnMoney() {
        money = 0;
        System.out.println("Klink klink. Money came out!");
    }
}