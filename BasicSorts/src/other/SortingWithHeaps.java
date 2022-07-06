package other;

import utility.SortingUtilities;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortingWithHeaps {

    public static void main(String[] args) {

        int[] testArray = SortingUtilities.genArray(10);
        System.out.println(Arrays.toString(testArray));
        sortWithHeap(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    public static void sortWithHeap(int[] numbers){
        Queue<Integer> heap = new PriorityQueue<>();
        //add each element to the heap - O(logn)
        // if we add n elements to the heap,
        for (int i = 0; i < numbers.length; i++) {
            heap.add(numbers[i]);
        }

        // pull out each element one by one - O(logn)
        // removing n elements - O(logn)
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = heap.remove();
        }
    }
}
