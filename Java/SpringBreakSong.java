/**
 *    @author
 *    This class displays the lyrics to a song using methods to reduce code redundancy.
 *    One println statement for each DISTINCT line of the song appears ONCE in the methods below.
 *    Every method is calling at least one other method to reduce code redundancy.
 *
 *
 */
public class SpringBreakSong
{
   public static void main(String[] args)
    {
         verse1();
         verse2();
         verse3();
         verse4();
         verse5();
    }
    public static void love()
    {
    System.out.println("My true love gave to me");
    }
    public static void netflix()
    {
    System.out.println("Two Netflix episodes");
    and();
    }
    public static void teas()
    {
    System.out.println("Three Black Teas");
    netflix();
    }
     public static void and()
    {
    System.out.println("And a bottle of sunscreen in a blue bag");
    System.out.println("");
    }
     public static void four()
    {
    System.out.println("Four Lottery Tickets");
    teas();
    }
     public static void five()
    {
    System.out.println("Five Free Bus Rides");
    four();
    }
    public static void verse1()
    {
      System.out.println("The Five Days of Spring Break\n");
      System.out.println("On the first day or Spring Break");
      love();
      System.out.println("A bottle of sunscreen in a blue bag\n");
    }
    public static void verse2()
    {
      System.out.println("On the second day or Spring Break");
      love();
      netflix();       
    }
    public static void verse3()
    {
     System.out.println("On the third day or Spring Break");
      love();
      teas();
    }
    public static void verse4()
    {
     System.out.println("On the fourth day or Spring Break");
      love();
      four();
    }
   public static void verse5()
   {
   System.out.println("On the fifth day or Spring Break");
      love();
      five();
   }

   // more static methods need to be defined here

/*  
      
  ----jGRASP exec: java SpringBreakSong
 The Five Days of Spring Break
 
 On the first day or Spring Break
 My true love gave to me
 A bottle of sunscreen in a blue bag
 
 On the second day or Spring Break
 My true love gave to me
 Two Netflix episodes
 And a bottle of sunscreen in a blue bag
 
 On the third day or Spring Break
 My true love gave to me
 Three Black Teas
 Two Netflix episodes
 And a bottle of sunscreen in a blue bag
 
 On the fourth day or Spring Break
 My true love gave to me
 Four Lottery Tickets
 Three Black Teas
 Two Netflix episodes
 And a bottle of sunscreen in a blue bag
 
 On the fifth day or Spring Break
 My true love gave to me
 Five Free Bus Rides
 Four Lottery Tickets
 Three Black Teas
 Two Netflix episodes
 And a bottle of sunscreen in a blue bag
 
 
  ----jGRASP: operation complete.
 

*/








}