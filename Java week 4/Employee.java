public class Employee
{
   private int empNum;
   private double empSalary;
   
   // default constructor
   public Employee()
   {
      this.empNum = 15;
      this.empSalary = 500.00;
   }
   
   // parameterized constructor
   public Employee(int emp, double sal)
   {
      this.empNum = empNum;
      this.empSalary = empSalary;
   }
 
   // setter
   public void setEmpNum(int emp)
   {
      empNum = emp;
   } 
   
   // setter
   public void setEmpSalary(double sal)
   {
      empSalary = sal;
   }
     
   // toString 
   public String toString()
   {
      return "\nEmployee: "+empNum+"\nSalary: "+empSalary;
   }
  
   // main method
   public static void main(String[] args)
   {
      // construct an employee named employee15
      Employee employee15 = new Employee();
      // print out the state of employee15
      System.out.println(employee15.toString());
   }
}