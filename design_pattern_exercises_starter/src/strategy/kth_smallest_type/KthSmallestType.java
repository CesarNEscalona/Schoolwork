package strategy.kth_smallest_type;

import strategy.interfaces.ISearch;

/**
 * This class will search and return the position of a value in an array
 *
 * @param <T>
 * @author Cesar Escalona
 * @version 1.0
 */
public class KthSmallestType <T extends Comparable<T>> implements ISearch<T> {

    private int positionK;

    /**
     * @param positionK takes in the position of the array to search for
     */
    public KthSmallestType(int positionK) {
        this.positionK = positionK;
    }

    @Override
    public T find(T[] array) {
        return array[positionK];
    }

    @Override
    public String toString() {
        return "KthSmallestType{" +
                "positionK=" + positionK +
                '}';
    }
}
