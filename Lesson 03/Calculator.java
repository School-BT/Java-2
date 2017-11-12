/*
Calculator
divides two integers
Ben Burger
10/9/2017
*/

import java.util.*;

public class Calculator
{
   static int numerator;
   static int denominator;
   
   
   public static void main(String[] args) 
   {
      getNums();
   }
   
   //accepts two Integers from user
   public static void getNums()
   {
      try
      {
         Scanner sc = new Scanner(System.in);
         print("Please enter a numerator.");
         numerator = sc.nextInt();
         print("Please enter a denominator.");
         denominator = sc.nextInt();
         tryCatch();
      }
      catch(Exception e)
      {
         print("You must input integers");
      }
   }
   
   
   //if the denominator is zero pass through ZeroInputError
   public static void tryCatch()
   {
      double output;
      try
      {
         output = numerator / denominator;
         output = (double)numerator / denominator;
         print("" + output);
      }
      catch(Exception e)
      {
         ZeroInputError zed = new ZeroInputError();
         print(zed.getMessage());
      }
   }
   
   
   
   public static void print(String str)
   {
      System.out.println(str);
   }
}