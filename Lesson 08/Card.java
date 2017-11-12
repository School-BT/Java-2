/*
Card
this is a playing card... sort of
Ben Burger
10/28/2017
*/

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class Card extends JPanel
{
   int cardNum;
   Font font;
   Color color;
   int suit;
   Polygon suitShape;
   int red = 1;
   String string = "";
   
   int topx = 1;
   int topy = 11;
   int midx = 50;
   int midy = 75;
   int botx = 100;
   int boty = 150;
   int topxs = botx;
   int botxs = topx;
   
   int[] xPoints = {0,50,100,50};
   int[] yPoints = {75,0,75,150};
   Polygon diamond = new Polygon(xPoints,yPoints,xPoints.length);
   Polygon heart = new Polygon(xPoints,yPoints,xPoints.length);
   Polygon club = new Polygon(xPoints,yPoints,xPoints.length);
   Polygon spade = new Polygon(xPoints,yPoints,xPoints.length);
   
   public Card(int s,int i)
   {
      cardNum = s;
      suit = i;
      setString(s);
      
      if(i == red)
         color = Color.RED;
      else
         color = Color.BLACK;
      
      setBackground(Color.WHITE);
   }
   
   
   public void setNum(int i)
   {
      cardNum = i;
      setString(i);
   }
   
   public int getValue()
   {
      int num = cardNum;
      return num;
   }
   
   public Polygon getSuit()
   {
      return suitShape;
   }
   
   public String getString()
   {
      return string;
   }
   
   public void setString(int num)
   {
      switch(num)
      {
         case 0:
            string = "";
            cardNum = num;
            break;
         case 1:
            string = "A";
            cardNum = 11;
            break;
         case 11:
            cardNum = 10;
            string = "J";
            break;
         case 12:
            cardNum = 10;
            string = "Q";
            break;
         case 13:
            cardNum = 10;
            string = "K";
            break;
         default:
            string = "" + num;
            break;
      }
   }
   
  
   
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      
      populateOne(g);
   }
   
   
   public void populateOne(Graphics g)
   {      
      g.setColor(color);
      if(cardNum == 0)
         string = "";
      else
         string = "" + cardNum;
         
      g.drawString(string,topx,topy);
      g.drawPolygon(diamond);
      g.drawString(string,midx,midy);
      g.drawString(string,botx,boty);
      g.drawLine(1,1,1,150);
      g.drawLine(100,150,100,1);
   }
   
}