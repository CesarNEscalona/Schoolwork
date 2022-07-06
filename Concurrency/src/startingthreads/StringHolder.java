/**
 *  Author: Cesar Escalona
 *  Sdev 301 Systems - Programming
 *  3/4/2021
 *  This program will extend the Thread class and prints out a string that is stored in the class
 *  to the Java console, this is the older way to create a thread (extends a thread class)
 */

package startingthreads;

public class StringHolder extends Thread{
    private String data;

    public StringHolder(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.println("As I expected. \"Marry Poppins, practically perfect in every way.\"");
    }

    public String toString() {
        return data;
    }
}