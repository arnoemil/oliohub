package Viikko2;

import java.util.Scanner;

public class Dog {
        
    private String name;
    private String says;
    private String line;

    public Dog(String n) {
        name = n;
        says = "Much wow!";
        if (n.isEmpty()) {
            name = "Doge";
        }
        System.out.println("Hey, my name is " + name);
    }

    public boolean speak(Scanner scan) {
        //System.out.println(!(scan.hasNext()));
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                System.out.println("Such integer: " + scan.nextInt());
                continue;
            } else if (scan.hasNextBoolean()) {
                System.out.println("Such boolean: " + scan.nextBoolean());
                continue;
            } else if (scan.hasNextLine()) {
                System.out.println(scan.next());
                continue;
            } 
            else if ((scan.hasNext()) == false) {
                break;
            }
        }
        return false;
        }
    }