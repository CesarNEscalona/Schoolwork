/*
    Author: Cesar Escalona
    Date: 2/25/21
    Sdev 378
 */

import java.util.*;

public class Numbers {
    // instance fields with scope over entire program
    private static int SMALLEST = 1000000000;
    private static int LARGEST = 0;
    private static int TOTAL = 0;

    public static void main(String[] args) {

        // created a scanner to ask the user for input
        Scanner Input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        // create a counter that will stop the loop
        int count = 0;
        // This will loop 5 times to ask the user for 5 numbers
        while (count < 5) {
            System.out.println("Please enter a number: ");
            // this saves the number that is entered to a variable
            int num1 = Input.nextInt();
            // this adds the number to the array list
            list.add(num1);
            // very important to increment the counter each time
            count++;
        }

        // create a for loop to iterate through to find the smallest number
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            if (number < SMALLEST) {
                SMALLEST = number;
            }
            // this is how to find the largest number
            if (number > LARGEST) {
                LARGEST = number;
            }
        }

        // this loop will add all numbers entered and give a total
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            TOTAL += num;
        }
        // this will take the total and divide by 5 - getting the average
        int avg = TOTAL / 5;

        // print out statements to show work is complete
        System.out.println("The largest number is " +LARGEST);
        System.out.println("The smallest number is " + SMALLEST);
        System.out.println("The average of these numbers is " + avg);
        System.out.println(list);
    }
}