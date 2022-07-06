/*
   Cesar Escalona
   It-219
   This program prompts the user for input from their daily meals
   over the past two days. It computes the total caloric intake for each day,
   and then determine which day was better for staying on track with their
   fitness goals
*/

import java.util.*;

public class MyCalorieTracker
{   
   public static void main(String[] args)
   {
      printWelcomeMessage();
      usersCalorieGoal();
      findNetCalories();
   }  // End of main
   
   // Method that will display welcome message
   public static void printWelcomeMessage()
   {
      System.out.println("This program compares your daily caloric intake");
      System.out.println("for two days and determines which day was better");
      System.out.println("in regards to reaching your fitness goals\n");
   } // End of welcome
   
   // This method will prompt the user to enter their calorie goal
   public static int usersCalorieGoal()
   {
      Scanner scanner = new Scanner(System.in);
      System.out.print("What is your daily calorie goal?   ");
      int calorieGoal = scanner.nextInt();
      scanner.nextLine();
      return calorieGoal;
   }  // end of calGoal
   
   // This method will ask the user for level of activity
   public static int usersActivityLevel()
   {
         Scanner scanner = new Scanner(System.in);
         System.out.println("What was your activity level? 1) Not acive   2) lightly active");
         System.out.println("                              3) active or   4) very active?  ");
         int activityLevel = scanner.nextInt();
         int caloriesBurned = activityLevel;
       caloriesBurned = getCaloriesBurned(activityLevel, caloriesBurned);
       return caloriesBurned;
   }  // End of activityLevel

    private static int getCaloriesBurned(int activityLevel, int caloriesBurned)
    {
        if (activityLevel == 1) {
            caloriesBurned = 0;
            System.out.println("-- Estimated active caloric burn = " + caloriesBurned + " --");
        } else if (activityLevel == 2) {
            caloriesBurned = 250;
            System.out.println("-- Estimated active caloric burn = " + caloriesBurned + " --");
        } else if (activityLevel == 3) {
            caloriesBurned = 500;
            System.out.println("-- Estimated active caloric burn = " + caloriesBurned + " --");
        } else if (activityLevel == 4) {
            caloriesBurned = 750;
            System.out.println("-- Estimated active caloric burn = " + caloriesBurned + " --");
        }
        return caloriesBurned;
    }

    // This method will prompt the user for input for Day 1
   public static int dayOneTotalCalories()
   {
      System.out.println("\nInformation for day #1: ");
       int total1 = totalCaloricIntake();
       return total1;
   }  // End of dayOne

    private static int totalCaloricIntake() {
        Scanner kb = new Scanner(System.in);
        System.out.print("How many meals did you eat?   ");
        int day1 = kb.nextInt();
        int total1 = day1;
        if(day1 == 1)
        {
           System.out.println("How many calories were consumed in meal 1? ");
           int meal1Day1 = kb.nextInt();
            total1 = meal1Day1;
           System.out.println("-- Total caloric intake = " + total1 + " --");
        }
        else if(day1 == 2)
        {
           System.out.println("How many calories were consumed in meal 1? ");
           int meal1Day1 = kb.nextInt();
           System.out.println("How many calories were consumed in meal 2? ");
           int meal2Day1 = kb.nextInt();
            total1 = (meal1Day1 + meal2Day1);
           System.out.println("-- Total caloric intake = " + total1 + " --");
        }
        else if(day1 == 3)
        {
           System.out.println("How many calories were consumed in meal 1? ");
           int meal1Day1 = kb.nextInt();
           System.out.println("How many calories were consumed in meal 2? ");
           int meal2Day1 = kb.nextInt();
           System.out.println("How many calories were consumed in meal 3? ");
           int meal3Day1 = kb.nextInt();
            total1 = (meal1Day1 + meal2Day1 + meal3Day1);
           System.out.println("-- Total caloric intake = " + total1 + " --");
        }
        else if(day1 == 4)
        {
           System.out.println("How many calories were consumed in meal 1? ");
           int meal1Day1 = kb.nextInt();
           System.out.println("How many calories were consumed in meal 2? ");
           int meal2Day1 = kb.nextInt();
           System.out.println("How many calories were consumed in meal 3? ");
           int meal3Day1 = kb.nextInt();
           System.out.println("How many calories were consumed in meal 4? ");
           int meal4Day1 = kb.nextInt();
            total1 = (meal1Day1 + meal2Day1 + meal3Day1 + meal4Day1);
           System.out.println("-- Total caloric intake = " + total1 + " --");
        }
        else if(day1 == 5)
        {
           System.out.println("How many calories were consumed in meal 1? ");
           int meal1Day1 = kb.nextInt();
           System.out.println("How many calories were consumed in meal 2? ");
           int meal2Day1 = kb.nextInt();
           System.out.println("How many calories were consumed in meal 3? ");
           int meal3Day1 = kb.nextInt();
           System.out.println("How many calories were consumed in meal 4? ");
           int meal4Day1 = kb.nextInt();
           System.out.println("How many calories were consumed in meal 5? ");
           int meal5Day1 = kb.nextInt();
            total1 = (meal1Day1 + meal2Day1 + meal3Day1 + meal4Day1 + meal5Day1);
           System.out.println("-- Total caloric intake = " + total1 + " --");
        }
        return total1;
    }

    // This method will prompt the user for input for Day 2
   public static int dayTwoTotalCalories()
   {
      System.out.println("\nInformation for day #2: ");
      int total2 = totalCaloricIntake();
      return total2;
   }  // End of dayTwo
   
   // This method will figure out what day the user was closer to goal
   public static void findNetCalories()
   {
      int totalNetCalDayOne = dayOneTotalCalories() - usersActivityLevel();
      int totalNetCalDayTwo = dayTwoTotalCalories() - usersActivityLevel();
      
      System.out.println("\nDay 1 Net Calories = " + totalNetCalDayOne);
      System.out.println("Day 2 Net Calories = " + totalNetCalDayTwo);

      // Take the total and find the average double
       compareNetCalories(totalNetCalDayOne, totalNetCalDayTwo);
       double averageTotal = ((totalNetCalDayOne + totalNetCalDayTwo) / 2);
       System.out.printf("\nAverage Net Calories = %.1f",averageTotal);  // Making sure to round to ONE decimal place
   }

    private static void compareNetCalories(int totalNetCalDayOne, int totalNetCalDayTwo)
    {
        if(totalNetCalDayOne < totalNetCalDayTwo)
        {
           System.out.println("You were closer to your goal on Day 1**");
        }
        else if(totalNetCalDayTwo < totalNetCalDayOne)
        {
           System.out.print("You were closer to your goal on Day 2**");
        }
        else {
           System.out.print("Both Day 1 and Day 2 were equally close to your goal**");
        }
    }
}   // End of class