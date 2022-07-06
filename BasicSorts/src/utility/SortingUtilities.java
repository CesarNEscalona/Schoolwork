package utility;

import java.util.Arrays;
import java.util.Random;

/**
 * This class featured methods that can create random and sorted arrays as well as checking those arrays
 * for inversions.
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class SortingUtilities {
    private static Random random = new Random();

    /**
     * Generates an array or random ints in random order
     *
     * @param size Takes in a size as a parameter to make the array that length
     * @return returns an array of random ints in random order
     */
    public static int[] genArray(int size){
        int[] results = new int[size];
        for (int i = 0; i < results.length; i++) {
            // using the size / 2 means it works well. A good heuristic!
            results[i] = random.nextInt(size / 2);
        }
        return results;
    }

    /**
     * Generates a sorted array in order from least to greatest
     *
     * @param size Takes in a size as a parameter to make the array that length
     * @return returns an array of random ints in sorted order from smallest to largest
     */
    public static int[] genSortedArray(int size) {
        int[] toSort = genArray(size);
        Arrays.sort(toSort);
        return toSort;
    }

    /**
     * Returns a boolean value based on the array passed in to let the user know if there are any
     * inversions
     *
     * @param toTest Takes in an array as a parameter to test
     * @return returns a boolean if there is at least 1 inversion found
     */
    public static boolean containsInversions(int[] toTest){
        // loop through array
        for (int i = 0; i < toTest.length; i++) {
            // save the number at index i to compare to all others
            int num1 = toTest[i];
            // loop through and check other numbers
            for (int j = i+1; j < toTest.length; j++) {
                // if our number is larger than another number in the array, there is an inversion. return true asap
                if(num1 > toTest[j]){
                    return true;
                }
            }
        }
        // if after looping through, we don't find an inversion, there are no inversions and the array is in order
        return false;
    }

    /**
     * Swaps numbers in the array passed in by the index that is also passed in
     *
     * @param array Takes in an array as a parameter
     * @param first Takes in first int as a parameter to swap in the array
     * @param second Takes in a second int as a parameter to swap in the array
     */
    public static void swap(int[] array, int first, int second) {
        // save the first index as a temp variable
        int temp = array[first];
        // set the second index passed as the first
        array[first] = array[second];
        // Reset the second index to the temp variable
        array[second] = temp;
    }
}