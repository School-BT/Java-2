/*
Tic-Tac-Toe
the game tic-tac-toe
Ben Burger
10/16/2017
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.Random;


public class TicTacToe extends JFrame implements  ActionListener
{
   public final static int COUNT = 9;
   public int playerSelect = 0;
   public int clickCounter = 0;
   
   public final static String X = "X";
   public final static String O = "O";
   
   public int[] avalibleButtons= {0,0,0,0,0,0,0,0,0};
   
   public JButton[] buttons = new JButton[COUNT];
   public String[][] plays = new String[3][3];
   public GridLayout grid = new GridLayout(3,3,5,5);
   
   public TicTacToe()
   {
      buildArray();
      setUpPlays();
      setSize(200,200);
      setLayout(grid);
      populateGrid();
   }
   
   
   //adds button list to grid
   public void populateGrid()
   {
      for(int i = 0;i < COUNT; ++i)
      {
         add(buttons[i]);
      }
   }
   
   
   //builds button array
   public void buildArray()
   {
      for(int i = 0; i < COUNT ; ++i)
      {
         JButton b = new JButton();
         b.addActionListener(this);
         buttons[i] = b;
      }
   }
   
   
   //stub for actionListener action
   public int getButtonNumber(JButton b)
   {
      for(int i = 0; i < COUNT ; ++i)
      {
         if(b == buttons[i])
         {
            //this is what to do to the button
            //System.out.println("" + i);
            return i;
         }
      }
      return 0;
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      JButton b = (JButton)e.getSource();
      getButtonNumber(b);
      onClick(getButtonNumber(b));
   }
   
      
   public void onClick(int number)
   {
      buttons[number].setEnabled(false);
      
      
      if(playerSelect == 0)
      {
         buttons[number].setText(X);
         playerSelect = 1;
         remove(number);
         record(number,buttons[number].getText());
         checkingWins();
         if(clickCounter != 8)
            randomClick();
         clickCounter += 1;
      }else
      {
         buttons[number].setText(O);
         playerSelect = 0;
         remove(number);
         record(number,buttons[number].getText());
         checkingLoses();
         clickCounter += 1;
      }
   }
   
   
   public void setUpPlays()
   {
      for(int i = 0;i < 3; ++i)
      {
         for(int j = 0;j < 3; ++j)
         {
            plays[i][j] = " ";
         }
      }
   }
   
   
   public void record(int num, String letter)
   {
      switch(num)
      {
         case 0:
            plays[0][0] = letter;
            break;
         case 1:
            plays[0][1] = letter;
            break;
         case 2:
            plays[0][2] = letter;
            break;
         case 3:
            plays[1][0] = letter;
            break;
         case 4:
            plays[1][1] = letter;
            break;
         case 5:
            plays[1][2] = letter;
            break;
         case 6:
            plays[2][0] = letter;
            break;
         case 7:
            plays[2][1] = letter;
            break;
         default:
            plays[2][2] = letter;
            break;
      }
      
   }
   
   
   public void remove(int num)
   {
      avalibleButtons[num] = 1;      
   }
   
   
   public void randomClick()
   {
      int x = 0;
      
      for(int i = 0; i<COUNT ; ++i)
      {
         if(avalibleButtons[i] == 0)
         {
            x += 1;
         }
      }
      
      int[] temp = new int[x];
      int j = 0;
      
      for(int i = 0; i < COUNT ;++i)
      {
         if(avalibleButtons[i] == 0)
         {
            temp[j] = i;
            j += 1;
         }  
      }
      
      Random rand = new Random();
      int randomNum = rand.nextInt(x);
      
      int randButton = temp[randomNum];
      
      buttons[randButton].doClick();
   }
   
   
   public static void main(String[] args)
   {
      TicTacToe frame = new TicTacToe();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }


   public void checkingWins()
   {
      String[] win = {X,X,X};
      
      checkHor(win);
      checkVert(win);
      checkDiag(win);
   }
   
   public void checkingLoses()
   {
      String[] lose = {O,O,O};
      
      checkHor(lose);      
      checkVert(lose);
      checkDiag(lose);
   }
   
   
   //checks winLose verse Horizontals of plays array
   public void checkHor(String[] winLose)
   {
      for(int i = 0;i < 3; ++i)
      {         
         String[] yList = cutOutHor(i);
         
         if(yList[1] == winLose[1] && yList[2] == winLose[2] && yList[0] == winLose[0])
         {
            enableOff();
         }
      }
   }
   
   
   //checks winLose verse Verticals of plays array
   public void checkVert(String[] winLose)
   {
      for(int i = 0;i < 3; ++i)
      { 
         String[] yList = cutOutVert(i);
         
         if(yList[1] == winLose[1] && yList[2] == winLose[2] && yList[0] == winLose[0])
         {
            enableOff();
         }    
      }
   }
   
   
   //checks winLose verse diagonals of plays array
   public void checkDiag(String[] winLose)
   {
      for(int i = 0;i < 2; ++i)
      {
         String[] yList = cutOutDiag(i);
         
         if(yList[1] == winLose[1] && yList[2] == winLose[2] && yList[0] == winLose[0])
         {
            enableOff();
         } 
      }
   }
   
   
   
   //returns a Diagonal row of plays array
   public String[] cutOutDiag(int x)
   {
      String[] retMe = new String[3];
      if(x == 0)
      {
         for(int i = 0;i < 3;++i)
         {
            retMe[i] = plays[i][i];
         }
      }else
      {
         for(int i = 0;i < 3; ++i)
         {
            retMe[i] = plays[2-i][i];
         }
      }   
      return retMe;
   }

   
   //returns a Vertical row of plays array
   public String[] cutOutVert(int x)
   {
      String[] retMe = new String[3];
      
      for(int i = 0;i < 3;++i)
      {
         retMe[i] = plays[x][i];
      }
      
      return retMe;
   }
   
   
   //returns a horizontal row of plays array
   public String[] cutOutHor(int x)
   {
      String[] retMe = new String[3];
      
      for(int i = 0;i < 3;++i)
      {
         retMe[i] = plays[i][x];
      }
      
      return retMe;
   }
   
   
   //sets all buttons to unclickable with given values as text.
   public void enableOff()
   {
      for(int i = 0; i<9 ; ++i)
      {
         buttons[i].setEnabled(false);
      }
   }
}