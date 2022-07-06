package strategy.sorting_types;

import strategy.interfaces.ISorts;
import strategy.utilities.Sorts;

/**
 * This class will use insertion sort to sort an array passed in
 *
 * @param <T>
 * @author Cesar Escalona
 * @version 1.0
 */
public class InsertionSort<T extends Comparable<T>> implements ISorts<T> {
    @Override
    public void sort(T[] array) {
        Sorts.insertionSort(array);
    }
}
