public class PersonClient
{    
     public static void main(String[] args)
     {     
          // construct a person
          // classmate myobj = new
          Person p1 = new Person();
          
          // construct a person with the parameterized constructor
          Person p2 = new Person("Jim",62);
          
          //System.out.println(p1.getName);
          
          // change Jim to Mary 
          p2.setName("Mary");
          
          // call toString for p1
          System.out.println(p2.toString());
          
          //              this       other
          boolean answer = p1.sameAge(p2);
     }
}