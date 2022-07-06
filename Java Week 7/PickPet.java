/* Name: David Larson & Joanna Folk
Date: 02/14/2020
Files: Person.java, PickPet.java
Purpose: To suggest a pet based off a person's gender and age */

import java.util.*;

class PickPet {

  public static void main(String[] args) {
   
   Scanner userInput = new Scanner(System.in);
   
   // prompt user for their gender, age and name - with Scanner
   System.out.print("Please enter your gender: (m/f/nb) ");
   String userGender = userInput.nextLine();
   
   System.out.print("Please enter your age: ");
   int userAge = userInput.nextInt();
   
   while(userAge <= 0){
  
    System.out.print("Error, Please enter your age: ");
    userAge = userInput.nextInt();
  
   }

   System.out.print("Please enter your name: ");
   userInput.nextLine();
   String userName = userInput.nextLine();

   while(userName.length() == 0){
     System.out.print("Error, Please enter your name: ");
     userName = userInput.nextLine();

   }
   
   Person user = new Person(userName,userAge,userGender);
  //grabbing all the person  traits and creating a PickPet object
    // I think this step is unneccesary but this way we will have to diffferent objects  to call on. thought tht may be usefull for some reason?

   //PickPet pick = new PickPet(user.getAge(),user.getGender(),user.getName());

   // Output Obj toString() for user
   System.out.println(user.toString());
  
  }
}

/*

  Please enter your gender: (m/f/nb) Male
  Please enter your age: 28
  Please enter your name: Dave
  Hey Dave, I suggest a penguin as your next pet.

*/