package strategy.utilities;

/**
 * This helper class has implementations of the
 * basic sorts.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class Sorts
{
    /**
     * The bubble sort routine.
     * @param array the array to sort
     */
    public static void bubbleSort(Comparable[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            //this determines which adjacent elements will bubble
            for (int j = 0; j < array.length - 1 - i; j++)
            {
                //see if adjacent elements are out of order
                if (array[j].compareTo(array[j + 1]) > 0)
                {
                    Comparable temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * The selection sort routine.
     * @param array the array to sort
     */
    public static void selectionSort(Comparable[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            //assume the current element is the smallest
            Comparable smallest = array[i];
            int smallestIndex = i;

            //find any smaller element
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j].compareTo(smallest) < 0)
                {
                    smallest = array[j];
                    smallestIndex = j;
                }
            }

            //copy the smallest element into the next smallest index in the array
            Comparable temp = array[i];
            array[i] = array[smallestIndex];
            array[smallestIndex] = temp;
        }
    }

    /**
     * The insertion sort routine.
     * @param array the array to sort
     */
    public static void insertionSort(Comparable[] array)
    {
        for (int i = 1; i < array.length; i++)
        {
            //move the element into the lower (sorted) positions in the array
            for (int j = i; j >= 1; j--)
            {
                //if out of order swap, otherwise short-circuit and move on
                //to the next element
                if (array[j].compareTo(array[j - 1]) < 0)
                {
                    Comparable temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                else
                {
                    break;
                }
            }
        }
    }
}
