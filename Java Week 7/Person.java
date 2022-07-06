
public class Person
{
	 // define the person's attributes/fields/instance variables
     private String name; 
     private int age;
     private String gender;

     // Default Person constructor
     public Person() 
     {
    	 name="User"; 
    	 age=1;
    	 gender="UNKNOWN"; 

     }
     
     // parameterized constructor
     public Person(String name, int age, String g)
     { 
   	 
    	 this.name=name;
    	 this.age=age;
    	 this.gender=g;

     }
     
    // Getters for Gender/Name/Age
     public String getGender()
     {
    	 return gender;
     }
    
     public String getName()
     {
    	 return name;
     }
     
     public int getAge()
     {
    	 return age;
     }
     
         
     // Setters or mutator method for Gender/Name/Age
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
     
    // Picks user's pet type based off of gender
     public String findPet()
     {

       // To give default to pet
       String pet = "";
       if (age <= 0){
         age= 0;
       }
       // To change gender to Upper-Case
       gender = gender.toUpperCase();

       // MALE batch of animals
       if (gender.equals("M") || gender.equals("MALE"))
       {

          if ( age <= 9)
          {

          pet = "sea horse";

          }

        else if (age >= 10 && age <= 29)
        {

          pet = "penguin";

        }

        else
        {

          pet = "lion";

        }

    }

    // FEMALE batch of animals
    else if (gender.equals("F") || gender.equals("FEMALE"))
      
    {

      if ( age <= 9)
      {
        pet = "big dog";

        }

        else if (age >= 10 && age <= 29)
        {

          pet = "small dog";

        }

        else 
        {

          pet = "bats";

        }

      }

      // NON BINARY batch of animals
      else if (gender.equals("NB") || gender.equals("NON BINARY") || gender.equals("NON-BINARY"))
      {
          if ( age <= 9)
        {

          pet = "ferret";

        }

        else if (age >= 10 && age <= 29)
        {

          pet = "lot of ferrets";

        }

        else
        {

          pet = "business of ferrets";

        }
      }

      // Catch all for the returns
      else 
      {
      
        pet = "pet rock";
      
      }

        return pet;
     }

     // Person Obj toString()
     public String toString() {
       return "Hey " + name + ", I suggest a " + findPet() + " as your next pet.";
    
     }


}
