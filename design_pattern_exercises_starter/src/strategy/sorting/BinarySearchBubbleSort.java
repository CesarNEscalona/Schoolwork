package strategy.sorting;

import strategy.searching.BinarySearch;
import strategy.utilities.Sorts;

/**
 * Sorts an input array using bubble sort and then
 * finds an element using binary search.
 *
 * @param <T> the generic type
 * @author Josh Archer
 * @version 1.0
 */
public class BinarySearchBubbleSort<T extends Comparable<T>> extends BinarySearch<T>
{
    /**
     * Saves the value to search for
     * @param search the value to search for
     */
    public BinarySearchBubbleSort(T search)
    {
        super(search);
    }

    @Override
    public void sort(T[] array)
    {
        Sorts.bubbleSort(array);
    }
}
