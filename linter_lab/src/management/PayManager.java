package management;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  This program will ask the user for input and determine the pay based on the
 *  information inputted
 *  @author Cesar Escalona
 *  SDEV 333: Data Structures
 *  @version 2.0
 */
public class PayManager
{

    public static final int PAD = 12;

    /**
     * @param args - This method should run until stopped, console should ask the user for
     *               a name, pay, hours worked and output a total.
     */
    public static void main(String[] args)
    {
        //run test
        try (Scanner console = new Scanner(System.in))
        {
            // only run program for 3 entries
            int counter = 0;
            while(counter < 3){
                //enter a name
                System.out.print("Enter a name: ");
                String name = console.nextLine();

                //get a pay rate and print the pay
                System.out.print("Enter a pay rate: ");
                double payRate = console.nextDouble();
                console.nextLine();

                //enter an amount of hours
                System.out.print("Enter # of hours: ");
                int hours = console.nextInt();
                console.nextLine();

                //pad hours by 12
                hours += PAD;

                PayCalculator calculator = new PayCalculator(payRate, name);
                double pay = calculator.calculatePay(false, hours);

                System.out.println("Pay: $" + pay);
                counter++;
                System.out.println();
            }
        }
        catch (InputMismatchException ex)
        {
            System.out.println("Input mismatch");
        }
        catch (Exception ex)
        {
            System.out.println("Error!");
        }
    }
}