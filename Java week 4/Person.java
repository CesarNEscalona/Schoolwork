public class Person extends Object
{
   //  instance variables/fields/properties
   private String name;  // null s default
   private int age; // default is 0
   
   // default constructor
   public Person()
   {
      name = "";  // empty string
      age = 30;
   }
   //Parameterized Constructor
   public Person(String name, int a)
   {
        // properties/field always on the left side of assignment
        this.name = name;
        age = a;
   }
   
   //method that lets us know if Two Person objects have the same age
   public boolean sameAge(Person other)
   {
       // return this.age == other.age
       if (this.age == other.age)
       {
          return true;
       }
       else
       {
          return false;
       }
   }
   
   
   // accessor method / getter method
   public String getName()
   {
       return this.name;
   }
   
   // setter method / mutator
   public void setName(String n)
   {
       name = n;
   }
   
   // Override toString()
   //  this metod returns a String represet the state of the object
   
   public String toString()
   { 
       return "Name: "+name+" Age: "+age;
       
   } // end of toString
}

/*
  when you create a class you give it a constructor.



*/