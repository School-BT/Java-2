/*
Person
class holdin name and number fields
Ben Burger
9/28/2017
*/

public class Person
{
   public String name;
   public String number;
   
   public Person(String inName,String inNum)
   {
      name = inName;
      number = inNum;
   }
   
   public String getName()
   {
      return name;
   }
   
   public String getNumber()
   {
      return number;
   }
   
   @Override
   public String toString()
   {
      return name + " " + number;
   }
   
   public void print(String str)
   {
      System.out.println(str);
   }
}