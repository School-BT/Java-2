/*
FileStatistics2
Compares sizes and ratios of two files
Ben Burger
10/10/2017
*/

import java.io.*;

public class FileStatistics2
{
   public static long docSize;
   public static long txtSize;
   
   public static String docName;
   public static String txtName;
   
   public static double ratio;
      
   public static void main(String[] args)
   {
      setRat();
      
      printData();
   }
   
   public static void setRat()
   {  
   
      setDoc();
      setTxt();
      
      ratio = docSize / txtSize;
   }
   
   public static void setDoc()
   {
      File docFile = new File("Quote.doc");
      
      docName = docFile.getName();
      
      docSize = docFile.length();
   }
   
   public static void setTxt()
   {
      File txtFile = new File("Quote.txt");
      
      txtName = txtFile.getName();
      
      txtSize = txtFile.length();
   }
   
   public static void printData()
   {
      print(docName + " size is " + docSize + " B.");
      print(txtName + " size is " + txtSize + " B.");
      print("The ratio of \n" + docName + " to " + txtName);
      print(" is " + ratio + "B to 1B.");
      
   }
   
   public static void print(String str)
   {
      System.out.println(str);
   }
}