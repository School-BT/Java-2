/*
AnimalDemo
Demonstrate Animal,Bear,and Shark objects and fields.
Ben Burger
9/25/2017
*/

public class AnimalDemo
{
   public static void main(String[] args)
   {
      Animal animal = new Animal();
      animal.setName("animalName");
      animal.setAge(234);
      animal.setSize(23.33);
      animal.setFood("pizza");
      
      Bear bear = new Bear();
      bear.setName("bearName");
      bear.setAge(6);
      bear.setSize(6.4);
      bear.setFood("garbage");
      bear.setIsHibernating("Snozing");
      
      Shark shark = new Shark();
      shark.setName("sharkName");
      shark.setAge(62);
      shark.setSize(12.4);
      shark.setFood("Seal");
      shark.setIsInWater("Swiming");
      
      
      print("Animal Name: " + animal.getName());
      print("Animal Age: " + animal.getAge());
      print("Animal Size: " + animal.getSize());
      print("Animal Food: " + animal.getFood());
      print("");
      print("Bear Name: " + bear.getName());
      print("Bear Age: " + bear.getAge());
      print("Bear Size: " + bear.getSize());
      print("Bear Food: " + bear.getFood());
      print("Bear Hibernating: " + bear.getIsHibernating());
      print("");
      print("Shark Name: " + shark.getName());
      print("Shark Age: " + shark.getAge());
      print("Shark Size: " + shark.getSize());
      print("Shark Food: " + shark.getFood());
      print("Shark In Water: " + shark.getIsInWater());
      
      
   }
   
   public static void print(String str)
   {
      System.out.println(str);
   }
}