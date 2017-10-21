/*
TestPerson
tests the Person class
Ben Burger
9/28/2017
*/

public class TestPerson
{
   
   public static void main(String[] args)
   {
      loop(buildArr());
   }
   
   
   //Iterates through Person[] calling the toString() method
   public static void loop(Person[] people)
   {
      int LEN = people.length;
      for(int i = 0;i<LEN;++i)
      {
         print(people[i].toString());
      }
   }
   
   
   //builds array of Person Objects
   public static Person[] buildArr()
   {
      Person[] people = new Person[5];
      
      people[0] = new Person("One","1");
      people[1] = new Person("Two","22");
      people[2] = new Person("Three","333");
      people[3] = new Person("Four","4444");
      people[4] = new Person("Five","55555");
      
      return people;
   }  
   
   
   
   public static void print(String str)
   {
      System.out.println(str);
   }
}