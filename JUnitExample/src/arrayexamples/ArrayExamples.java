package arrayexamples;

public class ArrayExamples {

    public static void main(String[] args) {
        // create arrays of integers
        int[] numbers1 = {2, 3, 4, -9, 7, 8};
        int[] numbers2 = {2, 3, 4, 9, 7, 8};

        // create arrays of decimals
        double[] decimalsAsc = {2.5, 3.0, 5.1};
        double[] decimalsDes = {5.1, 3.0, 2.5};

        // create array of strings
        String[] fruits = {"orange", "apple", "banana"};


        System.out.println("Largest num is 8: " + findLargest(numbers1));
        System.out.println("Negative Number at Index 3: " + findNegative(numbers1));
        System.out.println();

        System.out.println("Largest num is 9: " + findLargest(numbers2));
        System.out.println("Negative Number at Index -1: " + findNegative(numbers2));
        System.out.println();

        System.out.println("Ascending Order true: " + sorted(decimalsAsc));
        System.out.println("Ascending Order false: " + sorted(decimalsDes));
        System.out.println();

        System.out.println("Duplicated apple true: " + duplicates(fruits, "apple"));
        System.out.println("Duplicated grape false: " + duplicates(fruits, "grape"));
        System.out.println();
    }

    /**
     * This method finds the largest integer in an array and returns the value or
     * if the array's length is zero, it returns Integer.MIN_VALUE
     *
     * @param arr array of integers
     * @return the largest value in the array, returns Integer.MIN_VALUE if length is 0
     */
    public static int findLargest(int[] arr) {

        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max)
                max = num;
        }

        return max;
    }

    /**
     * This method will determine if an array of decimal numbers is sorted
     * in increasing/ascending order
     *
     * @param arr array of decimal numbers
     * @return true if numbers are in ascending order, false otherwise
     */
    public static boolean sorted(double[] arr) {

        // make sure you do not let i equal the last index
        // as checking i and i + 1 for the decision
        for (int i = 0; i < arr.length - 1; i++) {
            // if the current element is greater than the next element
            if (arr[i] > arr[i + 1]) {
                // not sorted in increasing order
                return false;
            }
        }
        // sorted in increasing order
        return true;
    }

    /**
     * This method determines if a string is in the array.  The string much match exactly (case-sensitive)
     *
     * @param arr    array of strings to search
     * @param search value to be found
     * @throws IllegalArgumentException if search string is null
     * @return true if search value found, false otherwise
     */
    public static boolean duplicates(String[] arr, String search) {

        if(search == null) {
            throw new IllegalArgumentException();
        }

        for (String s : arr) {
            // if search string found
            if (s.equals(search)) {
                return true;
            }

        }
        return false;
    }

    /**
     * This method returns the index of the first negative integer
     * found in the array from lowest to highest index
     *
     * @param arr integer array to search for negatives
     * @return index for first negative integer, -1 otherwise
     */
    public static int findNegative(int[] arr) {

        for (int index = 0; index < arr.length; index++) {

            // if value is negative
            if (arr[index] < 0) {
                return index;
            }
        }
        return -1;
    }

}
