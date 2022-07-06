import java.io.*;  // or can use * instead of File for all classes
import java.util.*;

public class FileReader
{
   public static void main(String[] args)
        throws FileNotFoundException
   {
      File data = new File("sick.txt");
      
      System.out.println("exists returns " + data.exists());
      System.out.println("canRead returns " + data.canRead());
      System.out.println("getAbsolutePath returns " + data.getAbsolutePath());
      
      // create a Scanner object that can read the file
      Scanner file_in = new Scanner(data);
      // create a String array to hold the data from the file
      
      String[] dataLines = new String[3];
      int index = 0;
      while(file_in.hasNextLine() == true)
      {
         String line = file_in.nextLine();
         System.out.println(line);
         // save the line in an array to work with later
         dataLines[index] = line;
         // increment the index
         index++;
      } // end of while loop
      
      // debug check out the contents of the array
      System.out.println(Arrays.toString(dataLines));
   }
}