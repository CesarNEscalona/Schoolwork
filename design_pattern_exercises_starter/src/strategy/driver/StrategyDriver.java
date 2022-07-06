package strategy.driver;

import strategy.binary_search_type.BinarySearchType;
import strategy.find_smallest_type.FindSmallestType;
import strategy.kth_smallest_type.KthSmallestType;
import strategy.sorting_types.BubbleSort;
import strategy.sorting_types.InsertionSort;
import strategy.sorting_types.SelectionSort;
import strategy.strategy.MySortAndSearch;
import java.util.Arrays;

/**
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class StrategyDriver {
    /**
     * @param args the main method that will run the program
     */
    public static void main(String[] args) {

        Integer[] arr = {1,3,4,5,0};
        System.out.println(Arrays.toString(arr));

        // testing using Binary Search Type and Bubble Sort
        MySortAndSearch<Integer> testing = new MySortAndSearch<>(
                new BinarySearchType<>(5), new BubbleSort<>()
        );

        // testing using FindSmallestType and Insertion Sort
        MySortAndSearch<Integer> testing1 = new MySortAndSearch<>(
                new FindSmallestType<Integer>(), new InsertionSort<>()
        );

        // Testing using KthSmallest and Selection Sort
        MySortAndSearch<Integer> testing2 = new MySortAndSearch<>(
                new KthSmallestType<Integer>(1), new SelectionSort<>()
        );

        // printing out results
        System.out.println(testing.sortAndSearch(arr) + " <-- Finding the specific number \"5\"");

        System.out.println(testing1.sortAndSearch(arr) + " <-- Finding the smallest integer in the array");

        System.out.println(testing2.sortAndSearch(arr) + " <-- Finding the second smallest integer in the array");
    }
}
