/*
Person
holds name and age fields
Ben Burger
9/25/2017
*/

public class Person
{
   String name;
   int age;
   
   void setName(String str)
   {
      name = str;
   }
   
   void setAge(int num)
   {
      age = num;
   }
   
   String getName()
   {
      return name;
   }
   
   int getAge()
   {
      return age;
   }
}