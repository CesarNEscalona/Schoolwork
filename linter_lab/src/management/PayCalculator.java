package management;

/**
 *  This program will calculate the pay for employees based on the hours and pay.
 *  @author Cesar Escalona
 *  SDEV 333: Data Structures
 *  @version 2.0
 */

public class PayCalculator
{
    public static final int DEFAULT_HOURS = 40;
    public static final double OT_PAY = 0.5;
    private double payAmount;
    private String employeeFullName;

    /**
     * Parameterized constructor that creates a new calculator
     * @param payAmount - this employees pay amount in double format
     * @param employeeFullName - Employees full name
     */
    public PayCalculator(double payAmount, String employeeFullName)
    {
        this.payAmount = payAmount;
        this.employeeFullName = employeeFullName;
    }

    /**
     * This method returns the total of the pay for the employee
     * @param salaried- are they salary or not
     * @param hours- hours worked
     * @return salaried amount or calculate hours worked pay amount
     */
    public double calculatePay(boolean salaried, int hours)
    {
        if (salaried)
        {
            return payAmount;
        }
        else
        {
            double total = hours * payAmount;

            if (hours > DEFAULT_HOURS)
            {
                total += hours * (OT_PAY * payAmount);
            }

            return total;
        }
    }

    @Override
    public String toString() {
        return "PayCalculator{" +
                "payAmount=" + payAmount +
                ", EmployeeFullName='" + employeeFullName + '\'' +
                '}';
    }
}