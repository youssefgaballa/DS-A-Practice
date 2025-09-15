import java.util.Random;

/*
 * Contains all the sorting algorithms for this assignment.
 */
public class Sorting {
    public static long comparisons;

    /*
     * Same as quickSort_fp except uses a random integer as the pivot.
     */
    public static void quickSort_rp(Integer[] array, int first, int last) {
        int splitPoint;
        if (first < last) {
            splitPoint = split_rp(array, first, last);
            quickSort_rp(array, first, splitPoint - 1);
            quickSort_rp(array, splitPoint + 1, last);
        }
    }

    /*
     * Same as split_fp except uses a random integer as the pivot
     * then swaps it with first.
     */
    private static int split_rp(Integer[] array, int first, int last) {
        //int pivot = (int) (Math.random() * (last - first + 1)) + first;
        Random random = new Random();
        int pivot = random.nextInt((last - first) + 1) + first;
        int splitValue = array[pivot]; // pivot is the first element
        //System.out.println("Debug: Random Pivot Value: " + pivot);
        swap(array, pivot, first);
        int saveFirst = first;
        boolean onCorrectSide;
        first++;
        do {
            onCorrectSide = true;
            while (onCorrectSide) { // finds a value less than the pivot using first.
                if (array[first] > splitValue) {
                    onCorrectSide = false;
                } else {
                    first++;
                    onCorrectSide = (first <= last);
                }
                comparisons++;
            }
            onCorrectSide = (first <= last);
            while (onCorrectSide) { // finds a value greater than or equal to the pivot using last.
                if (array[last] <= splitValue) {
                    onCorrectSide = false;
                } else {
                    last--;
                    onCorrectSide = (first <= last);
                }
                comparisons++;
            }
            if (first < last) {
                swap(array, first, last);
                first++;
                last--;
            }
            comparisons++;
        } while (first <= last);
        int splitPoint = last;
        swap(array, saveFirst, splitPoint);
        return splitPoint;
    }

    /*
     * Partitions the array using split_fp then calls
     * quickSort_fp on each partition. Ends when first is greater than or equal to last.
     */
    public static void quickSort_fp(Integer[] array, int first, int last) {
        int splitPoint;
        if (first < last) {
            splitPoint = split_fp(array, first, last);
            quickSort_fp(array, first, splitPoint - 1);
            quickSort_fp(array, splitPoint + 1, last);
        }
    }

    /*
     * Splits the array into two partitions, where the left partition
     * contains all the ints less than the splitpoint, and the right partition
     * contains all the ints greater than the splitpoint.
     */
    private static int split_fp(Integer[] array, int first, int last) {
        int splitValue = array[first]; // pivot is the first element
        int saveFirst = first;
        boolean onCorrectSide;
        first++;
        do {
            onCorrectSide = true;
            while (onCorrectSide) { // finds a value less than the pivot using first.
                if (array[first] > splitValue) {
                    onCorrectSide = false;
                } else {
                    first++;
                    onCorrectSide = (first <= last);
                }
                comparisons++;
            }
            onCorrectSide = (first <= last);
            while (onCorrectSide) { // finds a value greater than or equal to the pivot using last.
                if (array[last] <= splitValue) {
                    onCorrectSide = false;
                } else {
                    last--;
                    onCorrectSide = (first <= last);
                }
                comparisons++;
            }
            if (first < last) {
                swap(array, first, last);
                first++;
                last--;
            }
            comparisons++;
        } while (first <= last);
        int splitPoint = last;
        swap(array, saveFirst, splitPoint);
        return splitPoint;
    }

    /*
     * Creates a heap out of the array, then sorts the array by swapping the
     * smallest value with the largest value in the unsorted part of the array,
     * then calling reheapdown to put the largest value in the right spot.
     */
    public static void heapSort(Integer[] array, int numValues) {
        int index;
        // Create a heap
        for (index = numValues/2 - 1; index >= 0; index--) {
            reheapDown(array, index, numValues - 1);
        }
        // since values are in descending order, we need to flip the array
        for (index = numValues - 1; index >= 1; index--) {
            swap(array, 0, index);
            reheapDown(array, 0, index - 1);
        }
    }

    /*
     * Puts root into the right part of the heap so the order property of
     * the heap is satisfied.
     */
    private static void reheapDown(Integer[] array, int root, int bottom) {
        int maxChild, rightChild, leftChild;
        leftChild = root * 2 + 1;
        rightChild = root * 2 + 2;
        if (leftChild <= bottom) {

            if (leftChild == bottom) {
                comparisons++;
                maxChild = leftChild;
            } else {
                comparisons++;
                if (array[leftChild] <= array[rightChild]) {
                    maxChild = rightChild;
                } else {
                    maxChild = leftChild;
                }

            }
            if (array[root] < array[maxChild]) {
                comparisons++;
                swap(array, root, maxChild);
                reheapDown(array, maxChild, bottom);
            }

        }

    }


    /*
     * Calls merge sort on the first half and right half of the array, then uses
     * the merge function to sort the array and recombine the halves.
     */
    public static void mergeSort(Integer[] array, int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(array, first, middle);
            mergeSort(array, middle + 1, last);
            merge(array, first, middle, middle + 1, last);
        }
    }

    /*
     * Sorts the array into a temp array then copy the temp array to the actual array
     * to complete the merge.
     */
    private static void merge(Integer[] array, int leftFirst, int leftLast,
                              int rightFirst, int rightLast) {
        Integer[] tempArray = new Integer[array.length];
        int index = leftFirst;
        int saveFirst = leftFirst;
        while ( (leftFirst <= leftLast) && (rightFirst <= rightLast) ) {
            comparisons++;
            if (array[leftFirst] < array[rightFirst]) {
                tempArray[index] = array[leftFirst];
                leftFirst++;
            } else {
                tempArray[index] = array[rightFirst];
                rightFirst++;
            }
            index++;
        }
        // Copy the remaining elements if there is any
        while (leftFirst <= leftLast) {
            tempArray[index] = array[leftFirst];
            leftFirst++;
            index++;
        }
        while (rightFirst <= rightLast) {
            tempArray[index] = array[rightFirst];
            rightFirst++;
            index++;
        }
        // Copy over the temp array
        for (index = saveFirst; index <= rightLast; index++) {
            array[index] = tempArray[index];
        }
    }

    /*
     * Swaps each element in the array with the minimum element after
     * that element in a loop.
     */
    public static void selectionSort(Integer[] array) {
        int endIndex = array.length - 1;
        for (int current = 0; current < endIndex; current++) {
            //System.out.println("current " + current);
            swap(array, current, minIndex(array, current, endIndex));
        }

    }

    /*
     * Helper function that swaps index1 and index2 in array.
     */
    private static void swap(Integer[] array, int index1, int index2) {
        //System.out.println("Swapping " + index1 + " with " + index2);
        int value1 = array[index1];
        array[index1] = array[index2];
        array[index2] = value1;
        //printArray();
    }

    /*
     * Finds the minIndex of the array specified by start and end.
     */
    private static int minIndex(Integer[] array, int start, int end) {
        int indexOfMin = start;
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < array[indexOfMin]) {
                indexOfMin = i;
            }
            comparisons++;
        }
        return indexOfMin;
    }

    /*
     * Helper function that simply prints the contents of the
     * array from index 0 to array.size - 1.
     */
    public static void printArray(Integer[] array) {
        //System.out.print("[" + array[0]);
        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            //System.out.print(", " + array[i]);
            System.out.print(" " + array[i]);
        }
        //System.out.println("]");
        System.out.println();

    }

}
