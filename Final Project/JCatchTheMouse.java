/*
Ben Burger
JCatchTheMouse.java
Simple Game of clicking an x.
10/21/2017
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class JCatchTheMouse extends JFrame implements ActionListener
{
   public final int NUM = 48;
   public final int WIN_NUM = 10;
   
   public static double percent = 0.0;
   public final String X = "X";
      
   public String win_msg = "";
   
   public JButton[] buttonArr = new JButton[NUM];
   
   public static double hitCounter = 0;
   public static double clickCounter = 0;
   
   //gridlayout eight x six 
   public GridLayout grid = new GridLayout(8,6);
   
   public JCatchTheMouse()
   {
      setSize(400,400);
      setLayout(grid);
      populateButtons();
      randomX();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   
   //************MAIN************
   public static void main(String[] args)
   {
      JCatchTheMouse frame = new JCatchTheMouse();
      frame.setVisible(true);
   }
   //**********END MAIN**********
   
   
   //48Jbuttons
   public void populateButtons()
   {
      for(int i = 0;i < NUM; ++i)
      {
         JButton b = new JButton();
         buttonArr[i] = b;
         b.addActionListener(this);
         add(b);
      }
   }
   
   //display an x randomly on one button
   public void randomX()
   {
      Random random = new Random();
      int rand = random.nextInt(NUM);
      
      setAllNull();
      setX(rand);
   }
   
   //put the letter x on the num button
   public void setX(int num)
   {
      buttonArr[num].setText(X);
   }
   
   //sets all button text to ""
   public void setAllNull()
   {
      for(int i = 0;i < NUM;++i)
      {
         buttonArr[i].setText("");
      }
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      JButton b = (JButton)e.getSource();
      
      clickCounter += 1;
      
      if(b.getText() == X)
      {
         randomX();
         hitCounter +=1;
      }
      
      checkWin();
      randomX();
   }
   
   
   
   //10 hits you get a congrats mssg + user percentage
   public void checkWin()
   {
      if(WIN_NUM == hitCounter)
      {
         percentage();
         winMsg();
      }
   }
   
   
   //Calculates the percentage
   public void percentage()
   {
      percent = hitCounter / clickCounter * 100;
   }
   
   
   //display your name, course, section number,MEID by using a
   //JOptionPane message dialog box
   public void winMsg()
   {
      enabledOff();
      percentage();
      buildWinMsg();
      JFrame frame = new JFrame("WIN DIALOG BOX");
      JOptionPane.showMessageDialog(frame,win_msg);
   }
   
   
   //this rounds the percentage and casts it to an int
   //also creates the win_msg 
   public void buildWinMsg()
   {
      round();
      int perc = (int)percent;
      win_msg = "Congragulations! \n" +
         "You won with a " + perc + "%" +
         "\n************************\n" +
         "Credit Goes To \n" +
         "Ben Burger\n";
   }
   
   
   //sets all buttons to unclickable with given values as text.
   public void enabledOff()
   {
      setAllNull();
      for(int i = 0; i<NUM ; ++i)
      {
         buttonArr[i].setEnabled(false);
      }
   }
   
   
   //rounds the percent up or down.
   public void round()
   {
      String hold = percent + "00000";
      
      int endingPlace = hold.indexOf(".") + 2;
      
      //get last to see if it needs rounded up
      String upOrDown = hold.substring(endingPlace - 1,endingPlace);
      int upDown = Integer.parseInt(upOrDown);
      
      //get the rounded number
      String rounded = hold.substring(0,endingPlace - 2);
      percent = Double.parseDouble(rounded);
      
      //this is the actual rounding
      if(upDown >4)
         percent += 1;
      else
         ;//do nothing
   }
   
}