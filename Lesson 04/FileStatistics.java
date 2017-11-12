/*
FileStatistics
This is a demonstration of the File class
Ben Burger
10/10/2017
*/

import java.io.*;

public class FileStatistics
{
   public static String name;
   public static long size;
   public static long lastModTime;
   
   public static void main(String[] args)
   {
      File myFile = new File("exerciseOneFile.txt");
      
      printData(myFile);
   }
   
   
   public static void printData(File fileName)
   {
      if(fileName.exists())
      {
         setData(fileName);
         print("Name: " + name);
         print("Size: " + size + " B");
         print("Last Time Modified: " + lastModTime +
               " ms");
      }  
      else
      {
         print("File does not exist");
      }
   }
   
   
   public static void setData(File file)
   {
      name = file.getName();
      size = file.length();
      lastModTime = file.lastModified();
   }
   
   
   public static void print(String str)
   {
      System.out.println(str);
   }
   
}