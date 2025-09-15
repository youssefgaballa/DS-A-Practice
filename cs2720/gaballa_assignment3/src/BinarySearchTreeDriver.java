import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;

/*
 * Driver class for a BinarySearchTree
 */
public class BinarySearchTreeDriver {

    /*
     * Processes the command line arguments to initialize the tree
     * then processes the inputted commands in a loop.
     */
    public static void main(String[] args) {
        String fileName = args[0];
        Scanner fileStream = null;
        try {
            fileStream = new Scanner(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found.");
            System.exit(0);
        }
        Scanner keyboard = new Scanner(System.in);
        BinarySearchTree<Integer> integerTree = null;
        BinarySearchTree<Double> doubleTree = null;
        BinarySearchTree<String> stringTree = null;
        System.out.print("Enter list type (i - integer, d - Double, s - String): ");
        String type = keyboard.next();
        if (type.equals("i")) {
            integerTree = new BinarySearchTree<Integer>();
            while (fileStream.hasNextInt()) {
                integerTree.insert(fileStream.nextInt());
            }
        } else if (type.equals("d")) {
            doubleTree = new BinarySearchTree<Double>();
            while (fileStream.hasNextDouble()) {
                doubleTree.insert(fileStream.nextDouble());
            }
        } else if (type.equals("s")) {
            stringTree = new BinarySearchTree<String>();
            while (fileStream.hasNext()) {
                stringTree.insert(fileStream.next());
            }
        } else {
            return;
        }

        if (type.equals("i")) {
            integerTree.printTree();
        } else if (type.equals("d")) {
            doubleTree.printTree();
        } else if (type.equals("s")) {
            stringTree.printTree();
        }

        while (true) {
            System.out.print("Enter a command: ");
            String command = keyboard.next();
            if (command.compareTo("q") == 0) {
                System.out.println("Exiting the program...");
                keyboard.close();
                System.exit(0);
            } else if (command.compareTo("p") == 0) { // print

                if (type.equals("i")) {
                    integerTree.printTree();
                } else if (type.equals("d")) {
                    doubleTree.printTree();
                } else if (type.equals("s")) {
                    stringTree.printTree();
                }
            } else if (command.compareTo("i") == 0) { // insert

                if (type.equals("i")) {
                    integerTree.printTree();
                    System.out.print("Enter a number to insert: ");
                    Integer item = keyboard.nextInt();
                    integerTree.insert(item);
                    integerTree.printTree();
                } else if (type.equals("d")) {
                    doubleTree.printTree();
                    System.out.print("Enter a number to insert: ");
                    Double item = keyboard.nextDouble();
                    doubleTree.insert(item);
                    doubleTree.printTree();
                } else if (type.equals("s")) {
                    stringTree.printTree();
                    System.out.print("Enter a string to insert: ");
                    String item = keyboard.next();
                    stringTree.insert(item);
                    stringTree.printTree();
                }
            } else if (command.compareTo("r") == 0) { // search/retrieve
                if (type.equals("i")) {
                    integerTree.printTree();
                    System.out.print("Enter a number to search: ");
                    Integer item = keyboard.nextInt();
                    integerTree.retrieve(item);
                } else if (type.equals("d")) {
                    doubleTree.printTree();
                    System.out.print("Enter a number to search: ");
                    Double item = keyboard.nextDouble();
                    doubleTree.retrieve(item);
                } else if (type.equals("s")) {
                    stringTree.printTree();
                    System.out.print("Enter a string to search: ");
                    String item = keyboard.next();
                    stringTree.retrieve(item);
                }
            } else if (command.compareTo("d") == 0) { //delete
                if (type.equals("i")) {
                    integerTree.printTree();
                    System.out.print("Enter a number to delete: ");
                    Integer item = keyboard.nextInt();
                    if (integerTree.search(item)) {
                        integerTree.delete(item);
                        integerTree.printTree();
                    } else {
                        System.out.println("The number is not present in the tree.");
                    }
                } else if (type.equals("d")) {
                    doubleTree.printTree();
                    System.out.print("Enter a number to delete: ");
                    Double item = keyboard.nextDouble();
                    if (doubleTree.search(item)) {
                        doubleTree.delete(item);
                        doubleTree.printTree();
                    } else {
                        System.out.println("The number is not present in the tree.");
                    }
                } else if (type.equals("s")) {
                    stringTree.printTree();
                    System.out.print("Enter a string to delete: ");
                    String item = keyboard.next();
                    if (stringTree.search(item)) {
                        stringTree.delete(item);
                        stringTree.printTree();
                    } else {
                        System.out.println("The string is not present in the tree.");
                    }
                }
            } else if (command.compareTo("l") == 0) { // count leaf nodes
                if (type.equals("i")) {
                    System.out.println("The number of leaf nodes are "
                                     + integerTree.getNumLeafNodes());
                } else if (type.equals("d")) {
                    System.out.println("The number of leaf nodes are "
                                     + doubleTree.getNumLeafNodes());
                } else if (type.equals("s")) {
                    System.out.println("The number of leaf nodes are "
                                     + stringTree.getNumLeafNodes());
                }
            } else if (command.compareTo("s") == 0) { // single-parents
                if (type.equals("i")) {
                    integerTree.getSingleParents();
                } else if (type.equals("d")) {
                    doubleTree.getSingleParents();
                } else if (type.equals("s")) {
                    stringTree.getSingleParents();
                }
            } else if (command.compareTo("c") == 0) { // find cousins
                if (type.equals("i")) {
                    integerTree.printTree();
                    System.out.print("Enter a number: ");
                    Integer item = keyboard.nextInt();
                    if (integerTree.search(item)) {
                        integerTree.getCousins(item);
                    } else {
                        System.out.println("The number is not present in the tree.");
                    }
                } else if (type.equals("d")) {
                    doubleTree.printTree();
                    System.out.print("Enter a number: ");
                    Double item = keyboard.nextDouble();
                    if (doubleTree.search(item)) {
                        doubleTree.getCousins(item);
                    } else {
                        System.out.println("The number is not present in the tree.");
                    }
                } else if (type.equals("s")) {
                    stringTree.printTree();
                    System.out.print("Enter a string: ");
                    String item = keyboard.next();
                    if (stringTree.search(item)) {
                        stringTree.getCousins(item);
                    } else {
                        System.out.println("The string is not present in the tree.");
                    }
                }
            } else {
                System.out.println("Invalid command try again: ");
            }

        }
    }
}
