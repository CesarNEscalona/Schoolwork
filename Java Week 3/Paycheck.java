/*  Cesar Escalona
    01/15/2020
    This program will ask the user for their hourly rate and their hourly pay and calculate and display the gross paycheck amount
*/

import javax.swing.*;  //JOptionPane
import java.text.DecimalFormat;  //optional learning

public class Paycheck extends Object  //every java class extends the object superclass(parent) of all Java classes
{
     public static void main(String[] args)
     {
          //all dialog boxes return string of text as a default
          String rate = JOptionPane.showInputDialog(null, "Enter your hourly rate");
          // debug statement
          System.out.println(rate);
          
          String hours = JOptionPane.showInputDialog(null, "Enter your hours worked");
          System.out.println(hours);
          
          // convert String numbers to actual numbers for calculation purposes
          double hrRate = Double.parseDouble(rate);
          System.out.println(hrRate);
          
          double hrWorked = Double.parseDouble(hours);
          System.out.println(hrWorked);      
          
          //declare a variable to hold the paycheck amount
          double amount = hrRate * hrWorked;
          System.out.println(amount);
          
          DecimalFormat moneyFormat = new DecimalFormat("#,###.00");
          //display the amount in a dialog box
          JOptionPane.showMessageDialog(null, "You earned $" + moneyFormat.format(amount));
        
     
     
     }  // end of method





}  // end of class