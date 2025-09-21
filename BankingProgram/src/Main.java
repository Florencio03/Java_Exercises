import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    //TODO:
    //DECLARE VARIABLES

    //DISPLAY MANU

    //GET AND PROCESS USER CHOICE

    //Create a methods: showBalance(), deposit(), withdraw()

    //EXIT MASSAGE

    public static void main(String[] args) {


        double balance = 0;
        boolean isRunning = true;

        System.out.println("**********************");
        System.out.println("BANKING PROGRAM");
        System.out.println("**********************");

        while (isRunning){
            //System.out.println();
            System.out.println(
                    "\nPress 1 to Show Balance" +
                            "\n2 Make a deposit" +
                            "\n3 Withdraw" +
                            "\n4 Exit");

            String userAction = scanner.nextLine();

            switch (userAction){
                case "1" -> showBalance(balance);
                case "2" -> System.out.printf("Your new balance is $%.2f ", balance += deposit());
                case "3" -> System.out.printf("Your new balance is $%.2f ", balance = balance - withdraw(balance));
                case "4" -> isRunning = false;
                default -> System.out.println("Invalid input.");
            }

        }

    }
    static void showBalance(double balance){
        System.out.printf("Your current balance is $%.2f ", balance);
        System.out.println();
    }

    static double deposit(){
        System.out.println("Enter the amount that you want to add to your account");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (amount < 0 ){
            System.out.println("Amount can't be negative");
            return 0;
        }else {
            return amount;
        }
    }

    static double withdraw(double balance){
        System.out.println("Enter the amount that you want to withdraw from your account");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        if (amount > balance){
            System.out.println("Insufficient funds");
            return 0;
        } else if (amount < 0 ){
            System.out.println("Amount can't be negative");
            return 0;
        }else {
            return amount;
        }

    }

}
