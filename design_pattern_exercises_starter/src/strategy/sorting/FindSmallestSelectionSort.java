package strategy.sorting;

import strategy.searching.FindSmallest;
import strategy.utilities.Sorts;

/**
 * Sorts an input array using selection sort and then
 * finds the smallest element.
 *
 * @param <T> the generic type
 * @author Josh Archer
 * @version 1.0
 */
public class FindSmallestSelectionSort<T extends Comparable<T>> extends FindSmallest<T>
{
    @Override
    public void sort(T[] array)
    {
        Sorts.selectionSort(array);
    }
}