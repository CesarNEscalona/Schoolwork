/*
   Cesar Escalona
   It-219
   This program features methods that will return a string of letters in reverse order
   return the number of times a letter was found in the text
   and returns a phone number with () around the area code
*/

public class StringPractice
{
   public static void main(String[] args)
   {
      // declare a state vaiable and 
      // initialize to "mississippi"
      String state = new String("mississippi");
      System.out.println(state);
      
      // replace all s characters with p
      state = state.replace('s', 'p');
      
      System.out.println(state);
      
      String team = "seahawks";
      // print out the index for the first a character
      int index = team.indexOf("a");
      System.out.println("a is at index: " + index);
      
      // loop through team and create a new string with
      // whitespace after each letter
      // "s e a h a w k s "
      String  spaceTeam = "";  // emptry string
      // loop through the team
      for(int i = 0; i < team.length() ; i++)
      {
         // access the character in team at i and concatenate with
         // spaceTeam
         spaceTeam = spaceTeam + team.charAt(i) + " ";
         // or
         // spaceTeam += team.charAt(i) + " ";
      }
 
      System.out.println(spaceTeam + "has a length " +spaceTeam.length());
      
      // Call username
      String userName = findUsername("cescalona@greenriver.edu");
      System.out.println(userName);
      
      String reversed = reverseLetters(team);
      System.out.println(reversed);
      
      int count = findCount(state, 'p');
      System.out.println(state+" has this many p's  "+count);
       
      String newPhone = formatPhone("206-454-9087");
      System.out.println(newPhone);
   } // end of main method
   
   // this method returns the number of times the letter
   // is found in the team parameter
   public static int findCount(String word, char letter)
   {
      int count = 0;
      for( int i = 0; i <= word.length() - 1; i++)
      {
        if(word.charAt(i) == letter)
           count++; 
      }
      return count;
   }
   
   // thus method returns a phone number reformatted as a new
   // string
   //   area code 206
   // old 206-234-7898  return (206)234-7898
   // precondition: oldPhone format 000-000-0000
   public static String formatPhone(String oldPhone)
   {
      int dashIndex = oldPhone.indexOf("-");
      // dashIndex will have 3 in it
      // hint: think about using substring( )
      // use concatenation + like "("+ area + ")" + rest
      // int area = oldPhone.subString(0, 3)
      String areaCode = oldPhone.substring(0,dashIndex);
      // System.out.print(areaCode);
      String newPhone = "(" + areaCode + ")";
      String rest = oldPhone.substring(4);
      return newPhone + rest;
      // also can do
      // return "(" + areaCode + ")" + rest + 
   }
  
   // This method receives some letters and returns a
   // new String with the letters in reverse
   // Ex: seahawk      returns kwahaes
   public static String reverseLetters(String team)
   {
      String reversed = "";
      // loop through the string from end to last to first
      int len = team.length(); // number of characters
      for(int i = len - 1; i >= 0; i--)
      {
         reversed += team.charAt(i);
      }
      
      return reversed;
   }
   
   // this method will receive an email address
      // cescalona@greenriver.edu
      // and return just the username portion
      public static String findUsername(String email)
      {
         int atSign = email.indexOf("@");
         return email.substring( 0, atSign);
      }
}