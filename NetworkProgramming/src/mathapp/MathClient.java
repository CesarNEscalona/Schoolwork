package mathapp;

import java.net.*;
import java.io.*;
import java.util.*;

public class MathClient {
    public static void main(String[] args) {
        // create a client Socket
        try(Socket client = new Socket("localhost", MathServer.MATH_PORT)){

            // create Scanner object that connects to the console
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter two integers separated by a space: ");
            String nums = kb.nextLine();

            // setup pipelines nd set up new Scanner and PrintWriter
            Scanner in = new Scanner(client.getInputStream());
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // send our nums to the server
            out.println(nums);

            // receive the response back from the server (calculate)
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}