package strategy.binary_search_type;

import strategy.interfaces.ISearch;

/**
 * This class features a binary search that is a type of search method
 *
 * @param <T> this is the Generic type
 * @author Cesar Escalona
 * @version 1.0
 */
public class BinarySearchType<T extends Comparable<T>> implements ISearch<T> {
    private T search;

    /**
     * @param search takes in a generic that you search for
     */
    public BinarySearchType(T search) {
        this.search = search;
    }

    //the binary search algorithm
    private int binarySearch(T[] array)
    {
        int low = 0;
        int high = array.length - 1;

        while (low <= high)
        {
            int mid = (low + high) / 2;
            int compare = array[mid].compareTo(search);
            if (compare == 0)
            {
                return mid;
            }
            else if (compare > 0)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }

    @Override
    public T find(T[] array) {
        int index = binarySearch(array);
        if (index != -1)
        {
            return array[index];
        }
        return null;
    }

    @Override
    public String toString() {
        return "BinarySearchType{" +
                "search=" + search +
                '}';
    }
}
