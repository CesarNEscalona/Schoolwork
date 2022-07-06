import java.io.*;
import java.util.*;

public class ReadingFilesWithIntrgers
{
   public static void main(String[] args)
   {
      // create a file object that is going to look for 
      // to numbers.txt    pass the file name as a string
      // to the File constructor method
      File fileObj = new File("numbers.txt");
      System.out.println(fileObj.exists());
      
      // declare an integer array that can hold 15 numbers
      int[] numsArray = new int[15];  // will create 15 buckets with 0's
      
      // use a try catch to attempt to open the
      // file numbers.txt with Scanner object
      try(Scanner file_in = new Scanner (fileObj))
      {  // entry try block if successful
         int index = 0;
         while(file_in.hasNextInt())
         {
            // read in the next integer
            numsArray[index] = file_in.nextInt();
            System.out.println(numsArray[index]);
            index++;
         }  // end of while
      }  // end of try
      
      catch(FileNotFoundException exception)
      {  // enter to catch block if successful
         System.err.println(exception.toString());
      }  // end of catch
      System.out.println("Program still running");
      System.out.println(Arrays.toString(numsArray));
      
      
   
   } // end of method




} // end of class

