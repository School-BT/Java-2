/*
StopWatch
This program runs two threads concurrently.
Ben Burger
11/3/2017
*/

import java.lang.*;

public class StopWatch extends Thread 
{

   public static void main(String[] args) 
   {
       StopWatch stopwatch = new StopWatch();
       stopwatch.run();
   }
        
   @Override
   public void run() 
   {
      System.out.println("Thread is running");
      Minute min = new Minute();
      Second sec = new Second();
      
      //starts minute thread.
      Thread thread = new Thread(min);
      thread.start();
      //starts second thread.
      Thread thread2 = new Thread(sec);
      thread2.start();
   }
}