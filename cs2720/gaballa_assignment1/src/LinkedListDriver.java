import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;

/*
 * Reads a file and initializes a list to the contents of the textfile.
 * Processes the command line arguments for each public method in SortedLinkedList.java.
 */
public class LinkedListDriver {

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
        SortedLinkedList list = new SortedLinkedList();
        while(fileStream.hasNextInt()) {
            list.insertItem(new ItemType(fileStream.nextInt()));
        }
        System.out.print("The list is: ");
        list.printAll();
        // Command line loop
        Scanner keyboard = new Scanner(System.in);
        while(true) {
            System.out.print("Enter a command: ");
            String command = keyboard.next();
            if (command.compareTo("q") == 0) { // Quit
                System.out.println("Exiting the program...");
                keyboard.close();
                System.exit(0);
            } else if (command.compareTo("p") == 0) { // Print
                System.out.print("The list is: ");
                list.printAll();
            } else if (command.compareTo("l") == 0) { // Length
                System.out.printf("The length of the list is %d\n", list.length());
            } else if (command.compareTo("i") == 0) { // Insert
                System.out.print("Enter a number to insert: ");
                int num = keyboard.nextInt();
                System.out.print("Original list : ");
                list.printAll();
                list.insertItem(new ItemType(num));
                System.out.print("New list : ");
                list.printAll();
            } else if (command.compareTo("d") == 0) { // Delete
                System.out.print("Enter a number to delete: ");
                int num = keyboard.nextInt();
                System.out.print("Original list : ");
                list.printAll();
                list.deleteItem(new ItemType(num));
                System.out.print("New list : ");
                list.printAll();
            } else if (command.compareTo("s") == 0) { // Search
                System.out.print("Enter a number to search: ");
                int num = keyboard.nextInt();
                System.out.print("Original list : ");
                list.printAll();
                list.searchItem(new ItemType(num));
            } else if (command.compareTo("a") == 0) { // Delete_alt
                System.out.print("Original list : ");
                list.printAll();
                list.deleteAlt();
                System.out.print("New list : ");
                list.printAll();
            } else if (command.compareTo("m") == 0) { // Merge
                System.out.print("Enter the length of the new list: ");
                int length = keyboard.nextInt();
                SortedLinkedList newList = new SortedLinkedList();
                System.out.print("Enter the numbers: ");
                for (int i = 0; i < length; i++) {
                    newList.insertItem(new ItemType(keyboard.nextInt()));
                }
                System.out.print("list 1: ");
                list.printAll();
                System.out.print("list 2: ");
                newList.printAll();
                list.mergeList(newList);
                System.out.print("Merged list: ");
                newList.printAll();
            } else if (command.compareTo("t") == 0) { // Intersection
                System.out.print("Enter the length of the new list: ");
                int length = keyboard.nextInt();
                SortedLinkedList newList = new SortedLinkedList();
                System.out.print("Enter the numbers: ");
                for (int i = 0; i < length; i++) {
                    newList.insertItem(new ItemType(keyboard.nextInt()));
                }
                System.out.print("list 1: ");
                list.printAll();
                System.out.print("list 2: ");
                newList.printAll();
                System.out.print("Intersection of the lists: ");
                list.intersection(newList).printAll();
            } else { // Invalid Command
                System.out.println("Invalid command try again: ");
            }
        }
    }
}
