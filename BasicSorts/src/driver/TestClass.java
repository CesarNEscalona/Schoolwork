package driver;

import basic.BasicSorts;
import utility.SortingUtilities;
import java.util.Arrays;

/**
 * This program will test methods from the BasicSorts class and SortingUtilities class. This class calls for a random
 * generated array, then we apply our methods from other classes to sort.
 * the arrays in order.
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class TestClass {

    /**
     * Loads my program.
     * @param args The main method contains 3 static method calls to helper methods that test the random array.
     */
    public static void main(String[] args) {
        bubbleTest();
        selectionTest();
        insertionTest();
    }

    private static void bubbleTest() {
        int[] first = SortingUtilities.genArray(10);
        System.out.println("---------------------------------------------------");
        System.out.println();
        System.out.println("Before: " + Arrays.toString(first));
        System.out.println("Contains inversions: " + SortingUtilities.containsInversions(first));
        BasicSorts.bubbleSort(first);
        System.out.println("After Bubble sort: " + Arrays.toString(first));
        System.out.println("Contains inversions after sort: " + SortingUtilities.containsInversions(first));
        System.out.println();

        int[] second = SortingUtilities.genArray(100);
        System.out.println("Before: " + Arrays.toString(second));
        System.out.println("Contains inversions: " + SortingUtilities.containsInversions(second));
        BasicSorts.bubbleSort(second);
        System.out.println("After Bubble sort: " + Arrays.toString(second));
        System.out.println("Contains inversions after sort: " + SortingUtilities.containsInversions(second));
        System.out.println("---------------------------------------------------");
    }

    private static void selectionTest() {
        int[] first = SortingUtilities.genArray(10);
        System.out.println();
        System.out.println("Before: " + Arrays.toString(first));
        System.out.println("Contains inversions: " + SortingUtilities.containsInversions(first));
        BasicSorts.selectionSort(first);
        System.out.println("After Selection sort: " + Arrays.toString(first));
        System.out.println("Contains inversions after sort: " + SortingUtilities.containsInversions(first));
        System.out.println();

        int[] second = SortingUtilities.genArray(100);
        System.out.println("Before: " + Arrays.toString(second));
        System.out.println("Contains inversions: " + SortingUtilities.containsInversions(second));
        BasicSorts.selectionSort(second);
        System.out.println("After Selection sort: " + Arrays.toString(second));
        System.out.println("Contains inversions after sort: " + SortingUtilities.containsInversions(second));
        System.out.println("---------------------------------------------------");
    }

    private static void insertionTest() {
        int[] first = SortingUtilities.genArray(10);
        System.out.println();
        System.out.println("Before: " + Arrays.toString(first));
        System.out.println("Contains inversions: " + SortingUtilities.containsInversions(first));
        BasicSorts.insertionSort(first);
        System.out.println("After Insertion sort: " + Arrays.toString(first));
        System.out.println("Contains inversions after sort: " + SortingUtilities.containsInversions(first));
        System.out.println();

        int[] second = SortingUtilities.genArray(100);
        System.out.println("Before: " + Arrays.toString(second));
        System.out.println("Contains inversions: " + SortingUtilities.containsInversions(second));
        BasicSorts.insertionSort(second);
        System.out.println("After Insertion sort: " + Arrays.toString(second));
        System.out.println("Contains inversions after sort: " + SortingUtilities.containsInversions(second));
        System.out.println("---------------------------------------------------");
    }
}
