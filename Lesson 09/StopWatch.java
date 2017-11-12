/*
StopWatch
This is a stopwatch applet
Ben Burger
10/30/2017

Elivator ding came from:
http://soundbible.com/1441-Elevator-Ding.html
*/

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.Timer;


public class StopWatch extends JApplet implements ActionListener
{   
   Timer timer=new Timer(1000, this);
   
   int onOff = 0;  
   
   //Has start and stop buttons
   JButton start = new JButton("Start");
   JButton stop = new JButton("Stop");
   
   int timeS = 0;
   
   JLabel time = new JLabel();
   
   JPanel pan = new JPanel(new FlowLayout());
   
   public void init()
   {
      super.init();
      start.addActionListener(this);
      stop.addActionListener(this);
      
      stop.setEnabled(false);
      
      pan.add(start);
      pan.add(stop);
      pan.add(time);
      time.setText(timeS + "s");
            
      getContentPane().add(pan);      
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource() == timer && onOff == 0)
      {
         timeS +=1;
         time.setText(timeS + "s");
      }else if(e.getSource() == timer)
      {
         //doNothing
      }
      else if((JButton)e.getSource() == start)
         startClock();
      else
         stopClock();
   }
   
   //Start button push begins counting (in seconds)
   public void startClock()
   {
      timer.start();
      
      start.setEnabled(false);
      stop.setEnabled(true);
   }
   
   
   //Stop button push ends counting and plays sound
   public void stopClock()
   {
      AudioClip ding = getAudioClip(getDocumentBase(), 
                                    "ElevatorDing.wav");
      onOff = 1;
      
      time.setText(timeS + "s");
      ding.play();
      stop.setEnabled(false);
   }
   
   
}