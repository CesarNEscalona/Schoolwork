/*
   Cesar Escalona
   it-219
   This program will roll a die and give you the value

*/
public class DieTester
{
   public static void main(String[] args)
   {
      Die d1 = new Die(6);
      d1.roll();
      System.out.println(d1);
      
      d1.setNumSides(20);
      System.out.println(d1.getNumSides());
   }
}