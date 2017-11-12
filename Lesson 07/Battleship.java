/*
Battleship
lets play battleship... well sort of
Ben Burger
10/12/2017
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.awt.Color;


public class Battleship extends JFrame implements ActionListener
{
   public int row = 6;
   public int col = 6;
   public int num = row * col;
   public int hitCounter = 0;
   
   public static Battleship frame = new Battleship();
   public String hit = "1";
   public String miss = "0";
   
   public JButton[] buttons = new JButton[num];
   public String[] hitList = new String[num];
      
   public GridLayout grid = new GridLayout(row,col);
   
   
   public Battleship()
   {
      setSize(400,400);
      setLayout(grid);
      buildHitList();
      buildBoard();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   
   
   //randomizes ship creation and populates hitList
   public void buildHitList()
   {
      Random rand = new Random();
      int randNum = rand.nextInt(row);
      int select = rand.nextInt(2);
      
      initializeHitList();
      
      //sets ones in indexes of randomly selected colums
      if(select == 0)
      {
         buildHor(randNum);
      }else //sets ones in indexes of randomly selected rows
      {  
         buildVert(randNum);
      }     
   }
   
   
   
   //makes a vertical ship based on an int
   public void buildVert(int randNum)
   {
      randNum = startList(randNum);
         
      for(int i = 0;i < 6;++i)
      {
         hitList[randNum] = hit;
         randNum += 1;
      }
   }
   
   
   
   //makes a horizontal ship based on an int
   public void buildHor(int randNum)
   {
      for(int i = 0;i < 6;++i)
      {
         hitList[randNum] = hit;
         randNum += 6;
      }
   }
   
   
   
   //initializes field with all zeros
   public void initializeHitList()
   {
      for(int i = 0;i < num;++i)
      {
         hitList[i] = miss;
      }
   }
   
   
   
   //sets the starting point of a row.
   public int startList(int row)
   {
      switch(row)
      {
         case 1:
            return 0;
         case 2:
            return 6;
         case 3:
            return 12;
         case 4:
            return 18;
         case 5:
            return 24;
         default:
            return 30;
      }
   }
   
   
   
   //populates board with blank buttons
   public void buildBoard()
   {
      for(int i = 0;i<num;++i)
      {
         JButton b = new JButton();
         buttons[i] = b;
         b.addActionListener(this);
         add(b);
      }
   }
   
   
   
   //************ MAIN ***********
   public static void main(String[] args)
   {  
      frame.setVisible(true);
   }
   //**********END MAIN***********
   
   
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      JButton b = (JButton)e.getSource();
            
      b.setText(hitList[buttonSelect(b)]);
      b.setEnabled(false);
      
      hitCheck(b);
      
      checkEnd();
   }
   
   
   
   //checks for end of game.
   public void checkEnd()
   {
      if(hitCounter == 6)
      {
         System.out.println("You Sunk the Battle Ship!!");
         enabledOff();
      }
   }
   
   
   
   //gets index of button
   public int buttonSelect(JButton b)
   {
      int LEN = buttons.length;
      
      for(int i = 0; i < LEN ; ++i)
      {
         if(buttons[i] == b)
         {
            return i;
         }
      }
      return 0;
   }
   
   
   //checks if the button is a hit or not
   public void hitCheck(JButton b)
   {
      int LEN = buttons.length;
         
      for(int i = 0; i < LEN ; ++i)
      {
         if(buttons[i] == b)
         {
            if(b.getText() == hit)
            {
               hitCounter += 1;
               System.out.println("HIT!!");
            }
         }
      }
   }
   
   
   
   //sets all buttons to unclickable with given values as text.
   public void enabledOff()
   {
      for(int i = 0; i<num ; ++i)
      {
         buttons[i].setEnabled(false);
      }
   }
   
}