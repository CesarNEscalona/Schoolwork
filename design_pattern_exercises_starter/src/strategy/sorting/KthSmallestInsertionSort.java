package strategy.sorting;

import strategy.searching.KthSmallestElement;
import strategy.utilities.Sorts;

/**
 * Sorts an input array using insertion sort and then
 * finds the kth smallest element.
 *
 * @param <T> the generic type
 * @author Josh Archer
 * @version 1.0
 */
public class KthSmallestInsertionSort<T extends Comparable<T>> extends KthSmallestElement<T>
{
    /**
     * Save the position of the element being searched for
     * @param positionK the position
     */
    public KthSmallestInsertionSort(int positionK)
    {
        super(positionK);
    }

    @Override
    public void sort(T[] array)
    {
        Sorts.insertionSort(array);
    }
}