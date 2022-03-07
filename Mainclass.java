import java.util.Scanner;

public class Mainclass {
    public static void main(String[] args) {
        int choice, moneyAmount, creditLimit;
        String accNumber;
        
        Scanner sc1 = new Scanner(System.in);


        while (true) {
        System.out.println("\n*** BANK SYSTEM ***");
        System.out.println("1) Add a regular account");
        System.out.println("2) Add a credit account");
        System.out.println("3) Deposit money");
        System.out.println("4) Withdraw money");
        System.out.println("5) Remove an account");
        System.out.println("6) Print account information");
        System.out.println("7) Print all accounts");
        System.out.println("0) Quit");
        System.out.print("Your choice: ");
        choice = sc1.nextInt();
        Scanner sc2 = new Scanner(System.in);
        switch(choice) {
            case 0:
                return;
            case 1:
                System.out.print("Give an account number: ");
                accNumber = sc2.nextLine();
                System.out.print("Amount of money to deposit: ");
                moneyAmount = sc2.nextInt();
                System.out.println("Account number: " + accNumber);
                System.out.println("Amount of money: " + moneyAmount);
                break;
            case 2:
                System.out.print("Give an account number: ");
                accNumber = sc2.nextLine();
                System.out.print("Amount of money to deposit: ");
                moneyAmount = sc2.nextInt();
                System.out.print("Give a credit limit: ");
                creditLimit = sc2.nextInt();
                System.out.println("Account number: " + accNumber);
                System.out.println("Amount of money: " + moneyAmount);
                System.out.println("Credit: " + creditLimit);
                break;
            case 3:
                System.out.print("Give an account number: ");
                accNumber = sc2.nextLine();
                System.out.print("Amount of money to deposit: ");
                moneyAmount = sc2.nextInt();
                System.out.println("Account number: " + accNumber);
                System.out.println("Amount of money: " + moneyAmount);
                break;
            case 4:
                System.out.print("Give an account number: ");
                accNumber = sc2.nextLine();
                System.out.print("Amount of money to withdraw: ");
                moneyAmount = sc2.nextInt();
                System.out.println("Account number: " + accNumber);
                System.out.println("Amount of money: " + moneyAmount);
                break;
            case 5:
                System.out.print("Give the account number of the account to delete: ");
                accNumber = sc2.nextLine();
                System.out.println("Account number: " + accNumber);
                break;
            case 6:
                System.out.print("Give the account number of the account to print information from: ");
                accNumber = sc2.nextLine();
                System.out.println("Account number: " + accNumber);
                break;
            case 7:
                System.out.println("Prints every account");
                break;
            default:
                System.out.println("Invalid choice.");
        }
        }
    }
}
