import java.util.Random;
import java.util.Scanner;

/*
 * Class containing the experiments for the second part of the lab where plots need to be
 * generated.
 */
public class SortingExperiments {

    /*
     * Can run the experiments here by commenting out one of the experiment functions.
     */
    public static void main(String[] args) {
        // Experiment 1:
        // If you're usign MobaXterm, go to setting > configuration > terminal
        // then check "log output terminal to the following directory"
        // Start a new terminal, run ./experimentRun.sh with experiment1(); uncommented
        // with experiment0(); commented out. After the experiment the terminal output
        // will be in a file.
        //experiment1();

        //Experiment 0:
        // Another interface for grader to verify experiments.
        // More flexibly than experiment1() but slower since you have to
        // manually type the input size and sorting algorithm.
        experiment0();

        //only one of the experiment methods should be uncommented. not both.
    }

    /*
     * Generates an array of the given size with random integers
     * ranging from 0 to size - 1.
     */
    public static Integer[] generateRandArray(int size) {
        Integer[] array = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    /*
     * Prompts the user for the size of the array to be generated, then
     * creates the array of random integers then asks the user for a sorting algorithm,
     * then it sorts the array using the specified algorithm and outputs the array and
     * the number of comparisons. Then the loop runs again.
     */
    public static void experiment0() {
        Scanner keyboard = new Scanner(System.in);
        int size;
        Integer[] randArray;
        while (true) {
            System.out.print("Enter the size of the array: ");
            size = keyboard.nextInt();
            randArray = generateRandArray(size);
            System.out.print("debug: ");
            Sorting.printArray(randArray);
            System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) "
                               + "quick-sort-fp (q) quick-sort-rp (r) exit-program (e)");
            System.out.print("Enter the algorithm: ");
            String algoType;
            algoType = keyboard.next();
            if (algoType.equals("s")) { // selection-sort
                Sorting.selectionSort(randArray);
                Sorting.printArray(randArray);
                System.out.println("#Selection-sort comparisons: " + Sorting.comparisons);
            } else if (algoType.equals("m")) { // merge-sort
                Sorting.mergeSort(randArray, 0, randArray.length - 1);
                Sorting.printArray(randArray);
                System.out.println("#Merge-sort comparisons: " + Sorting.comparisons);
            } else if (algoType.equals("h")) { // heap-sort
                Sorting.heapSort(randArray, randArray.length);
                Sorting.printArray(randArray);
                System.out.println("#Heap-sort comparisons: " + Sorting.comparisons);
            } else if (algoType.equals("q")) { // quick-sort-fp
                Sorting.quickSort_fp(randArray, 0, randArray.length - 1);
                Sorting.printArray(randArray);
                System.out.println("#Quick-sort-fp comparisons: " + Sorting.comparisons);
            } else if (algoType.equals("r")) { // quick-sort-rp
                Sorting.quickSort_rp(randArray, 0, randArray.length - 1);
                Sorting.printArray(randArray);
                System.out.println("#Quick-sort-rp comparisons: " + Sorting.comparisons);
            } else if (algoType.equals("e")) { // exit-program
                System.exit(0);
            } else { //invalid algorithm
                System.out.println("Invalid command.");
            }
            Sorting.comparisons = 0;
        }
    }

    /*
     * Prompts the user for a algorithm, then it generates
     * many arrays of ascending sizes then sorts each of them then
     * outputs the array and the number of comparisons.
     * This function was used to get the data for the plots.
     * Though the other function could also be used to do the same thing,
     * albeit slower.
     */
    public static void experiment1() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) "
                           + "quick-sort-fp (q) quick-sort-rp (r) exit-program (e)");
        System.out.print("Enter the algorithm: ");
        String algoType;
        algoType = keyboard.next();
        int size = 10;
        Integer[] randArray;
        boolean moreToSearch = true;

        while (moreToSearch) {
            if (size == 10) {
                size += 90;
            } else if (size  == 100) {
                size += 150;
            } else if (size < 1000) {
                size += 250;
            } else if (size < 5000) {
                size += 500;
            } else if (size < 50000) {
                size += 1000;
            } else {
                size += 1000;
            }
            if (size > 50000) {
                moreToSearch = false;
            }


            randArray = generateRandArray(size);
            System.out.print("Unsorted Array: ");
            Sorting.printArray(randArray);

            if (algoType.equals("s")) { // selection-sort
                Sorting.selectionSort(randArray);
                System.out.print("Sorted Array: ");
                Sorting.printArray(randArray);
                System.out.println("Array size: " + size);
                System.out.println("#Selection-sort comparisons: " + Sorting.comparisons);
            } else if (algoType.equals("m")) { // merge-sort
                Sorting.mergeSort(randArray, 0, randArray.length - 1);
                System.out.print("Sorted Array: ");
                Sorting.printArray(randArray);
                System.out.println("Array size: " + size);
                System.out.println("#Merge-sort comparisons: " + Sorting.comparisons);
            } else if (algoType.equals("h")) { // heap-sort
                Sorting.heapSort(randArray, randArray.length);
                System.out.print("Sorted Array: ");
                Sorting.printArray(randArray);
                System.out.println("Array size: " + size);
                System.out.println("#Heap-sort comparisons: " + Sorting.comparisons);
            } else if (algoType.equals("q")) { // quick-sort-fp
                Sorting.quickSort_fp(randArray, 0, randArray.length - 1);
                System.out.print("Sorted Array: ");
                Sorting.printArray(randArray);
                System.out.println("Array size: " + size);
                System.out.println("#Quick-sort-fp comparisons: " + Sorting.comparisons);
            } else if (algoType.equals("r")) { // quick-sort-rp
                Sorting.quickSort_rp(randArray, 0, randArray.length - 1);
                System.out.print("Sorted Array: ");
                Sorting.printArray(randArray);
                System.out.println("Array size: " + size);
                System.out.println("#Quick-sort-rp comparisons: " + Sorting.comparisons);
            } else if (algoType.equals("e")) { // exit-program
                System.exit(0);
            } else { //invalid algorithm
                System.out.println("Invalid command.");
            }
            Sorting.comparisons = 0;
        }
    }
}
