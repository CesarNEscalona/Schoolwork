package arrayexamples;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayExamplesTest {

    @Test
    public void TestFindLargest() {
        // create arrays of integers
        int[] numbers1 = {2, 3, 4, -9, 7, 8};
        int[] numbers2 = {2, 3, 4, 9, 7, 8};

        assertEquals( 8, ArrayExamples.findLargest(numbers1));
        assertEquals(9, ArrayExamples.findLargest(numbers2));
    }

    @Test
    public void testSorted() {
        // create arrays of decimals
        double[] decimalsAsc = {2.5, 3.0, 5.1};
        double[] decimalsDes = {5.1, 3.0, 2.5};

        assertEquals(true, ArrayExamples.sorted(decimalsAsc));
        // shortcut version
        assertTrue(ArrayExamples.sorted(decimalsAsc));

        assertEquals(false, ArrayExamples.sorted(decimalsDes));
        // shortcut version
        assertFalse(ArrayExamples.sorted(decimalsDes));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalArgumentDuplicates() {
        // create array of strings
        String[] fruits = {"orange", "apple", "banana"};

        ArrayExamples.duplicates(fruits, null);
    }
}