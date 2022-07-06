package basic;

import utility.SortingUtilities;

/**
 * This program will have the logic behind the methods that sort the arrays provided
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class BasicSorts {

    /**
     * Sorts an array that has been passed in by using bubble sort, identifies the largest element
     * by swapping adjacent elements, and places it at the end of the array
     *
     * @param array Takes in an array as a parameter
     */
    public static void bubbleSort(int[] array) {
        // loop each pass over the array
        for (int i = 0; i < array.length; i++) {
            // optimize in case array is sorted early
            boolean swapped = false;
            // loop over elements for one "pass"
            for (int j = 0; j < array.length - i - 1; j++) {
                // if we find an inversion, swap them
                if(array[j] > array[j+1]) {
                    SortingUtilities.swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if(!swapped) {
                System.out.println("Stopped early!");
                return;
            }
        }
    }

    /**
     * Sorts the array passed in by using selection sort, scans for the smallest element then
     * places it in the smallest index
     *
     * @param array Takes in an array that it will sort
     */
    public static void selectionSort(int[] array) {
        // loop through array -1 because the last number should be sorted
        for (int i = 0; i < array.length - 1; i++) {
            // assign i as the smallest because we want to save the smallest number in the first index
            int smallest = i;
            // loop over elements for one "pass"
            for (int j = i+1; j < array.length; j++) {
                // if that number in the array is smaller than the smallest, go in
                if(array[j] < array[smallest]) {
                    // save that smallest index as the smallest overall
                    smallest = j;
                }
            }
            // swap the smallest with i, which would go from index 0 to index.length
            SortingUtilities.swap(array, i, smallest);
        }
    }

    /**
     * Sorts the array passed in by using insertion sort, maintains a partially sorted array during sorting
     *
     * @param array Takes in an array that it will sort
     */
    public static void insertionSort(int[] array){
        // start at the second element, don't have to sort the first one we get, think of poker
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            //start from the previous item
            int previous = i - 1;
            // while prev is greater than 0, and array at prev index is greater than current index, go in
            while (previous >= 0 && array[previous] > current){
                // this will move the larger number at index over to the right
                array[previous + 1] = array[previous];
                previous--;
            }
            array[previous + 1] = current;
        }
    }
}
