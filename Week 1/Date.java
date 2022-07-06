/*
   Author: Cesar Escalona
   04/17/2020
   It-220
   Version: 2.0
   This program will aid in the Birthday.java class we created a few days ago
*/

public class Date
{
   private int month;  // field
   private int day;    // field
   
   // Parameterized constructor
   public Date(int month, int day)
   {
      this.month = month;
      this.day = day;
   }
   
   // getter
   public int getMonth()
   {
      return month;
   }
   
   // getter
   public int getDay()
   {
      return day;
   }
   
   // setter or mutator
   public void setDate(int month, int day)
   {
      this.month = month;
      this.day = day;
   }
   
   // toString method that takes in month and day and displays them as 1/2
   public String toString()
   {
      return month + "/" + day;
   }
   
   // boolean method that checks if todays date = user's birthday
   public boolean equals(Date d)
   {
      if(this.month == d.month && this.day == d.day)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   // this method connects the month number with the number of days in that month
   public int daysInMonth()
   {
      if (month == 1)
      {
         return 31;
      }
      else if (month == 2)
      {
         return 28;
      }
      else if (month == 3)
      {
         return 31;
      }
      else if (month == 4)
      {
         return 30;
      }
      else if (month == 5)
      {
         return 31;
      }
      else if (month == 6)
      {
         return 30;
      }
      else if (month == 7)
      {
         return 31;
      }
      else if (month == 8)
      {
         return 31;
      }
      else if (month == 9)
      {
         return 30;
      }
      else if (month == 10)
      {
         return 31;
      }
      else if (month == 11)
      {
         return 30;
      }
      else if (month == 12)
      {
         return 31;
      }
      return day;
   }
   
   // this method adds a day to today's date.
   // if 12/31 it changes the date to 1/1...1/31 to 2/1 and so on
   public void nextDay()
   {
      day++;
      if(day > daysInMonth())
      {
         month++;
         day = 1;
      }
      if(month > daysInMonth())
      {
         month++;
         month = 1;
      }
   }
}