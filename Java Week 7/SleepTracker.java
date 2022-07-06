import java.util.*;
import javax.swing.*;

// this program will be helpful for CalorieTracker
// we will prompt the user for how many days they slept
// and then get the amount of sleep for each day
// and provide the average hours they slept

public class SleepTracker
{
   public static void main(String[] args)
   {
      int numDays = getNumDays();
      int total = getSleepHours(numDays);
      JOptionPane.showMessageDialog(null, "Total hours sleep: "+total);
   
   
   
   }
   // this method asks the user for the number of days they slept
   // and returns the number of days
   public static int getNumDays()
   {
      int days = Integer.parseInt(JOptionPane.showInputDialog(null,
         "Enter the number of days you slept: "));
         return days;
   }
   
   // This method will prompt the user for the hours slept
   // each day and return the total for the number of days
   // that is passed as a parameter
   public static int getSleepHours(int days)
   {
      // use a for loop to prompt for hours per day
      int total = 0;
      int hours = 0;
      for(int count = 1; count <= days; count++)
      {
         hours = Integer.parseInt(JOptionPane.showInputDialog(null,
         "Enter the number of hours you slept on day " +count+ ": "));
         total += hours;
      }
      return total;
   }

}