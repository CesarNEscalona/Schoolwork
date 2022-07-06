/*
     Cesar Escalona
     IT-219
     This program will send out codewords and will return
     if they are true codewords or false codewords.
*/

public class CodeWordTester
{
   public static void main(String[] args)
   {
      CodeWord test1 = new CodeWord(5, 8, "$");
      test1.isValid("happy");
      test1.inValid("happy$");
      test1.inValid("sad");
      test1.inValid("sadness123");
      
      
      CodeWord test2 = new CodeWord(6, 20, "kind");
      test2.isValid("royalflush");
      test2.inValid("3ofakind");
      test2.inValid("sad");
      test2.inValid("sadness1234567890123456789");
   }
}