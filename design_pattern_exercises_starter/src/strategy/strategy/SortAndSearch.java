package strategy.strategy;

/**
 * Represents an algorithm that can sort and
 * then search among the sorted input.
 *
 * @param <T> the generic type
 * @author Josh Archer
 * @version 1.0
 */
public abstract class SortAndSearch<T extends Comparable<T>>
{
    /**
     * Finds an element in the sorted array
     * @param array the array to look through
     * @return the element if found, or otherwise null
     */
    public abstract T find(T[] array);
}
