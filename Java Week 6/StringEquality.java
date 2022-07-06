
public class StringEquality
{
	public static void main(String args[])
	{
      String s1 = new String("Go");
      String s2 = new String("Go");
     
     if(s1.equals(s2))
        System.out.println(".equals() is true");
        
     if(s1 == s2)
        System.out.println(" s1 == s2 is true");
	}
}

