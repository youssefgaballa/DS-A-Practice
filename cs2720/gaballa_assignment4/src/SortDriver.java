import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 * Contains the code for the first experiment.
 */
public class SortDriver {

/*
* Reads the contents of a file and puts the integers in
* the file into an array, then it prompts the user for an
* algorithm, then it sorts the array and outputs it along with
* the number of comparisons and then terminates.
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
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (fileStream.hasNextInt()) {
            arrayList.add(fileStream.nextInt());
        }

        Integer[] array = arrayList.toArray(new Integer[]{});
        //System.out.print("debug: ");
        //Sorting.printArray(array);

        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) "
                           + "quick-sort-fp (q) quick-sort-rp (r)");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the algorithm: ");
        String algoType;
        algoType = keyboard.next();
        if (algoType.equals("s")) { // selection-sort
            Sorting.selectionSort(array);
            Sorting.printArray(array);
            System.out.println("#Selection-sort comparisons: " + Sorting.comparisons);
        } else if (algoType.equals("m")) { // merge-sort
            Sorting.mergeSort(array, 0, array.length - 1);
            Sorting.printArray(array);
            System.out.println("#Merge-sort comparisons: " + Sorting.comparisons);
        } else if (algoType.equals("h")) { // heap-sort
            Sorting.heapSort(array, array.length);
            Sorting.printArray(array);
            System.out.println("#Heap-sort comparisons: " + Sorting.comparisons);
        } else if (algoType.equals("q")) { // quick-sort-fp
            Sorting.quickSort_fp(array, 0, array.length - 1);
            Sorting.printArray(array);
            System.out.println("#Quick-sort-fp comparisons: " + Sorting.comparisons);
        } else if (algoType.equals("r")) { // quick-sort-rp
            Sorting.quickSort_rp(array, 0, array.length - 1);
            Sorting.printArray(array);
            System.out.println("#Quick-sort-rp comparisons: " + Sorting.comparisons);
        } else { //invalid algorithm
            System.out.println("Invalid command.");
        }
    }

}
