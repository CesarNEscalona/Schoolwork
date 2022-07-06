package mathapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class MathServer {

    // decide on a port so the client knows what to connect to
    public static final int MATH_PORT = 8045;

    public static void main(String[] args) {
        // use a try with to create a Server socket so it is automatically
        // closed if there is an error
        try(ServerSocket server = new ServerSocket(MATH_PORT)){
            System.out.println("Math server is starting....");

            // connect to client
            Socket client = server.accept();
            System.out.println("Found a client");

            // setup pipelines to send data to the client and receive data from the client
            InputStream inputStream = client.getInputStream(); // receives data from the client
            OutputStream outputStream = client.getOutputStream(); // sends data to the client

            // use Scanner for inputStream
            Scanner in = new Scanner(inputStream);

            // use PrintWriter for outputStream
            PrintWriter out = new PrintWriter(outputStream);

            // read in data from client using Scanner
            String data = in.nextLine();
            try {
                // 10 2  "10 2" anystring.split(" ")
                String[] nums = data.split(" ");
                // nums[0]= "10"   nums[1]= "2"
                int num1 = Integer.parseInt(nums[0]);
                int num2 = Integer.parseInt(nums[1]);
                calculate(num1, num2, out);
                // Integer.parseInt()  "asdf"
             } catch(Exception e) {
                out.println("Math protocol error: <num1> <num2>");
                out.flush(); // send everything in the buffer right away, flushing the buffer
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void calculate(int num1, int num2, PrintWriter out) {
        out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        if(num2 != 0)
            out.println(num1 + " / " + num2 + " = " + (num1 / num2));
        else
            out.println("Cannot divide by zero");
        out.println(num1 + " % " + num2 + " = " + (num1 % num2));
        out.flush();  // send to the client now
    }
}