import java.util.Scanner;

public class ConsoleCalculator
{
    public static void main(String[] args)
    {
       //  create/construct pattern
       //  for creating a Java object
       //  System.in connects to the keyboard
       Scanner scan = new Scanner(System.in); 
       
       //  prompt user for a double number
       System.out.print("Enter a decimal: ");
       //  read in the number the user inputed
       double num = scan.nextDouble();
       System.out.println(num);
       
       //  prompt user for an integet number
       System.out.print("Enter a num: ");
       int num2 = scan.nextInt();
       
       System.out.println("Total is " + (num + num2));
    }
}