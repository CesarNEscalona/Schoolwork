package informal_test;

import structures.ReversibleStackAL;

/**
 * @author Cesar Escalona
 * @version 1.0
 * SDEV - 333
 */

public class ReversibleTest {

    /**
     * @param args Main method containing helper methods that will test to make sure methods
     *             from reversible stack are working.
     */
    public static void main(String[] args) {
        printStuff();
        System.out.println();
        testException();
        System.out.println();
        testOtherException();
    }

    /**
     * This method will check if we can remove the last element in the stack, this
     * will throw a no such element exception.
     */
    public static void testException(){
        ReversibleStackAL<Integer> test = new ReversibleStackAL<>();
        try{
            test.remove();
            for (int i = 1; i <= 5; i++) {
                test.add(i);
            }
            test.remove();
        } catch (Exception e) {
            System.out.println("You cannot remove because this stack is empty");
        }
    }

    /**
     * This method will check if we can remove an element at a given index. This will
     * throw an unsupported operation exception error.
     */
    public static void testOtherException(){
        ReversibleStackAL<Integer> test = new ReversibleStackAL<>();
        try{
            test.remove(2);
            for (int i = 1; i <= 5; i++) {
                test.add(i);
            }
        } catch (Exception e) {
            System.out.println("This method is not supported in the structure.");
        }
    }

    /**
     * This method will test the Reversible stack class and make sure that
     * the methods work
     */
    public static void printStuff(){
        ReversibleStackAL<Integer> test = new ReversibleStackAL<>();
        for (int i = 1; i <= 7; i++) {
            test.add(i);
        }
        System.out.println(test);
        test.reverse();
        System.out.println(test);

        System.out.println("There are " + test.size() + " integers in the array.");
        System.out.println();
        System.out.println("The last element added to the top of the stack is = " + test.remove());

        System.out.println("Is the array empty? " + test.isEmpty()); // should be false
        System.out.println("Does it contain number 5? " + test.contains(5)); // should be true
        System.out.println("Does it contain number 1? " + test.contains(1)); // should be false

        System.out.println();
        System.out.println(test);
        System.out.println("There are now " + test.size() + " integers in the array.");

        System.out.println(test);
        test.clear();
        System.out.println("Is the array empty now? " + test.isEmpty());
    }
}
