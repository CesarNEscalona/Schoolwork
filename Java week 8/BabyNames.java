import java.util.*;  // Scanner 
import java.io.*; // Exceptions
import javax.swing.*;

public class BabyNames
{
    private static final int FILE_LENGTH = 123775;
    
    // read in "WA.TXT" into an array of strings
    public static void main(String[] args)
    {
       String[] data = new String[FILE_LENGTH]; //null
       
       try(Scanner fileIn = new Scanner(new File("WA.TXT")))
       {
          int index = 0;
          // success block
          while(fileIn.hasNextLine())
          {
             data[index] = fileIn.nextLine();
             // increment the index
             index++;
          }
    
       }
        catch (FileNotFoundException exception)
        {
       
          System.err.println(exception);
        }
    
       // get year from the user and the gender from the user
       String year = JOptionPane.showInputDialog(null,"Enter year:");
       String gender = JOptionPane.showInputDialog(null,"Enter gender: M or F");
       
       String[] pieces = findMostPopularName(gender,year,data);
       String result = "Most popular baby name is "+pieces[3]+" in " + pieces[0] + " for " + pieces[2];
       JOptionPane.showMessageDialog(null,result); 
    }
    
    // This method will go through the array of strings in data,
    // use split(",") and check if the passed in gender and year
    // matches the split items, return the split items as an
    // array of Strings
    public static String[] findMostPopularName(String gender,
        String year, String[] data)
    {
       // go through data (for loop)
       for(String lineItem : data)
       {
           // split each line of data into pieces
           String[] pieces = lineItem.split(",");
           // IF gender.equalsIgnoreCase(pieces[1])  
           // AND year.equalsIgnoreCase(pieces[2])
           if(gender.equals(pieces[1]) && year.equals(pieces[2]))
           {
              return pieces;
           }
       }
       return null;
    }
}