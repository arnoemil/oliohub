package Viikko2;

import java.util.Scanner;

class Mainclass {
    public static void main(String[] args) {
        String dogName;
        //String dogSays;

        System.out.print("Give a name to the dog: ");
        Scanner sc = new Scanner(System.in);
        dogName = sc.nextLine();
        
        Dog dog = new Dog(dogName.trim());



        System.out.print("What does a dog say: ");
        Scanner scan2 = new Scanner(System.in);
        dog.speak(scan2);

    }
}