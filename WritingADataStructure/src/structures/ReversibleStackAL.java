package structures;

import adts.IReversibleStack;

import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * @param <T> is the element
 * @author Cesar Escalona
 * @version 1.0
 */
public class ReversibleStackAL<T> implements IReversibleStack<T>, Iterable<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private T[] data;

    // track the next available spot
    private int nextUnusedIndex = 0;

    // track the changes to the structure
    private int modCount = 0;

    /**
     *  Default constructor that creates a new array at default capacity
     */
    public ReversibleStackAL() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T element) {
        // check if the array is full
        if(nextUnusedIndex >= data.length){
            // if array is full create a new array with twice the size
            T[] newData = (T[]) new Object[data.length * 2];

            // copy elements from data to newData
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }

            // replace our array with new one
            data = newData;
        }

        // add the element to the next available index
        data[nextUnusedIndex] = element;
        // dont forget to update size
        nextUnusedIndex++;
        modCount++;  // a change was made
    }

    @Override
    public void remove(T element) {
        // this method is not supported in the structure
        throw new UnsupportedOperationException("This method is not supported");
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < nextUnusedIndex; i++) {
            if(data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return nextUnusedIndex;
    }

    @Override
    public boolean isEmpty() {
        // return nextUnusedIndex == 0;
        return nextUnusedIndex == 0;
    }


    @Override
    public void clear() {
        int counter = nextUnusedIndex;
        // should loop through the array and remove all elements
        for (int i = 0; i < counter; i++) {
            data[i] = null;
            nextUnusedIndex--;
        }
        modCount++;  // a change was made
    }

    // needs work
    @Override
    public void reverse() {
        T[] reversed = (T[]) new Object[nextUnusedIndex];
        int counter = 0;
        for (int i = nextUnusedIndex - 1; i > -1; i--) {
            // save data into new array
            T num = data[i];
            reversed[counter] = num;
            counter++;
            }
        // data = new array
        data = reversed;
    }

    // needs work
    @Override
    public T remove() {
        if(nextUnusedIndex == 0) {
            throw new java.util.NoSuchElementException("The stack is empty");
        }
        //int counter = nextUnusedIndex;
        for (int i = 0; i < nextUnusedIndex; i++) {
            // did we find it
            if(data[i].equals(data[nextUnusedIndex - 1])){
                //remove the element, shifting down higher elements
                for (int j = i; j < nextUnusedIndex - 1; j++) {
                    data[i] = data[j+1];
                }
                nextUnusedIndex--;
                T removed = data[nextUnusedIndex];
                data[nextUnusedIndex] = null;
                modCount++;  // a change was made

                // stop searching---needs work!!!
                return removed;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return  "Array: " + java.util.Arrays.toString(data);
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
    private class StackIterator implements Iterator<T> {
        private int nextIndex = 0;
        private int savedModCount;
        private int lastIndex = nextUnusedIndex - 1;

        public StackIterator() {
            try{
                savedModCount = modCount;
            }catch(EmptyStackException e){
                e.printStackTrace();
            }
        }

        @Override
        public boolean hasNext() {
            checkForChanges();
            // make sure we still have a valid index, and the value is not null
            return nextIndex < nextUnusedIndex;
        }

        private void checkForChanges() {
            if(savedModCount != modCount){
                throw new ConcurrentModificationException("You cannot change the Stack while iterating");
            }
        }

        @Override
        public T next() {
            checkForChanges();

            // save next element seen
            T result = data[lastIndex];
            nextIndex++;

            // Move to next element
            if(lastIndex > 0) {
                lastIndex--;
            }
            // return the result
            return result;
        }

        // leaving as default because not needed
        @Override
        public String toString() {
            return "StackIterator{" +
                    "nextIndex=" + nextIndex +
                    ", savedModCount=" + savedModCount +
                    ", lastIndex=" + lastIndex +
                    '}';
        }
    }
}