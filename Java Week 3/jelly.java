/*

  Names: Cesar Escalona and Ian Schroeder
  Date: 17Jan20

  This program will take input from the user via dialog boxes
  and compute the likely amount of jellybeans in a container
  based on the dimensions of both the jelly beans and the container

  j = jelly bean
  a = length of jelly bean
  b = height of jelly bean
  final double load factor of 0.698

  v * F/j : formula for container estimate # of jelly beans

*/
//import acm.graphics*
import acm.program.*;
import javax.swing.*;  // JOptionPane

public class jelly extends Object  
{
  public static void main(String[] args) 
  { 
     // creating a dialog box to prompt user for jelly bean length
    String length = JOptionPane.showInputDialog(null, "Enter jelly  bean length (cm): ");
    System.out.println(length);
    
    // creating a dialog box to prompt user for jelly bean height
    String height = JOptionPane.showInputDialog(null, "Enter jelly bean height (cm): ");
    System.out.println(height);
    
    // creating a dialog box to prompt user for jar size
    String jar = JOptionPane.showInputDialog(null, "Enter jar size (mL): ");
    System.out.println(jar);
    
    // convert String numbers to actual numbers for calculation purposes
    double lengthSize = Double.parseDouble(length);
          
    double heightSize = Double.parseDouble(height);
          
    double jarSize = Double.parseDouble(jar);
    //int jarSize = Integer.parseInt(jar);

    // calculating the volume of a jelly bean
    double beanVolume = (5  * Math.PI * lengthSize * (heightSize*heightSize) / 24);
    System.out.println(beanVolume);
    
    // declaring load factor constant
    final double LOAD_FACTOR = 0.698;
    
    // calculating the estimated amount of jelly beans in the container
    double estimate = (jarSize * LOAD_FACTOR / beanVolume);

    // convert double to int 
    int esti = (int)estimate;
    //System.out.println(estimate);

    // displaying the final estimate for the user
    JOptionPane.showMessageDialog(null,"There are approximately " + esti + " jelly beans in the jar.");

  }// end of main method

}// end of class