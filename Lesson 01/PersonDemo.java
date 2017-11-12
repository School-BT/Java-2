/*
PersonDemo
demonstrates using Student and Person objects
Ben Burger
9/25/2017
*/

public class PersonDemo
{
   
   public static void main(String[] args)
   {
      Person person = new Person();
      person.setName("Ben Burger");
      person.setAge(23);
      
      Student student = new Student();
      student.setName("John Jinx");
      student.setAge(24);
      student.setId(123455);
      
      print("Person name: " + person.getName());
      print("Person age: " + person.getAge());
      print("");
      print("Student name: " + student.getName());
      print("Student age: " + student.getAge());
      print("Student Id: " + student.getId());
   }
   
   public static void print(String str)
   {
      System.out.println(str);
   }
   
}