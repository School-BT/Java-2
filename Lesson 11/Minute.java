/*
Minute
This is a thread that waits for 1 minute then prints a count to terminal
Ben Burger
11/3/2017
*/

import java.lang.*;


public class Minute implements Runnable 
{
   public int s = 60; //number of seconds
   public static int count = 0; //number of runs... the minuite
   
	@Override
	public void run() 
   {
      mix();
      count +=1;
		System.out.print(count + "min");
   }
   
   //The code to be run in run() method
	public void mix()
   {
      Thread thread = new Thread(new Minute());
      try{
         Thread.sleep(s * 1000);
         thread.start();
      }catch(InterruptedException e)
      {
         e.printStackTrace();
      }
	}
     
}