import java.util.*;
import java.io.*;

public class CalculatorDemo
{
   public static void main(String[] args) throws IOException
   {
      Scanner input = new Scanner(System.in);
      Process proc = Runtime.getRuntime().exec
         ("cmd /c C:\\Windows\\System32\\calc.exe");
      double num1 = 279.6;
      double num2 = 872.8;
      double answer = num1 + num2;
      double userAnswer;
      
      System.out.print("What is the sum of " + num1 +
         " and " + num2 + "? >> ");
      userAnswer = input.nextDouble();
      if(userAnswer == answer)
         System.out.println("Correct!");
      else
         System.out.println("Sorry Wrong" + answer);
   }
}