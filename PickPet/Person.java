
public class Person 
{
	 // define the person's attributes/fields/instance variables
     private String name; 
     private int age;
     private String gender;

     // provide a default constructor
     // to replace Java's automatically
     // provided constructor
     public Person() 
     {
    	 name="Unknown"; 
    	 age=1;
    	 gender="Unknown"; 
     }
     
     // parameterized constructor
     public Person(String name, int age, String g)
     { 
    	 // instance variables ALWAYS  go on the left side of the =     	 
    	 this.name=name;
    	 this.age=age;
    	 gender=g;
     }
     
     // getter
     public String getGender()
     {
    	 return this.gender;
     }
     
     public String getName()
     {
    	 return this.name;
     }
     
     public int getAge()
     {
    	 return this.age;
     }
         
     // setters or mutator method
     public void setGender(String gender)
     {
    	 this.gender = gender;
     }
     
     public void setName(String n)
     {
    	 name = n;
     }
     
     public void setAge(int age)
     {
    	 this.age = age;
     }
     
     // This method suggests a pet choice for the person based on their age and gender
     // and returns the pet choice as a String
     public String findPet()
     {
       if(gender.equalsIgnoreCase ("Male") && age >= 30)
       {
          return "Hey " +name+ ", I suggest a German Shepherd as your next pet.";
       } 
       else if(gender.equalsIgnoreCase ("Female") && age >= 30)
       {
          return "Hey " +name+ ", I suggest a Cat as your next pet.";
       }
       else if(gender.equalsIgnoreCase ("Male") && age < 10)
       {
          return "Hey " +name+ ", I suggest a Clam as your next pet.";
       } 
       else if(gender.equalsIgnoreCase ("Female") && age  < 10)
       {
          return "Hey " +name+ ", I suggest a Dragon as your next pet."; 
       }
        else if (gender.equalsIgnoreCase ("Male") && age  >= 10)
       {
          return "Hey " +name+ ", I suggest a Panda as your next pet."; 
       }
        else if(gender.equalsIgnoreCase ("Female") && age  >= 10)
       {
       return "Hey " +name+ ", I suggest a Snake as your next pet."; 
       }
       else
       {
       return "";
       }
     }
        
    @Override
    public String toString() {
    return "Person name: "+name+"\n"
                          +"age: "+age+"\n"
                          +"gender: "+gender+"\n"
                          +findPet()+"\n";          
                          }
}