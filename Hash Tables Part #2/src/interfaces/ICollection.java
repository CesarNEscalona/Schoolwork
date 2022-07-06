package interfaces;

import java.util.Iterator;

/**
 * Represents a simple collection of objects. The interface
 * does not include any functionality related to indices of
 * an underlying structure.
 *
 * @author Josh Archer
 * @version 1.0
 */
public interface ICollection<T> extends Iterable<T>
{
    /**
     * Adds an element to the collection. No specific ordering
     * is required. After the load factor has exceeded 250% the
     * table should rehash all elements into a table that is 50%
     * larger than the previous table size.
     *
     * @throws IllegalArgumentException thrown when a duplicate
     * element is added to the table
     * @param element the new element to put in the collection
     */
    void add(T element);

    /**
     * Finds and removes an element from the collection.
     *
     * @throws java.util.NoSuchElementException thrown when the
     * element is not found in the collection
     * @param element the element to remove
     */
    void remove(T element);

    /**
     * Reports whether the collection contains an element.
     *
     * @param element the element to search for.
     * @return true if the element is found, otherwise false
     */
    boolean contains(T element);

    /**
     * Returns the number of elements in the collection.
     *
     * @return the number of elements
     */
    int size();

    /**
     * Reports whether the collection is empty or not.
     *
     * @return true if the collection is empty, otherwise false
     */
    boolean isEmpty();

    /**
     * Removes all elements from the collection.
     */
    void clear();

    /**
     * Returns an element in the collection that matches the
     * input parameter according the equals() method of the
     * parameter.
     *
     * Note: This method should not return a direct reference
     * to the input element, without finding it first in the
     * collection. This method will be used directly in part #2
     * of our assignment.
     *
     * @param element an element to search for
     * @return a matching element
     */
    T get(T element);

    /**
     * Returns an iterator over the collection.
     *
     * @return an object using the Iterator<T> interface
     */
    @Override
    Iterator<T> iterator();
}