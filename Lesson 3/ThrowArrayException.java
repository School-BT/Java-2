/*
ThrowArrayException
learning exception handleing
Ben Burger
10/9/2017
*/

import java.util.*;


public class ThrowArrayException
{
   //Array of ten names
   public static String[] names = {"John","Joe","Bill","Will",
                                   "Ben","Nick","Kim","Cindy",
                                   "Jim","Nicky"};
   
   
   public static void main(String[] args)
   {  
      prompt();
   }
   
  
   
   //Prompts user for index.
   public static void prompt()
   {
      int output = 0;
      Scanner sc = new Scanner(System.in);
      
      print("Please select the index of the name you would");
      print("like to print.");
      
      get();
   }
   
   
  
   
   //Prints name of item in selected index.
   public static void get()
   {
      Scanner sc = new Scanner(System.in);
      //try block
      try
      {
          int num = sc.nextInt();
          print(names[num]);
      }
      //catch block for ArrayOutOfBounds
      catch(ArrayIndexOutOfBoundsException e)
      {
         print("Your input number exceeds array size.");
      }
      //catch block for InputMismatch
      catch(InputMismatchException e)
      {
         print("You must use an Integer");
      }
   }
   
   
   public static void print(String str)
   {
      System.out.println(str);
   }  
   
   
}