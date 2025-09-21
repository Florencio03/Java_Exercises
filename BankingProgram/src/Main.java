import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //TODO:
    //DECLARE VARIABLES

    //DISPLAY MANU

    //GET AND PROCESS USER CHOICE

   //Create a methods: showBalance(), deposit(), withdraw()

    //EXIT MASSAGE

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //double balance;
        try {
            Scanner scanner = new Scanner(System.in);
            double balance;
            boolean isRunning = true;

            System.out.println("**********************");
            System.out.println("BANKING PROGRAM");
            System.out.println("**********************");

            while (isRunning){
                System.out.println(
                        "Press 1 to Show Balance" +
                                "\n2 Make a deposit" +
                                "\n3 Withdraw" +
                                "\n4 Exit");

                String userAction = scanner.nextLine();

                switch (userAction){
                    case "1" -> System.out.println("Show BALANCE");
                    case "2" -> System.out.println("DEPOSIT");
                    case "3" -> System.out.println("WITHDRAW");
                    case "4" -> isRunning = false;
                    default -> System.out.println("Invalid input.");
                }

            }

        }catch (InputMismatchException e){
            System.out.println("Invalid input.");
        }



    }

}
