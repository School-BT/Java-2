/*
Call
builds an array
Ben Burger
9/30/2017
*/

import java.util.*;

public class Call
{
   public static Phone[] phones = buildPhone();
   public static Person[] people = build();
   
   public static String phoneSelected;
   public static String numberSelected;
   
   public static void main(String[] args)
   {
      askForPhone();
      askForPerson();
      handlePhone(phoneSelected,handleNumber(numberSelected));
   }
   
   public static Person handleNumber(String input)
   {
      Person passed;
      switch(input)
      {
         case "1":
            passed = people[0];
            break;
         case "2":
            passed = people[1];
            break;
         case "3":
            passed = people[2];
            break;
         default:   
            passed = people[3];
            break;
      }
      
      return passed;
   }
   
   public static void handlePhone(String input,Person person)
   {
      iPhone iphone = new iPhone();
      Samsung samsung = new Samsung();
      
      switch(input)
      {
         case "1":
            iphone.call(person);
            break;
         case "2":
            samsung.call(person);
            break;
      }
   }
   
   public static Person askForPerson()
   {
      Scanner sc = new Scanner(System.in);
      
      print("Who would you like to contact?");
      print(people);
      
      numberSelected = sc.next();
      
      return people[Integer.parseInt(numberSelected)];
   }
   
   public static void askForPhone()
   {
      Scanner sc = new Scanner(System.in);
      
      print("What phone do you want to use?");
      print("Samsung (1) iPhone (2)");
      phoneSelected = sc.next();
   }
   
   //builds array of Phone Objects Samsung and iPhone
   public static Phone[] buildPhone()
   {
      Phone[] phonesList = new Phone[2];
      
      phonesList[0] = new Samsung();
      phonesList[1] = new iPhone();
      
      return phonesList;
   }
   
   
   //builds array of Person objects with given data
   public static Person[] build()
   {
      Person[] people = new Person[4];
      
      people[0] = new Person("Joe", "555-1234");
      people[1] = new Person("Bob", "555-4444");
      people[2] = new Person("Alice", "555-6565");
      people[3] = new Person("Sally","555-1111");
      
      return people;
   }
   
   public static void print(Person[] ppl)
   {
      int LEN = ppl.length;
      for(int i = 0;i<LEN;++i)
      {
         int j = i + 1;
         printl(ppl[i].getName() + " ");
         printl(ppl[i].getNumber());
         print( " (" + j + ")");
      }
   }
   
   public static void printl(String str)
   {
      System.out.print(str);
   }
   
   public static void print(String str)
   {
      System.out.println(str);
   }
   
}