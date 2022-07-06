package heapsort;

import movie.Movie;
import java.util.Arrays;
import java.util.Comparator;

/**
 * This class will do the work required to sort the array passed in using heapsort.
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class HeapSort {
    // instance variables
    private int variable;
    private int nextUnusedIndex;
    private Movie[] array;
    private Comparator<Movie> myComparator;


    /**
     * Default constructor
     */
    public HeapSort() {
        // do nothing for now...
    }

    /**
     * This method takes the passed in array and sorts the value based on the comparator passed in
     *
     * @param array the array passed in from the driver class
     * @param myComparator the comparator passed in from the driver class
     */
    public void sort(Movie[] array, Comparator<Movie> myComparator) {
        this.array = array;
        this.myComparator = myComparator;
        nextUnusedIndex = array.length;
        // add a variable that acts as the array.len
        variable = array.length;
        for (int i = variable; i > 0; i--) {
            heap();
        }
    }


    /**
     * This method finds the highest index with a child and uses that to create a max heap
     */
    public void heap(){
        // highest index with child
        int highestIndex = (variable / 2) - 1;
        // loop from the highest index with child back to 0 (include 0)
        for (int i = highestIndex; i >= 0 ; i--) {
            // now check for sink
            sink(i);
        }
        remove();
        variable--;
    }

    private void remove() {
        // save the largest element and remove from top
        Movie max = array[0];
        int lastIndex = nextUnusedIndex - 1;
        // replace max with last element
        array[0] = array[lastIndex];
        // set last index to null
        array[lastIndex] = null;
        nextUnusedIndex--;
        int size = (nextUnusedIndex / 2) - 1;
        // sink with new values
        for (int i = size; i >=0 ; i--) {
            sink(size);
        }
        // finally, add in the last element
        array[nextUnusedIndex] = max;
    }

    private void sink(int parentIndex) {
        int loop = variable / 2;
        // pass in index from heap()
        while(parentIndex < loop) {
            int leftChild = (2 * parentIndex) + 1;
            int rightChild;
            // try catch for out of bounds exception
            try{
                rightChild = (2 * parentIndex) + 2;
            } catch(Exception e){
                rightChild = -1;
            }
            // default largest to left since there has to be a child based on arithmetic
            int largestChildIndex = leftChild;
            // check if right is a valid index, if so step in
            if(rightChild > 0 && rightChild < nextUnusedIndex){
                // compare the right and left child to see which is largest, true if left is smaller
                if(myComparator.compare(array[leftChild], array[rightChild]) < 0){
                    // assign the largest child
                    largestChildIndex = rightChild;
                }
            }
            loop--;
            // Now check against parent, which is larger, true if left is smaller
            if(myComparator.compare(array[parentIndex], array[largestChildIndex]) < 0){
                // if child is larger than parent, swap them
                swap(parentIndex, largestChildIndex);
                parentIndex = largestChildIndex;
            }
            else{
                // otherwise, already in order
                break;
            }
        }
    }

    private void swap(int first, int second) {
        // swap elements at the index in the heap array for sink()
        Movie temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    @Override
    public String toString() {
        return "HeapSort{" +
                "variable=" + variable +
                ", nextUnusedIndex=" + nextUnusedIndex +
                ", array=" + Arrays.toString(array) +
                ", myComparator=" + myComparator +
                '}';
    }
}