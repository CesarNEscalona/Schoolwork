package structures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a hashtable class that implements the ICollection class. This class contains all of the methods
 * from that interface including a few private helper methods.
 * @author Cesar Escalona
 * @version 1.0
 */
public class HashTable<T> implements ICollection<T> {

    private static final int INITIAL_TABLE_SIZE = 10;
    private static final double MAX_LOAD_FACTOR = 2.5;
    private static final double RESIZE_RATE = 1.5;

    private T element;
    private int modCount;
    private Node<T>[] table;
    private int size;

    /**
     * Default constructor that initializes a new node table with
     * pre determined size
     */
    public HashTable() {
        table = new Node[INITIAL_TABLE_SIZE];
    }


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
    public void add(T element) {
        if (contains(element)) {
            throw new IllegalArgumentException("No Duplicates allowed");
        }

        // check if load factor is too large...
        if ((((double) size + 1) / table.length) > MAX_LOAD_FACTOR) {
            resizeAndRehash();
        }

        //int index = findPosition(element);
        // a numeric value that is generated from the properties
        int code = Math.abs(element.hashCode());
        int index = code % table.length;

        // Enter if the index is already filled
        if (table[index] != null) {

            // if the element is not the same, go in
            // if the node's data.next is null then add the element to the next link
            if (table[index].next == null) {
                // if the node data is null, add the element
                table[index].next = new Node<>(element);
            }
            // if there are multiple links, check the next node's next, if null, create a new link there
            else if (table[index].next.next == null) {
                table[index].next.next = new Node<>(element);
            }
        } else {
            // add the element to the index as a node
            table[index] = new Node<>(element);
        }
        // increase size and modCount
        size++;
        modCount++;
    }

    // Helper method that resizes and rehashes the table once it exceeds load factor
    private void resizeAndRehash() {
        // create a new array double the size and copy elements
        Node<T>[] oldTable = table;
        //int oldSize = size;
        table = new Node[(int) (oldTable.length * RESIZE_RATE)];
        // set to 0 to not over count, adding size in add already
        size = 0;
        for (Node<T> tNode : oldTable) {
            if (tNode != null) {
                // reuse code for adding elements into table
                if (tNode.next != null) {
                    if (tNode.next.next != null) {
                        add(tNode.next.next.data);
                    }
                    add(tNode.next.data);
                }
                add(tNode.data);
            }
        }
    }

    /**
     * Finds and removes an element from the collection.
     *
     * @throws java.util.NoSuchElementException thrown when the
     * element is not found in the collection
     * @param element the element to remove
     */
    @Override
    public void remove(T element) {
        if (!contains(element)) {
            throw new NoSuchElementException("Cannot remove a missing element");
        }
        // a numeric value that is generated from the properties
        int code = Math.abs(element.hashCode());
        int index = code % table.length;

        if (table[index].data.equals(element)) {
            table[index] = table[index].next;
        } else if (table[index].next != null) {
            // checking the second link with the element, returning T or F
            if (table[index].next.data.equals(element)) {
                table[index].next = table[index].next.next;
            }
        } else if (table[index].next.next != null) {
            if (table[index].next.next.data.equals(element)) {
                table[index].next.next = null;
            }
        }
        // make sure to decrease the size when removing
        size--;
        modCount++;
    }

    /**
     * Reports whether the collection contains an element.
     *
     * @param element the element to search for.
     * @return true if the element is found, otherwise false
     */
    @Override
    public boolean contains(T element) {
        if (table == null) {
            return false;
        }
        return get(element) != null;
    }

    /**
     * Returns the number of elements in the collection.
     *
     * @return the number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Reports whether the collection is empty or not.
     *
     * @return true if the collection is empty, otherwise false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all elements from the collection.
     */
    @Override
    public void clear() {
        table = null;
        size = 0;
        modCount++;
    }

    /**
     * Returns an element in the collection that matches the
     * input parameter according the equals() method of the
     * parameter.
     *
     * Note: This method should NOT return a reference to the
     *            input parameter. This method will be used in part #2
     *            of the assignment.
     *
     * @param element an element to search for
     * @return a matching element
     */
    @Override
    public T get(T element) {
        int code = Math.abs(element.hashCode());
        int index = code % table.length;

        if (table[index] != null) {
            if (table[index].data.equals(element)) {
                return table[index].data;
            } else if (table[index].next != null) {
                // checking the second link with the element, returning T or F
                if (table[index].next.data.equals(element)) {
                    return table[index].next.data;
                } else if (table[index].next.next != null) {
                    if (table[index].next.next.data.equals(element)) {
                        return table[index].next.next.data;
                    }
                }
            }
        }
        return null;
    }

    // Returns a generic toString
    @Override
    public String toString() {
        return java.util.Arrays.toString(table);
    }

    /**
     * Returns an iterator over the collection.
     * @return an object using the Iterator<T> interface
     */
    @Override
    public Iterator<T> iterator() { return new HashTableIterator(); }
    // inner class
    private class HashTableIterator implements Iterator<T> {

        // instance fields
        private int start;
        private Node<T> current = null;
        private int savedModCount = modCount;

        // default constructor
        public HashTableIterator() {
            // do nothing...
        }

        // method that checks if there is a next position to return
        @Override
        public boolean hasNext() {
            checkForChanges();
            // if node is empty and data at table index 0 is not empty
            if(current == null && table[start] != null){
                return true;
            }
            // if the node is not empty
            else if(current != null) {
                // if next link is null, We need to go to the next index for the table.length
                if(current.next == null && start < table.length){
                    start++;
                    return true;
                }
                // return false if the next node is null and we've reached the end of the array size
                return current.next != null;
            }
            return false;
        }

        // private method that checks for concurrent mods
        private void checkForChanges() {
            if(savedModCount != modCount){
                throw new ConcurrentModificationException("You can't make changes while iterating");
            }
        }

        // Method that returns the element if its available
        @Override
        public T next() {
            checkForChanges();

            // careful for null pointer exception, the goal here is to iterate through the linked list in the array
            if(current == null && table[start].next != null) {
                current = table[start];
                return current.data;
            }
            else if(current != null && current.next != null){
                element = current.data;
                current = current.next;
                return current.data;
            } else if (current != null) {
                if(start < table.length){
                    current = table[start];
                    return current.data;
                }
                return null;
            }
            return element;
        }

        // Generates a generic toString
        @Override
        public String toString() {
            return "HashTableIterator{" +
                    "start=" + start +
                    ", current=" + current +
                    ", savedModCount=" + savedModCount +
                    '}';
        }
    }

    // Class that helps create a node
    private static class Node<T> {
        private T data;
        private Node<T> next; // reference to another node obj

        public Node(T data) {
            this.data = data;
        }

        public String toString() {
            return data.toString();
        }
    }
}
