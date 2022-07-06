package structures;

import interfaces.ISet;
import java.util.Iterator;

/**
 * This class implements the ISet generic class with all of
 * it's methods and will use both SetTest.java
 * and HashTable.java
 * @param <T> Generic element
 * @author Cesar Escalona
 * @version 1.0
 */
public class Set<T> implements ISet<T>
{
    // instance variable
    private HashTable<T> table = new HashTable<>();

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
    @Override
    public void add(T element)
    {
        table.add(element);
    }

    /**
     * Finds and removes an element from the collection.
     *
     * @throws java.util.NoSuchElementException thrown when the
     * element is not found in the collection
     * @param element the element to remove
     */
    @Override
    public void remove(T element)
    {
        table.remove(element);
    }

    /**
     * Reports whether the collection contains an element.
     *
     * @param element the element to search for.
     * @return true if the element is found, otherwise false
     */
    @Override
    public boolean contains(T element)
    {
        return table.contains(element);
    }

    /**
     * Returns the number of elements in the collection.
     *
     * @return the number of elements
     */
    @Override
    public int size()
    {
        return table.size();
    }

    /**
     * Reports whether the collection is empty or not.
     *
     * @return true if the collection is empty, otherwise false
     */
    @Override
    public boolean isEmpty()
    {
        return table.isEmpty();
    }

    /**
     * Removes all elements from the collection.
     */
    @Override
    public void clear()
    {
        table.clear();
    }

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
    @Override
    public T get(T element)
    {
        return table.get(element);
    }

    /**
     * Returns an iterator over the collection.
     *
     * @return an object using the Iterator<T> interface
     */
    @Override
    public Iterator<T> iterator()
    {
        return table.iterator();
    }

    /**
     * Returns a new set object with the union of
     * the current set and the input parameter.
     *
     * @param other the other set to join with this set
     * @return the union of two sets
     */
    @Override
    public ISet<T> union(ISet<T> other)
    {
        // returns a set of both A and B
        // take the items in this set
        Set<T> result = new Set<>();
        for (T item: this) {
            // add them to the new set
            result.add(item);
        }
        // take the items in this set
        for (T item: other) {
            // also add these items to the set
            result.add(item);
        }
        // return the set containing both set items
        return result;
    }

    /**
     * Returns a new set object with the intersection
     * of the current set and the input parameter.
     *
     * @param other the other set to join with this set
     * @return a intersection of two sets
     */
    @Override
    public ISet<T> intersects(ISet<T> other)
    {
        // returns the elements shared between two sets
        // set the new set
        Set<T> result = new Set<>();
        // iterate through and item = element itself
        // this = my set, other = other set
        for (T item: this) {
            // if other element = mine
            if(other.contains(item)){
                // add to the new set
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Returns a new set object with the difference
     * between this set and the input set.
     * (i.e. this - other)
     *
     * @param other the other set to use in the difference
     * operation
     * @return a difference of two sets
     */
    @Override
    public ISet<T> difference(ISet<T> other)
    {
        // returns the elements of the first set minus the second set
        Set<T> result = new Set<>();
        for (T item: this) {
            if (!other.contains(item)){
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Reports whether the input set is a subset of this
     * set.
     * @param other the subset candidate
     * @return true if other is a subset of this set,
     * otherwise false
     */
    @Override
    public boolean isSubset(ISet<T> other)
    {
        // create a new set to use
        Set<T> result = new Set<>();

        // check if items from this match any from the other
        for (T item: this) {
            if(other.contains(item)){
                // if they do, add them to result set
                result.add(item);
            }
        }
        // if the size of the return set is equal to the other size, then it is a subset
        return result.size() == other.size();
    }

    /**
     * Reports whether this set and the input set are
     * disjoint.
     * @param other the other set to consider
     * @return true if both sets are disjoint, otherwise
     * false
     */
    @Override
    public boolean isDisjoint(ISet<T> other)
    {
        // if they share no common elements then the result
        // will be empty at the end
        // create a new set to use
        Set<T> result = new Set<>();

        // check if items from this match any from the other
        for (T item: this) {
            if(other.contains(item)){
                // if they do, add them to result set
                result.add(item);
            }
        }
        // if the result set size is 0, this will be a disjoint set
        return result.size() == 0;
    }

    /**
     * Reports whether this set is an empty set.
     * @return true if this set is empty, otherwise false
     */
    @Override
    public boolean isEmptySet()
    {
        // return true if this set is empty
        return this.isEmpty();
    }

    /**
     * Returns a generic toString
     *
     * @return a generic toString
     */
    @Override
    public String toString() {
        return "Set{" +
                "table=" + table +
                '}';
    }
}
