/*
Ben Burger
JLuckySeven.java
This a java version of a street card game. basically you lose.
10/21/2017
*/


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.Graphics;

public class JLuckySeven extends JApplet implements ActionListener
{
   int suit = 4;//0 is back of card,1=diamond,2=heart,3=spade,4=club
   int[] hiden = new int[7];
   int clickCount = 0;
   int winCount = 0;
   int lossCount = 0;
   
   String start = "start";
   String OnlyOption = start;//Current card's face value... The next card's index.
   
   JButton[] buttons = new JButton[7];
   Card[] cards = new Card[7];
   
   JPanel pan = new JPanel(new GridLayout(3,1,2,2));
   JPanel cardField = new JPanel(new GridLayout(1,7,2,2));
   JPanel buttonField = new JPanel(new GridLayout(1,7,2,2));
   JPanel bottomField = new JPanel(new GridLayout(1,5,2,2));
   ExtraPan extra = new ExtraPan();
   
   JLabel wins = new JLabel("Wins : 0");
   JLabel loss = new JLabel("Losses : 0");
   JLabel ties = new JLabel("");
   JButton reset = new JButton("reset");
   JLabel blank1 = new JLabel("");
   JLabel blank2 = new JLabel("");
   
   
   public JLuckySeven()
   {
      randomize();
   }
   
   //JApplet "MAIN" method...
   public void init()
   {
      initiateCards();
      reset.addActionListener(this);
      popLabels(cards);   
      popButtons();
      popScore();
      getContentPane().add(pan);
   }
   
   
   //this is the "Shuffeling" of the seven cards
   public void randomize()
   {
      Random rand = new Random();
      
      for(int i = 0; i < 7; ++i)
      {
         int ran = rand.nextInt(7-i);
         while(hiden[ran] != 0)
         {
           ++ran;
            if(ran == 7)
               ran = 0;
         }
         hiden[ran] = i + 1;
      }
   }
   
   
   //populates the ScoreBoard portion of the game
   public void popScore()
   {
      bottomField.add(extra);
      bottomField.add(wins);
      bottomField.add(loss);
      bottomField.add(ties);
      bottomField.add(reset);
      pan.add(bottomField);
   }  
   
   
   
   //this is the lower lefthand corner drawString() method
   //with MEID, NAME,Course,and Section
   public class ExtraPan extends JPanel
   {
      int one;
      int two;
      int three;
      int four;
      
            
      @Override
      public void paintComponent(Graphics g)
      {
         int num = getHeight(); 
         one = num - 15;
         
         super.paintComponent(g);
         g.drawString("Ben Burger",10,one);
      }  
      
   }
   
   //initiates cardlist to face down... value of zero
   public void initiateCards()
   {
      for(int i = 0;i < 7; ++i)
      {
         cards[i] = new Card(0,0);
      }
   }
   
   
   //populates the cards.
   public void popLabels(Card[] cardList)
   {
      for(int i = 0;i < 7; ++i)
      {   
         Card c = new Card(cardList[i].getValue(),0);
         cardField.add(c);
         cards[i] = c;
      }
      pan.add(cardField);
   }
   
   
   //populates the seven buttons
   public void popButtons()
   {
      for(int i = 0;i < 7; ++i)
      {
         int x = i + 1;
         JButton b = new JButton("" + x);
         b.addActionListener(this);
         buttonField.add(b);
         buttons[i] = b;
      }
      pan.add(buttonField);
   }
   
   
   //this is the update method keeping track of wins and losses
   public void updateScoreBoard()
   {
      wins.setText("Wins : " + winCount);
      loss.setText("Losses : " + lossCount);
   }
   
   //button onClick action.
   public void actionPerformed(ActionEvent e)
   {
      JButton b = (JButton)e.getSource();
      String string = b.getText();
      
      //allows the OnlyOption var to be initialized by user
      if(OnlyOption == start && b != reset)
      {
         OnlyOption = string;
      }
      
      //this is the card game's rule of fliping the card at the
      //index of the face value of the chosen card
      if(string.equals(OnlyOption))
      {
         logic(b);
      }else if(b == reset)
      {
         resetMethod();
      }
   }
   
   //this Lets the user know if they won or lost or tied, there are no ties
   //this also keeps track of the wins, losses and ties, again, no ties
   public void think(JButton b,int num)
   {
      if(num == 0 && clickCount != 7)
      {
         b.setText("You Lose");
         lossCount += 1;
      }else if(num == 0)
      {
         winCount += 1;
         b.setText("You Won");
      }
   }
   
   //this is what happens when you pick the right next card.
   public void logic(JButton b)
   {
      clickCount += 1;
      b.setEnabled(false);
      String in = b.getText();
      int num = Integer.parseInt(in)-1;
      
      OnlyOption = "" + hiden[num];
      cards[num].setNum(hiden[num]);
      cards[num].setSuit(suit);
      
      cards[num].repaint();
      
      hiden[num] = 0;
      think(b,hiden[Integer.parseInt(OnlyOption) - 1]);
   }
   
   
   //Resets the game to play again, keeping the Win Loss Tie count
   public void resetMethod()
   {
      for(int i = 0;i < 7;++i)
      {
         int x = i + 1;
         buttons[i].setText("" + x);
         buttons[i].setEnabled(true);
         cards[i].setNum(0);
         cards[i].repaint();
      }
      clickCount = 0;
      hiden = new int[7];
      OnlyOption = start;
      updateScoreBoard();
      randomize();
   }
}