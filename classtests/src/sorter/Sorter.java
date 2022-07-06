package sorter;

import java.util.Arrays;

public class Sorter<T extends Comparable<T>>
{
    public void sort(T[] input)
    {
        Arrays.sort(input);
    }
}
