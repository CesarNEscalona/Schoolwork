package strategy.sorting;

import strategy.searching.BinarySearch;
import strategy.utilities.Sorts;

/**
 * Sorts an input array using insertion sort and then
 * finds an element using binary search.
 *
 * @param <T> the generic type
 * @author Josh Archer
 * @version 1.0
 */
public class BinarySearchInsertionSort<T extends Comparable<T>> extends BinarySearch<T>
{
    /**
     * Saves the value to search for
     * @param search the search value
     */
    public BinarySearchInsertionSort(T search)
    {
        super(search);
    }

    @Override
    public void sort(T[] array)
    {
        Sorts.insertionSort(array);
    }
}
