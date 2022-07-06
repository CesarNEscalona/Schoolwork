//This program will read in two numbers and compute the sum and display in a dialog box.

import javax.swing.*;


public class Calculator 
{
     public static void main(String[] args)
     {
          //  prompt the user for a number
          //  and save in a string number
          String strNum = JOptionPane.showInputDialog(null, "Enter Number:");
          
          //turn "23" into 23  a Strimg into a number
          double num1 = Double.parseDouble(strNum);
          
          int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Number:"));
          
          // calculate the sum and store it in a variable named total
          double total = num1 + num2;
          
          //display the total in a dialog box
          JOptionPane.showMessageDialog(null, "Total is " + total);
     
     
     }





}