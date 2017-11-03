/*
Server
Basic server to display trip prices
Ben Burger
10/31/2017
*/

import java.net.*;
import java.util.*;
import java.io.*;

public class Server
{
   private ServerSocket server;
   public int price;
   public Socket clientSocket = null;
         
      
   public Server() {
      try 
      {
		   this.server = new ServerSocket(1234, 0, InetAddress.getByName("localhost"));
	   }catch(IOException e)
      {
	      e.printStackTrace();
		}
   }

   public void run() 
   {
      System.out.println("Server Started");
      while(true) 
      {
		   try
         {
            String inputLine;
            clientSocket = server.accept();
                     
            // ins and outs streams
		      BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				
            //this is input from the client 
            inputLine = in.readLine();
            
            //this gets cost from state name
            recieved(inputLine);
                     
		      System.out.println("State Selected is " + inputLine + ".");
	         out.println("A trip to " + inputLine + " will cost $" + price + ".");
            
         }catch(IOException ex) 
         {
           System.out.println(ex.getMessage());
         }finally
         {
           closeAll(clientSocket);
         }
      }//ends While loop
   }//ends Run method
      
      
   //closes socket
   public void closeAll(Socket clientSocket)
   {
       try 
       {
          clientSocket.close();
       }catch(IOException e) 
       {
		    e.printStackTrace();
       }
   }
   
   
   //this sets price when given a state.
   public void recieved(String str)
   {
      switch(str)
      {
         case "Arizona":
            price = 500;
            break;
         case "New York":
            price = 600;
            break;
         case "Utah":
            price = 300;
            break;
         default:
            break;
      }
   }
      

	public static void main(String[] args) throws IOException 
   {
	   Server thisServer = new Server();
		thisServer.run();
	}
   
}