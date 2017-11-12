/*
Student
extends Person class with a studentId
Ben Burger
9/25/2017
*/

public class Student extends Person
{
   int studentId;
   
   void setId(int num)
   {
      studentId = num;
   }
   
   int getId()
   {
      return studentId;
   }
}