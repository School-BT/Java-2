/*
ThreadWaiterOne
This is a thread that waits for 20 seconds
Ben Burger
11/3/2017
*/

import java.lang.*;


public class ThreadWaiterOne implements Runnable 
{
   public int s = 20; //number of seconds
   
	@Override
	public void run() 
   {
      mix();
		System.out.println("Thread Waiter One is done.");  
   }
   
   
   //The code to be run in run() method
	public void mix()
   {
      Thread thread = new Thread(new ThreadWaiterOne());
      try{
         Thread.sleep(s * 1000);
      }catch(InterruptedException e)
      {
         e.printStackTrace();
      }
      thread.interrupt();
	}
}