import java.util.*;
import java.io.*;

public class AverageGrades
{
    public static void main(String[] args)throws FileNotFoundException
    {
       
       
       
       
       // create an array with initializer list
       //double[] grades = { 76.5, 68.3, 89.5, 98.3, 0.0 };
       double[] grades = new double[5];
       // Create Scanner to read file
       Scanner fileIn = new Scanner(new File("grades.txt"));
       int index = 0;
       // while there are decimal numbers in the file
       while (fileIn.hasNextDouble())
       {
          grades[index] = fileIn.nextDouble();
          index++;
       
       }
       
       double avg = calcAverage(grades); 
       System.out.println("Average is "+avg);    
       System.out.println(Arrays.toString(grades));  
    }
    
    // This method receives an array of decimal numbers
    // and returns the average of the number
    public static double calcAverage(double[] myArray)
    {
       double total = 0.0;
       
       // use for each or traditional loop
       for(double g : myArray)
       {
           total += g;
       }
       return total / myArray.length ;
    }
}