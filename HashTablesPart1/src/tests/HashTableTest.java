package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import structures.HashTable;
import structures.ICollection;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * These test verify a HashTable structure using
 * separate chaining.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class HashTableTest
{
    private ICollection<String> table;
    private String[] testValues = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                             "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                             "u", "v", "w", "x", "y", "z"};

    /**
     * Creates a new empty table.
     */
    @Before
    public void setup()
    {
        table = getTable();
    }

    private ICollection<String> getTable()
    {
        return new HashTable<>();
    }

    private ICollection<TestClass> getTableTestClass()
    {
        return new HashTable<>();
    }

    private void addTestElements()
    {
        //add a few elements
        for (String element : testValues)
        {
            table.add(element);
        }
    }

    /**
     * Verifies that elements can be added and detected
     * in the table.
     */
    @Test
    public void addTest()
    {
        addTestElements();

        //testValues the size
        Assert.assertEquals("size() is incorrect after using add()", testValues.length, table.size());

        //verify each element is in the table
        for (String element : testValues)
        {
            Assert.assertTrue("element is missing after adding to hash table", table.contains(element));
        }
    }

    /**
     * Checks whether duplicates are rejected by the hash table.
     */
    @Test
    public void addDuplicatesTest()
    {
        addTestElements();

        for (String element : testValues)
        {
            try
            {
                table.add(element);
                Assert.fail("No exception was thrown when entering a duplicate element: " + element);
            }
            catch (IllegalArgumentException ex)
            {
                //do nothing, this should happen
                assert true;
            }
        }
    }

    /**
     * Tests the removal of existing elements in the table.
     */
    @Test
    public void removeTest()
    {
        addTestElements();

        //remove items that should be in the table
        List<String> removedElements = List.of("a", "m", "z");
        for (String element : removedElements)
        {
            table.remove(element);
        }

        //verify that they are removed
        Assert.assertEquals("size() is incorrect after calling remove() 3 times",
                            testValues.length - 3, table.size());
        for (int i = 0; i < testValues.length; i++)
        {
            if (!removedElements.contains(testValues[i]))
            {
                Assert.assertTrue("element is missing after removing another element: " + testValues[i],
                        table.contains(testValues[i]));
            }
            else
            {
                Assert.assertFalse("element removed is still inside the table: " + testValues[i],
                        table.contains(testValues[i]));
            }
        }
    }

    /**
     * Tests that missing elements throw the expected exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void removeMissingElementTest()
    {
        addTestElements();
        table.remove("!");
    }

    /**
     * Tests whether existing elements can be found in the table.
     */
    @Test
    public void containsExistsTest()
    {
        addTestElements();

        //look for present elements
        for (String element : testValues)
        {
            Assert.assertTrue("table does not contain elements that have been added",
                    table.contains(element));
        }
    }

    /**
     * Tests whether missing elements can be found in the table.
     */
    @Test
    public void containsMissingTest()
    {
        addTestElements();

        //look for missing elements
        Assert.assertFalse("table should not report missing elements as present in the table",
                table.contains("!"));
    }

    /**
     * Verifies that size() and isEmpty() report correctly with an empty table
     */
    @Test
    public void emptyTableTest()
    {
        Assert.assertTrue("table should be empty at first", table.isEmpty());
        Assert.assertEquals("table should have size zero with no elements", 0, table.size());
    }

    /**
     * Verifies that size() and isEmpty() report correct as a table changes.
     */
    @Test
    public void resizingTableTest()
    {
        //add elements and see if size changes
        for (int i = 0; i < testValues.length; i++)
        {
            table.add(testValues[i]);
            Assert.assertEquals("size() incorrect after calling add", i + 1, table.size());
        }

        //remove elements and see if size changes
        for (int i = testValues.length - 1; i >= 0; i--)
        {
            table.remove(testValues[i]);
            Assert.assertEquals("size() incorrect after calling add", i, table.size());
        }
    }

    /**
     * Verifies that clear() actually removes all elements from the table
     */
    @Test
    public void clearTest()
    {
        addTestElements();
        table.clear();

        //the table should be empty now
        Assert.assertTrue("table should be empty after calling clear()", table.isEmpty());
        Assert.assertEquals("table should have size zero after calling clear()", 0, table.size());

        //no elements should be present
        for (int i = 0; i < testValues.length; i++)
        {
            Assert.assertFalse("table is reporting elements after clear() is called",
                               table.contains(testValues[i]));
        }
    }

    /**
     * Verifies that an element can be retrieved from the table
     * using the get() method.
     */
    @Test
    public void getExistingTest()
    {
        //add a table with an element
        ICollection<TestClass> testTable = getTableTestClass();
        TestClass testElement = new TestClass(1, 2);
        testTable.add(testElement);

        Assert.assertEquals("Element cannot be found with the get() method",
                            testElement, testTable.get(testElement));
    }

    /**
     * Verifies that a missing element will return null when given to the get() method.
     */
    @Test
    public void getMissingTest()
    {
        //add a table without an element
        ICollection<TestClass> testTable = getTableTestClass();
        TestClass testElement = new TestClass(1, 2);

        Assert.assertNull("get() does not return null for a missing element",
                          testTable.get(testElement));
    }

    /**
     * Verifies that using the get() method will not just return
     * the input parameter reference.
     */
    @Test
    public void getNoReferenceTest()
    {
        //add a table
        ICollection<TestClass> testTable = getTableTestClass();

        //two elements that are equal according to equals()
        TestClass firstElement = new TestClass(1, 2);
        TestClass secondElement = new TestClass(1, 4);

        //first element is in the table, not second
        testTable.add(firstElement);

        Assert.assertNotSame("Element in table is not returned when calling the get() method",
                               secondElement, testTable.get(secondElement));
    }

    /**
     * Verifies that a new iterator can be retrieved on an empty table
     */
    @Test
    public void emptyTableIteratorTest()
    {
        //do we have an iterator?
        Assert.assertNotNull("iterator is returned null with no elements in the table", table.iterator());
    }

    /**
     * Verifies that all elements in the table can be returned (in any order).
     */
    @Test
    public void iteratorTest()
    {
        addTestElements();

        //store an array of flags - true: found, false: not-found
        boolean[] found = new boolean[testValues.length];
        for (String element : table)
        {
            //find the element, mark it as found
            for (int i = 0; i < testValues.length; i++)
            {
                if (testValues[i].equals(element))
                {
                    if (found[i])
                    {
                        Assert.fail("duplicate element found with iterator: " + element);
                    }
                    else
                    {
                        found[i] = true;
                    }
                }
            }
        }

        //check that each was found
        for (int i = 0; i < found.length; i++)
        {
            if (!found[i])
            {
                Assert.fail("element not found with iterator: " + testValues[i]);
            }
        }
    }

    /**
     * Verifies that you cannot call the add() method while using an iterator.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void concurrentAddTest()
    {
        addTestElements();

        for (String element : table)
        {
            table.add("!");
            assert element != null;
        }
    }

    /**
     * Verifies that you cannot call the remove() method while using an iterator.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void concurrentRemoveTest()
    {
        addTestElements();

        for (String element : table)
        {
            table.remove("e");
            assert element != null;
        }
    }

    /**
     * Verifies that you cannot call the clear() method while using an iterator.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void concurrentClearTest()
    {
        addTestElements();

        for (String element : table)
        {
            table.clear();
            assert element != null;
        }
    }

    private static class TestClass
    {
        private int identifier;
        private int value;

        public TestClass(int identifier, int value)
        {
            this.identifier = identifier;
            this.value = value;
        }

        @Override
        public boolean equals(Object other)
        {
            if (this == other)
            {
                return true;
            }

            if (other == null || getClass() != other.getClass())
            {
                return false;
            }

            TestClass testClass = (TestClass) other;
            return identifier == testClass.identifier;
        }

        @Override
        public int hashCode()
        {
            return identifier;
        }

        @Override
        public String toString()
        {
            return "TestClass{" +
                    "identifier=" + identifier +
                    ", value=" + value +
                    '}';
        }
    }
}
