/*
DisplayBook
demonstrates FileInputStream
Ben Burger
10/10/2017
*/

import java.io.*;
import java.util.*;

public class DisplayBook
{
   public static void main(String[] args)
   {
      File file = new File("Title.txt");
      
      if(file.exists())
      {
         //file exists read file contense 
        getBook(file);
      }else
      {
         //file does not exist create file and 
         //populate via user input
         makeFile(file);
      }
      
   }
   
   //Gets title of favorite book from file and displays it
   public static void getBook(File file)
   {
      try
      {
         FileInputStream in = new FileInputStream(file);
      	
		   int place;
         while ((place = in.read()) != -1)
         {
            System.out.print((char)place);
         }
           
         in.close();
      }
      catch (IOException exc)
      {
         System.out.println("Oops!  Can't display file.");
      }
   }
   
   //Creates a file and adds user input title to it
   public static void makeFile(File file)
   {
      try
      {
         print("Please enter the title of your favorite book: ");
         Scanner sc = new Scanner(System.in);
         FileOutputStream out = new FileOutputStream(file);
         
         String input = sc.nextLine();
         int LEN = input.length();
         
         for(int i = 0; i<LEN ; ++i)
         {
            out.write(input.charAt(i));
         }
         
         out.close();
      }
      catch(Exception e)
      {
         print("Error: " + e);
      }

   }
   
   
   public static void print(String str)
   {
      System.out.println(str);
   }
   
   
   public static void print(int num)
   {
      System.out.print((char)num);
   }
}