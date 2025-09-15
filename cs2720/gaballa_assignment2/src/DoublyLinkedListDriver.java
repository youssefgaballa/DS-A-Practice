import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;

/*
 * Reads a file and initializes a list to the contents of the textfile.
 * Processes the command line arguments for each public method in SortedLinkedList.java.
 */
public class DoublyLinkedListDriver {

    /*
     * Processes the command line arguments for the text file
     * which is to be converted to a doublyLinkedList.
     * Processes the inputs to determine how to mainpulate the list
     * or display the list (for print functions).
     */
    public static void main(String[] args) {
        //Reading the file inputs and putting them into a list.
        String fileName = args[0];
        Scanner fileStream = null;
        try {
            fileStream = new Scanner(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found.");
            System.exit(0);
        }
        Scanner keyboard = new Scanner(System.in);
        DoublyLinkedList<Integer> integerList = null;
        DoublyLinkedList<Double> doubleList = null;
        DoublyLinkedList<String> stringList = null;
        System.out.print("Enter list type (i - Integer, d - Double, s - String): ");
        String type = keyboard.next();
        if (type.equals("i")) {
            integerList = new DoublyLinkedList<Integer>();
            while(fileStream.hasNextInt()) {
                integerList.insertItem(fileStream.nextInt());
            }
        } else if (type.equals("d")) {
            doubleList = new DoublyLinkedList<Double>();
            while(fileStream.hasNextDouble()) {
                doubleList.insertItem(fileStream.nextDouble());
            }
        } else if (type.equals("s")) {
            stringList = new DoublyLinkedList<String>();
            while(fileStream.hasNext()) {
                stringList.insertItem(fileStream.next());
            }
        } else {
            return;
        }
        System.out.print("The list is: ");

        if (type.equals("i")) {
            integerList.printAll();
        } else if (type.equals("d")) {
            doubleList.printAll();
        } else if (type.equals("s")) {
            stringList.printAll();
        }

        // Command line loop
        while(true) {
            System.out.print("Enter a command: ");
            String command = keyboard.next();
            if (command.compareTo("q") == 0) { // Quit
                System.out.println("Exiting the program...");
                keyboard.close();
                System.exit(0);
            } else if (command.compareTo("p") == 0) { // Print
                System.out.print("The list is: ");
                if (type.equals("i")) {
                    integerList.printAll();
                } else if (type.equals("d")) {
                    doubleList.printAll();
                } else if (type.equals("s")) {
                    stringList.printAll();
                }
            } else if (command.compareTo("t") == 0) { // Print Reverse
                System.out.print("The reverse list: ");
                if (type.equals("i")) {
                    integerList.printReverse();
                } else if (type.equals("d")) {
                    doubleList.printReverse();
                } else if (type.equals("s")) {
                    stringList.printReverse();
                }
            } else if (command.compareTo("l") == 0) { // Length
                int length = 0;
                if (type.equals("i")) {
                    length = integerList.length();
                } else if (type.equals("d")) {
                    length = doubleList.length();
                } else if (type.equals("s")) {
                    length = stringList.length();
                }
                System.out.printf("The length of the list is %d\n", length);
            } else if (command.compareTo("i") == 0) { // Insert
                System.out.print("The list is : ");
                if (type.equals("d")) {
                    doubleList.printAll();
                    System.out.print("Enter a number to insert: ");
                    Double num = keyboard.nextDouble();
                    doubleList.insertItem(num);
                    System.out.print("The list is : ");
                    doubleList.printAll();
                    System.out.print("The reverse list : ");
                    doubleList.printReverse();
                } else if (type.equals("i")) {
                    integerList.printAll();
                    System.out.print("Enter a number to insert: ");
                    Integer num = keyboard.nextInt();
                    integerList.insertItem(num);
                    System.out.print("The list is : ");
                    integerList.printAll();
                    System.out.print("The reverse list : ");
                    integerList.printReverse();
                } else if (type.equals("s")) {
                    stringList.printAll();
                    System.out.print("Enter a string to insert: ");
                    String str = keyboard.next();
                    stringList.insertItem(str);
                    System.out.print("The list is : ");
                    stringList.printAll();
                    System.out.print("The reverse list : ");
                    stringList.printReverse();
                }
            } else if (command.compareTo("d") == 0) { // Delete
                System.out.print("The list is : ");
                if (type.equals("d")) {
                    doubleList.printAll();
                    System.out.print("Enter a number to delete: ");
                    Double num = keyboard.nextDouble();
                    if (doubleList.isEmpty()) {
                        System.out.println("You cannot delete from an empty list");
                    } else {
                        doubleList.deleteItem(num);
                        System.out.print("New list : ");
                        doubleList.printAll();
                        System.out.print("The reverse list : ");
                        doubleList.printReverse();
                    }
                } else if (type.equals("i")) {
                    integerList.printAll();
                    System.out.print("Enter a number to delete: ");
                    Integer num = keyboard.nextInt();
                    if (integerList.isEmpty()) {
                        System.out.println("You cannot delete from an empty list");
                    } else {
                        integerList.deleteItem(num);
                        System.out.print("New list : ");
                        integerList.printAll();
                        System.out.print("The reverse list : ");
                        integerList.printReverse();
                    }
                } else if (type.equals("s")) {
                    stringList.printAll();
                    System.out.print("Enter a string to delete: ");
                    String str = keyboard.next();
                    if (stringList.isEmpty()) {
                        System.out.println("You cannot delete from an empty list");
                    } else {
                        stringList.deleteItem(str);
                        System.out.print("New list : ");
                        stringList.printAll();
                        System.out.print("The reverse list : ");
                        stringList.printReverse();
                    }
                }

            } else if (command.compareTo("b") == 0) { // Delete_Subsection
                if (type.equals("d")) {
                    System.out.print("Enter the lower bound: ");
                    Double lower = keyboard.nextDouble();
                    System.out.print("Enter the upper bound: ");
                    Double upper = keyboard.nextDouble();
                    System.out.print("The original list: ");
                    doubleList.printAll();
                    doubleList.deleteSubsection(lower, upper);
                    System.out.print("The modified list: ");
                    doubleList.printAll();
                    System.out.print("The reverse list : ");
                    doubleList.printReverse();
                } else if (type.equals("i")) {
                    System.out.print("Enter the lower bound: ");
                    Integer lower = keyboard.nextInt();
                    System.out.print("Enter the upper bound: ");
                    Integer upper = keyboard.nextInt();
                    System.out.print("The original list: ");
                    integerList.printAll();
                    integerList.deleteSubsection(lower, upper);
                    System.out.print("The modified list: ");
                    integerList.printAll();
                    System.out.print("The reverse list : ");
                    integerList.printReverse();
                } else if (type.equals("s")) {
                    System.out.print("Enter the lower bound: ");
                    String lower = keyboard.next();
                    System.out.print("Enter the upper bound: ");
                    String upper = keyboard.next();
                    System.out.print("The original list: ");
                    stringList.printAll();
                    stringList.deleteSubsection(lower, upper);
                    System.out.print("The modified list: ");
                    stringList.printAll();
                    System.out.print("The reverse list : ");
                    stringList.printReverse();
                }

            } else if (command.compareTo("r") == 0) { // Reverse list
                System.out.print("The original list: ");
                if (type.equals("d")) {
                    doubleList.printAll();
                    doubleList.reverseList();
                    System.out.print("The reversed list : ");
                    doubleList.printAll();
                } else if (type.equals("i")) {
                    integerList.printAll();
                    integerList.reverseList();
                    System.out.print("The reversed list : ");
                    integerList.printAll();
                } else if (type.equals("s")) {
                    stringList.printAll();
                    stringList.reverseList();
                    System.out.print("The reversed list : ");
                    stringList.printAll();
                }
            } else if (command.compareTo("s") == 0) { // Swap Alternate
                System.out.print("The original list: ");
                if (type.equals("d")) {
                    doubleList.printAll();
                    doubleList.swapAlternate();
                    System.out.print("The modified list: ");
                    doubleList.printAll();
                    System.out.print("The reverse list : ");
                    doubleList.printReverse();
                } else if (type.equals("i")) {
                    integerList.printAll();
                    integerList.swapAlternate();
                    System.out.print("The modified list: ");
                    integerList.printAll();
                    System.out.print("The reverse list : ");
                    integerList.printReverse();
                } else if (type.equals("s")) {
                    stringList.printAll();
                    stringList.swapAlternate();
                    System.out.print("The modified list: ");
                    stringList.printAll();
                    System.out.print("The reverse list : ");
                    stringList.printReverse();
                }

            } else { // Invalid Command
                System.out.println("Invalid command try again: ");
            }
        }

    }
}
