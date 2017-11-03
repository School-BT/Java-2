/*
ThreadTeaster
This runs two threads at the same time
Ben Burger
11/3/2017
*/

import java.lang.*;

public class ThreadTester extends Thread 
{

   public static void main(String[] args) 
   {
       ThreadTester tester = new ThreadTester();
       tester.run();
   }
        
        
        
   @Override
   public void run() 
   {
      System.out.println("Thread is running");
      ThreadWaiterOne one = new ThreadWaiterOne();
      ThreadWaiterTwo two = new ThreadWaiterTwo();
      
      Thread thread = new Thread(one);
      thread.start();
      
      Thread thread2 = new Thread(two);
      thread2.start();
   }
}