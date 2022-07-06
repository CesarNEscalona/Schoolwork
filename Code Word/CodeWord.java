/*
     Cesar Escalona
     It-219
     This program will check the codewords from CodeTester and will
     return if the codeword is true or false.
*/

public class CodeWord
{
   private int min;
   private int max;
   private String invalidText;
   
   // Parameterized Constructor
   public CodeWord(int minimum, int maximum, String invalidText)
   {
      min = minimum;
      max = maximum;
      invalidText = invalidText;
   }
   // Second Constructor
   public String inValid(String invalidText)
   {
      this.invalidText = invalidText;
      System.out.println("False");
      return "False";
   }
   // Third Constructor
   public String isValid(String potentialCodeWord)
   {
        System.out.println("True");
        return "True";
   }
   // ToString Method
   public String toString()
   {
      return " ";
   }
}