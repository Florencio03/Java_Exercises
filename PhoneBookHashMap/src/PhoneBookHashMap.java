import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class PhoneBookHashMap {
    private static boolean isNameValid(String name) {
        if (name.matches("^[a-zA-Z' -]+$") == false) {
            System.out.println("Invalid name!");
            return false;
        }
        return true;
    }
    private static boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.matches("\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}") == false) {
            System.out.println("Invalid phone number!");
            return false;
        }
        return true;
    }
    public static void main(String s[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            HashMap<String, String> phonebook = new HashMap<>();
            while (true) {
                // Display the menu options to the user
                System.out.println(
                        "Press 1 to add an entry in the phonebook," +
                                "\n2 to view all the entries" +
                                "\n3 to search for entries with name" +
                                "\n4 to delete an entry" +
                                "\n5 to sort the entries by name" +
                                "\n6 to write the entries onto a file" +
                                "\nAny other key to exit");
                String userAction = scanner.nextLine();
                if (userAction.equals("1")) {
                    System.out.println("Enter a name");
                    String name = scanner.nextLine();
                    if (!isNameValid(name)) {
                        continue;
                    }
                    if (phonebook.containsKey(name)) {
                        System.out.println("This name already exists! Do you want to replace the number? y/n");
                        String repChoice = scanner.nextLine();
                        if (repChoice.equalsIgnoreCase("n")) {
                            continue;
                        }
                    }
                    System.out.println("Enter the phone number");
                    String phoneNumber = scanner.nextLine();
                    if (!isPhoneNumberValid(phoneNumber)) {
                        continue;
                    }
                    phonebook.put(name, phoneNumber);
                    System.out.println("The name and number have been added to the phonebook.");
                }
                else if (userAction.equals("2")) {
                    System.out.println("--------------------");

                    for (String name : phonebook.keySet()) {
                        System.out.println(name + ": " + phonebook.get(name));
                    }
                    System.out.println("--------------------");
                }

                else if (userAction.equals("3")) {

                    System.out.println("Enter the name you want to search");
                    String keyName = scanner.nextLine();

                    if (phonebook.containsKey(keyName)) {

                        System.out.println("The phone number you are looking for is " +
                                phonebook.get(keyName));
                    } else {
                        System.out.println("No such name found in the phonebook.");
                    }
                }

                else if (userAction.equals("4")) {

                    System.out.println("Enter the name you want to delete ");
                    String keyName = scanner.nextLine();

                    if (phonebook.containsKey(keyName)) {

                        phonebook.remove(keyName);
                        System.out.println("The entry has been removed.");
                    } else {
                        System.out.println("No such name found in the phonebook.");
                    }
                }

                else if (userAction.equals("5")) {

                    TreeMap phoneBookTreeMap = new TreeMap<String,String>(phonebook);
                    for (Object keyName : phoneBookTreeMap.keySet()) {
                        System.out.println(keyName + ": " + phoneBookTreeMap.get((String)keyName));
                    }
                }

                else if (userAction.equals("6")) {

                    try (PrintWriter writer = new PrintWriter(new FileWriter("phonebook.txt"))) {
                        for (String name : phonebook.keySet()) {
                            writer.println(name + ": " + phonebook.get(name));
                        }
                        System.out.println("The entries are written to a file");
                    } catch (IOException e) {
                        System.err.println("Error writing to file: " + e.getMessage());
                    }
                }

                else {
                    break;
                }
            }
        } catch (NumberFormatException nfe) {
            
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}