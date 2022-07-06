  // Cesar Escalona
  //IT-219
  // HW Core Topics: methods, printlns
  //
  //This program will output All You Hungry Children song
  
     public class HungryChildrenSong {
     
        public static void main(String[] args) {
             verse1();
             verse2();
             verse3();
             verse4();
             verse5();
             verse6();
             verse7();
             all();
        }
       public static void all()
       {  
         System.out.println("All you hungry children, Come and eat it up!\n");
       }
       public static void mon()
       {  
         System.out.println("Monday, String Beans");
         all();
       }
       public static void tues()
       {  
         System.out.println("Tuesday, Spaghetti");
         mon();
       }
       public static void wed()
       {  
         System.out.println("Wednesday, Zoooop");
         tues();
       }
       public static void thurs()
       {  
         System.out.println("Thursday, Roast Beef");
         wed();
       }
       public static void fri()
       {  
         System.out.println("Friday, Fresh Fish");
         thurs();
       }
       public static void sat()
       {  
         System.out.println("Saturday, Chicken");
         fri();
       }
       public static void sun()
       {  
         System.out.println("Sunday, Ice Cream");
         sat();
       }
       public static void verse1()
       {  
         System.out.println("Today is Monday, Today is Monday,");
         mon();
       }
        public static void verse2()
       {  
         System.out.println("Today is Tuesday, Today is Tuesday,");
         tues();
       }
       public static void verse3()
       {  
         System.out.println("Today is Wednesday, Today is Wednesday,");
         wed();
       }
       public static void verse4()
       {  
         System.out.println("Today is Thursday, Today is Thursday,");
         thurs();
       }
       public static void verse5()
       {  
         System.out.println("Today is Friday, Today is Friday,");
         fri();
       }
       public static void verse6()
       {  
         System.out.println("Today is Saturday, Today is Saturday,");
         sat();
       }
       public static void verse7()
       {  
         System.out.println("Today is Sunday, Today is Sunday,");
         sun();
       }
}

/*
          ----jGRASP exec: java HungryChildrenSong
 Today is Monday, Today is Monday,
 Monday, String Beans
 All you hungry children, Come and eat it up!
 
 Today is Tuesday, Today is Tuesday,
 Tuesday, Spaghetti
 Monday, String Beans
 All you hungry children, Come and eat it up!
 
 Today is Wednesday, Today is Wednesday,
 Wednesday, Zoooop
 Tuesday, Spaghetti
 Monday, String Beans
 All you hungry children, Come and eat it up!
 
 Today is Thursday, Today is Thursday,
 Thursday, Roast Beef
 Wednesday, Zoooop
 Tuesday, Spaghetti
 Monday, String Beans
 All you hungry children, Come and eat it up!
 
 Today is Friday, Today is Friday,
 Friday, Fresh Fish
 Thursday, Roast Beef
 Wednesday, Zoooop
 Tuesday, Spaghetti
 Monday, String Beans
 All you hungry children, Come and eat it up!
 
 Today is Saturday, Today is Saturday,
 Saturday, Chicken
 Friday, Fresh Fish
 Thursday, Roast Beef
 Wednesday, Zoooop
 Tuesday, Spaghetti
 Monday, String Beans
 All you hungry children, Come and eat it up!
 
 Today is Sunday, Today is Sunday,
 Sunday, Ice Cream
 Saturday, Chicken
 Friday, Fresh Fish
 Thursday, Roast Beef
 Wednesday, Zoooop
 Tuesday, Spaghetti
 Monday, String Beans
 All you hungry children, Come and eat it up!
 
 All you hungry children, Come and eat it up!
 
 
  ----jGRASP: operation complete.
 
*/