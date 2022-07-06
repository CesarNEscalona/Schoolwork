/*
   Cesar Escalona
   IT-219
   02/13/2020
   
   This program prints out the values stored in the
   variables id, courseName and courseGrade
*/

public class Student
{
   private int id;
   private String courseName;
   private double courseGrade;
      
   public Student(int id, String courseName, double courseGrade)
   {
      // complete this constructor method according to the logic
      this.id = id;
      this.courseName = courseName;
      this.courseGrade = courseGrade;
   }
   
   public String toString()
   {
      return "\nId: " + id + "\nCourse: " + courseName + "\nGrade: " + courseGrade ;
   }
}