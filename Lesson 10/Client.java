/*
Client
Basic Client to demonstrate Server/Client Codeing
Ben Burger
10/31/2017
*/

import java.net.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Client extends JFrame implements ActionListener{

   DataOutputStream dOutStream = null;
   DataInputStream dInputStream = null;

   public static Client client;
   public static String sendMe;
   public static int selector = 0;

   JButton btn = new JButton("Utah");
   JButton btn2 = new JButton("New York");
   JButton btn3 = new JButton("Arizona");

   JLabel output = new JLabel();
      
   public Client()
   {      
      setLayout(new GridLayout(4,1,2,2));
      buildGui();
      setSize(300,200);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   
   
   //builds gui for client
   public void buildGui()
   {
      btn.addActionListener(this);
      btn2.addActionListener(this);
      btn3.addActionListener(this);
      
      add(btn);
      add(btn2);
      add(btn3);
      
      add(output);
   }

   public void run() throws IOException 
   {
      //Open a socket through port 1234
      Socket clientSocket = new Socket(InetAddress.getByName("localhost"), 1234);
      
      //sets input and output streams
      dOutStream = new DataOutputStream(clientSocket.getOutputStream());
      BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      
      //the actual sending to server
      dOutStream.writeBytes(sendMe);
      
      //this is the code to recieve from the server
      String response = input.readLine();
      output.setText("   " + response);
      
      //close the socket when done with server
      clientSocket.close();
   }
   
   
   public static void main(String[] args) 
   {
      client = new Client();
   }

   
   
   public void actionPerformed(ActionEvent e)
   {
      JButton b = (JButton)e.getSource();
      
      if(b == btn)
         sendStuff("Utah\n");
      else if(b == btn2)
         sendStuff("New York\n");
      else
         sendStuff("Arizona\n");
   }
   
   
   //this runs client.run() after setting the sendMe val
   public void sendStuff(String str)
   {
      sendMe = str;
      
      try
      {
         client.run();
      }catch(IOException ex)
      {
         ex.printStackTrace();
      }
   }
}