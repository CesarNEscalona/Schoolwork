/*
   Cesar Escalona
   it-220
   04/14/2020
   This program will prompt the user for input on today's date, their birthday
   and will display the number of days in their birthday month as well as
   how many days until their birthday.
*/

import java.util.Scanner;

public class Birthday
{
     public static void main(String[] args)
     {
        // this adds the scanner in
        Scanner kb = new Scanner(System.in);
        
        // this asks the user for today's date
        System.out.print("What is today's date? (Month and Day?)");
        int month = kb.nextInt();
        int day = kb.nextInt();
        Date today = new Date(month, day);
        // System.out.println(today.toString());
        
        // This asks the user for for their birthday month and day
        System.out.print("What is your birthday? (Month and Day?)");
        int birthMonth = kb.nextInt();
        int birthDay = kb.nextInt();
        Date birth = new Date(birthMonth, birthDay);
        // System.out.println(birth.toString());
        
        // this will print out how many days are in your birth month
        System.out.println("There are "+ birth.daysInMonth() + " days in month #" + birthMonth);
        
        // This will print out Happy Birthday if today is their birthday, otherwise it will print
        // out how many days until their birthday
        if(today.equals(birth))
        {
           // if today is their birthday it will print out Hbd
           System.out.println("Happy Birthday!!!");
        }
        else 
        {
           // this counts the days until the birthday
           int daysUntilBday = 0;
           while(!today.equals(birth))
              {
                 today.nextDay();
                 daysUntilBday++;
              }  // end of while
              
           System.out.println("Number of days until birthday "+ birth.toString() + ": " + daysUntilBday);
        } // end of if/else
     } // end of main method
} // end of class