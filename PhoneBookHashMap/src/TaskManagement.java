import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskManagement {
    public static void main(String s[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            HashMap<String, Task> taskBook = new HashMap<>();
            while (true) {

                System.out.println(
                        "Press 1 to add an entry in the Taskbook," +
                                "\n2 to view all the tasks" +
                                "\n3 to search for tasks with name" +
                                "\n4 to update an entry" +
                                "\n5 to delete a task" +
                                "\n6 to sort the status of the task" +
                                "\n7 to write the tasks onto a file" +
                                "\nAny other key to exit");

                String userAction = scanner.nextLine();

                if (userAction.equals("1")) {

                    System.out.println("Enter a name");
                    String taskName = scanner.nextLine();

                    if (taskBook.containsKey(taskName)) {
                        System.out.println("This name already exists! Do you want to replace the number? y/n");
                        String repChoice = scanner.nextLine();

                        if (repChoice.equalsIgnoreCase("n")) {
                            continue;
                        }
                    }

                    System.out.println("Enter the task description");
                    String description = scanner.nextLine();

                    System.out.println("Enter Priority - 1 Low, 2 Medium, 3 High ");
                    int priority = Integer.parseInt(scanner.nextLine());
                    priority = (priority > 3) ? 1 : priority;

                    taskBook.put(taskName, new Task(taskName, description, priority));
                    System.out.println("The task has been added to the Task book.");
                }

                else if (userAction.equals("2")) {
                    for (String taskName : taskBook.keySet()) {
                        System.out.println(taskName + ": " + taskBook.get(taskName));
                    }
                }
                else if (userAction.equals("3")) {

                    System.out.println("Enter the task name you want to search");
                    String keyName = scanner.nextLine();
                    if (taskBook.containsKey(keyName)) {

                        System.out.println("The task associated with the name is " +
                                taskBook.get(keyName));
                    } else {
                        System.out.println("No such task found in the task book.");
                    }
                }

                else if (userAction.equals("4")) {

                    System.out.println("Enter the name of the task you want to update ");
                    String keyName = scanner.nextLine();

                    if (taskBook.containsKey(keyName)){
                        System.out.println("Enter the new status for the task P for 'In Progress' or C for 'Completed'");

                        String updatedStatus = scanner.nextLine();


                        if(updatedStatus.equalsIgnoreCase("P")){
                            taskBook.get(keyName).setStatus(Task.IN_PROGRESS);
                        } else if (updatedStatus.equalsIgnoreCase("C")) {
                            taskBook.get(keyName).setStatus(Task.COMPLETED);
                        }
                        System.out.println("The task has been updated");
                    }else {
                        System.out.println("No such task found in the taskBook.");
                    }
                }

                else if (userAction.equals("5")) {

                    System.out.println("Enter the name of the task you want to delete ");
                    String keyName = scanner.nextLine();

                    if (taskBook.containsKey(keyName)) {

                        taskBook.remove(keyName);
                        System.out.println("The entry has been removed.");
                    } else {
                        System.out.println("No such task found in the phonebook.");
                    }
                }

                else if (userAction.equals("6")) {

                    TreeMap <String, Task> SortedTasks= new TreeMap<>(taskBook);
                    for (Object keyName : SortedTasks.keySet()) {
                        System.out.println(keyName + ": " + SortedTasks.get((String)keyName));
                    }
                }

                else if (userAction.equals("7")) {

                    try (PrintWriter writer = new PrintWriter(new FileWriter("taskBook.txt"))) {
                        for (String name : taskBook.keySet()) {
                            writer.println(name + ": " + taskBook.get(name));
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
