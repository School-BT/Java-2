/*
Blackjack
lets play blackjack
Ben Burger
10/28/2017
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Blackjack extends JFrame implements ActionListener
{
   Card[] compCards = new Card[8];
   Card[] userCards = new Card[8];
   
   final int END_SCORE = 21;
   int[] indexes = new int[52];
   
   String WinLose = "";
   
   public static int W = 1000;
   public static int H = 650;
   
   int userScore;
   int compScore;
   JButton hitButton = new JButton("Hit");
   JButton stayButton = new JButton("Stay");
   JButton resetButton = new JButton("Reset");
   
   Card[] deck = new Card[52];
   
   
   
   public Blackjack()
   {    
      kickOff();
      CardTable ct = new CardTable(userCards);
      CardTable ct2 = new CardTable(compCards);
      ScoreBoard sb = new ScoreBoard();
      JPanel bf = new JPanel(new GridLayout(1,3,2,2)); 
            
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new GridLayout(4,1,0,0));
      setBackground(Color.BLACK);
      
      bf.add(resetButton);
      bf.add(hitButton);
      bf.add(stayButton);
      
      hitButton.addActionListener(this);
      stayButton.addActionListener(this);
      resetButton.addActionListener(this);
      
      add(ct);
      add(sb);
      add(ct2); 
      add(bf);
   }
   
   public void kickOff()
   {
      buildIndexes();
      stubCards();
      buildDeck();
      buildCards(userCards);
      calculate(userCards);
   }
   
   
   //makes a list of indexes that have not been used
   public void buildIndexes()
   {
      indexes = new int[52];
      for(int i = 0;i < 52;++i)
      {
         indexes[i] = i;
      }
   }
   
   
   //builds 52 card deck 4 sets of 13
   public void buildDeck()
   {
      int t = -1;
      
      for(int i = 0; i < 52; ++i)
      {
         int x = i%13;
         if(x == 0)
            t += 1;
         
         Card c = new Card(x+1,t);
         
         deck[i] = c;
      }
   }
   
   
   //makes zeroed cards to null some index issues
   public void stubCards()
   {
      for(int i = 0;i<8;++i)
      {
         Card c = new Card(0,0);
         compCards[i] = c;
         userCards[i] = c;
      }
   }
   
   
   
   //first two cards Randomized
   public void buildCards(Card[] cards)
   {
      for(int i = 0;i < 2; ++i)
      {
         cards[i] = randomDraw();
      }
   }
   
   
   
   //totals all values of a card array
   public void calculate(Card[] cards)
   {
      int total = 0;
      
      for(int i = 0; i < 8; ++i)
      {
         total += cards[i].getValue();
      }
      
      if(cards == userCards)
         userScore = total;
      else
         compScore = total;
   }
   
   
   
   public static void main(String[] args)
   {
      Blackjack frame = new Blackjack();
      frame.setSize(W,H);
      frame.setVisible(true);
   }
   
   
   //Gets a random card from the deck array
   public Card randomDraw()
   {
      int LEN = indexes.length;
      Random rand = new Random();
      int randNum = rand.nextInt(LEN);
      int index = indexes[randNum];
      removeIndex(index);
      
      Card c = deck[index];
      
      return c;
   }
   
   
   
   //adds one card to an open spot in the cards array
   public void addCard(Card[] cards)
   {
      for(int i = 0; i < 8;++i)
      {
         if(cards[i].getValue() == 0)
         {
            cards[i] = randomDraw();
            break;
         }
      }
   }
   
   
   //removes a deck index from the indexes array
   public void removeIndex(int num)
   {
       int LEN = indexes.length;
       int[] tempIndex = new int[LEN];
       
       //copy indexes
       for(int i = 0;i < LEN; ++i)
       {
           int inNum = indexes[i];
           tempIndex[i] = inNum;
       }
       
       //remove info from indexes
       indexes = new int[LEN - 1];
       
       remHelp(num,LEN,tempIndex);
       
   }
   
   
   //helps remove integers from the avalible cards index list.
   public void remHelp(int num, int LEN, int[] tempIndex)
   {
       int x = 0;
       
       LEN -= 1;
       
       //add not the selected number&#39;s index to indexes.
       for(int i = 0; i < LEN; ++i)
       {
           int inNum = tempIndex[i];
           
           if(num != inNum)
           {
               indexes[x] = inNum;
               x+=1;
           }
           
       }
   }
   
   
   
   
   public void actionPerformed(ActionEvent e)
   {
      JButton b = (JButton)e.getSource();
      if(b == stayButton)
      {
         stayButtonMethod();
      }else if(b == hitButton)
      {
         hitButtonMethod();
      }else
      {  
         resetButtonMethod();
      }
   }
   
   //functions of the stayButton
   public void stayButtonMethod()
   {
      while(compScore < END_SCORE)
      {
         addCard(compCards);
         calculate(compCards);
         repaint();
      }
      
      if(compScore > END_SCORE)
      {
         WinLose = "YOU WIN!";
      }else if(compScore < END_SCORE && compScore < userScore)
      {
         WinLose = "YOU WIN!";
      }else
      {
         WinLose = "You LOSE!";
      }
      repaint();
      
      hitButton.setEnabled(false);
      stayButton.setEnabled(false);
   }
   
   //functions of the hitButton
   public void hitButtonMethod()
   {
      addCard(userCards);
      calculate(userCards);
      repaint();
      if(userScore > END_SCORE)
      {
         hitButton.setEnabled(false);
         stayButton.setEnabled(false);
         WinLose = "BUST! You LOSE!";
      }
   }
   
   //functions of the resetButton
   public void resetButtonMethod()
   {
      buildIndexes();
      buildDeck();
      stubCards();
      buildCards(userCards);
      calculate(userCards);
      compScore = 0;
      WinLose = "";
      repaint();
      hitButton.setEnabled(true);
      stayButton.setEnabled(true);
   }
   
   //This is a JPanel set up to host the scores.
   public class ScoreBoard extends JPanel
   {

      public void setScore(int score1,int score2)
      {
         userScore = score1;
         compScore = score2;
      }
   
   
      @Override
      public void paintComponent(Graphics g)
      {
         super.paintComponent(g);
         g.setFont(new Font("Arial",Font.PLAIN,30));
         g.drawString("User:" + userScore,10,50);
         g.drawString("\nComp:" + compScore,10,100);
         g.drawString(WinLose,250,75);
      }  
      
   }
  
}  