/*
ThreadWaiterTwo
This is a thread that waits for 5 seconds
Ben Burger
11/3/2017
*/


import java.lang.*;
import java.util.*;

public class ThreadWaiterTwo implements Runnable 
{
   public static int s = 5; //number of seconds
   
   
	@Override
	public void run() 
   {
      mix();
		System.out.println("Thread Waiter Two is done.");
   }


   //The code to be run in run() method
	public void mix()
   {
      Thread thread = new Thread(new ThreadWaiterTwo());
      
      try
      {      
         //this is the Delay Code.
         Thread.sleep(s * 1000);
         
      }catch(InterruptedException e)
      {
         e.printStackTrace();
      }
      
      thread.interrupt();
	}
  

}