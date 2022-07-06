/**
 *  Author: Cesar Escalona
 *  Sdev 301 Systems - Programming
 *  3/4/2021
 *  This program will implement the Runnable interface, it should output something using the run()
 *  and should output a statistics for the string when ran
 */

package startingthreads;

public class RunnableStringHolder implements Runnable{
    private String data;

    // default parameterized constructor
    public RunnableStringHolder(String data) {
        this.data = data;
    }

    // getter
    public String getData() {
        return data;
    }

    // setter
    public void setData(String data) {
        this.data = data;
    }

    // override run program from Runnable
    @Override
    public void run() {
        // print out the string when thread is ran
        System.out.println("As I expected. \"Marry Poppins, practically perfect in every way.\"");
        System.out.println("");

        // give data a string to output
        data = ("I am \"25\" years old today!");
        System.out.println(data);
        // Find how many characters are in this string
        System.out.println("String length: " + data.length());
        // create variables to use in the loop
        int alpha = 0;
        int digit = 0;
        int special = 0;
        // set up a loop that goes through and checks the characters at each i
        for (int i = 0; i < data.length(); i++) {
            char character = data.charAt(i);

            // if, else if, else to see if a char is alphabetic or digit...anything else is a special character
            if(Character.isAlphabetic(character)) {
                alpha++;
            }
            else if(Character.isDigit(character)){
                digit++;
            }
            else{
                special++;
            }
        }
        // print out the totals found
        System.out.println("Number of digits :" + digit);
        System.out.println("Number of alphabetic characters :" + alpha);
        System.out.println("Number of special characters :" +special);
    }

    // toString
    public String toString() {
        return data;
    }
}