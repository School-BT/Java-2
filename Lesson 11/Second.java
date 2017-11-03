/*
Second
This is a thread that waits for 1 second then prints a count to terminal
Ben Burger
11/3/2017
*/

import java.lang.*;


public class Second implements Runnable 
{
   public int s = 1; //number of seconds
   public static int count = 0; //number of runs... the seconds
   
	@Override
	public void run() 
   {
      mix();
      count +=1;
		System.out.println(count + "sec");
   }
   
   //The code to be run in run() method
	public void mix()
   {
      Thread thread = new Thread(new Second());
      try{
         Thread.sleep(s * 1000);
         thread.start();
      }catch(InterruptedException e)
      {
         e.printStackTrace();
      }
	}
   
}