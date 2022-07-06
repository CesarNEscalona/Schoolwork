package strategy.sorting;

import strategy.searching.BinarySearch;
import strategy.utilities.Sorts;

/**
 * Sorts an input array using selection sort and then
 * finds an element using binary search.
 *
 * @param <T> the generic type
 * @author Josh Archer
 * @version 1.0
 */
public class BinarySearchSelectionSort<T extends Comparable<T>> extends BinarySearch<T>
{
    /**
     * Saves the value being searched for
     * @param search the search value
     */
    public BinarySearchSelectionSort(T search)
    {
        super(search);
    }

    @Override
    public void sort(T[] array)
    {
        Sorts.selectionSort(array);
    }
}