package hashtables;

import java.util.Arrays;

public class HashTable<T>
{
    private static final int INITIAL_TABLE_SIZE = 10;
    private static final double MAX_LOAD_FACTOR = 0.6;
    private static final int RESIZE_RATE = 2;

    private HashElement[] table;
    private int size;

    public HashTable()
    {
        table = new HashElement[INITIAL_TABLE_SIZE];
    }

    public boolean add(T element)
    {
        //check if our load factor is too large...
        if (((double)size + 1) / table.length >= MAX_LOAD_FACTOR)
        {
            resizeAndRehash();
        }

        int index = findPosition(element);

        //is this a duplicate?
        if (table[index] != null)
        {
            return false;
        }

        table[index] = new HashElement(element);
        size++;
        return true;
    }

    private void resizeAndRehash()
    {
        System.out.println("Table was resized");

        //create a new array (double the size) and copy
        //all elements over to the new array
        HashElement[] oldTable = table;
        table = new HashElement[oldTable.length * RESIZE_RATE];

        //set size to zero so we don't overcount when re-adding elements below
        size = 0;

        for (int i = 0; i < oldTable.length; i++)
        {
            if (oldTable[i] != null)
            {
                //reuse our code for adding elements into the table
                add((T)oldTable[i].data);
            }
        }
    }

    public boolean contains(T element)
    {
        return table[findPosition(element)] != null;
    }

    /*
     * This returns the index of the element if found in the table,
     * OR the next open position to place the element in the table.
     */
    private int findPosition(T element)
    {
        //a numeric value that is generated from the properties of the Object...
        int code = Math.abs(element.hashCode());
        int index = code % table.length;

        //probe to find a good position in the table
        while (table[index] != null)
        {
            //check if a duplicate (and hasn't been previously removed)
            if (table[index].data.equals(element) && !table[index].isRemoved)
            {
                break; //found it
            }

            //otherwise we need to move to the next index
            index = (index + 1) % table.length;
        }
        return index;
    }

    public boolean remove(T element)
    {
        int index = findPosition(element);
        if (table[index] != null)
        {
            table[index].isRemoved = true;
            size--;
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return Arrays.toString(table);
    }

    public int size()
    {
        return size;
    }

    private class HashElement<K>
    {
        private K data;
        private boolean isRemoved;

        public HashElement(K data)
        {
            this.data = data;
        }

        @Override
        public String toString()
        {
            return data.toString() + (isRemoved ? " (removed)" : "");
        }
    }
}