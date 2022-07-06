package strategy.sorting_types;

import strategy.interfaces.ISorts;
import strategy.utilities.Sorts;

/**
 * This class will sort arrays passed in using selection sort
 *
 * @param <T>
 * @author Cesar Escalona
 * @version 1.0
 */
public class SelectionSort<T extends Comparable<T>> implements ISorts<T> {
    @Override
    public void sort(T[] array) {
        Sorts.selectionSort(array);
    }
}
