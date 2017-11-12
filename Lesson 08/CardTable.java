/*
CardTable
this is a JPanel that allows 8 cards to be spaced neatly
Ben Burger
10/28/2017
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CardTable extends JPanel
{  
   Card[] userCards = new Card[8];
   
   int[][] XPLACE = new int[8][3];
   
   int userScore = 5;
   int compScore = 2;
   int offset = 20;
   
   int topx = 1;
   int midx = 50;
   int botx = 100;
   
   int topy = 11;
   int midy = 75;
   int boty = 150;
   
   public CardTable(Card[] cards)
   {
      buildXPlace();
      userCards = cards;
   }

   
   public void buildXPlace()
   {
      XPLACE[0][0] = 1;
      XPLACE[0][1] = 50;
      XPLACE[0][2] = 100;
      
      for(int i = 1; i < 8; ++i)
      {
         XPLACE[i][0] = XPLACE[i-1][0] + 100 + offset;
         XPLACE[i][1] = XPLACE[i-1][1] + 100 + offset;
         XPLACE[i][2] = XPLACE[i-1][2] + 100 + offset; 
      }
   }
   
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      paintCardField(g,userCards);
   }
   
   
   public void paintCardField(Graphics g, Card[] cards)
   {
      for(int i = 0; i < 8; ++i)
      {
         populateOne(g,i,cards[i],i);
      }
      
   }
   
   public void populateOne(Graphics g,int placement,Card card,int cardNum)
   {
      changePlacement(placement);
      //g.setColor(color);
      String string = card.getString();
      g.drawString(string,topx,topy);
      //g.drawPolygon(card.getSuit());
      g.drawString(string,midx,midy);
      g.drawString(string,botx,boty);
      if(string != "" || cardNum < 2)
         g.drawLine(XPLACE[placement][2]+offset,1,XPLACE[placement][2]+offset,150);
   }
   
   public void changePlacement(int placement)
   {
      topx = XPLACE[placement][0];
      midx = XPLACE[placement][1];
      botx = XPLACE[placement][2];
   }
   
}