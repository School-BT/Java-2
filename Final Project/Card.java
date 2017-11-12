/*
Ben Burger
Card.java
a class that builds a card.
10/21/2017
*/

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class Card extends JPanel
{
   int cardNum;
   Font font;
   Color color;
   Polygon suitShape;
   int red = 1;
   int black = 0;
   int blue = 2;
   String string = "";
   
   int topx = 1;
   int topy = 11;
   int midx = 50;
   int midy = 75;
   int botx = 100;
   int boty = 150;
   int topxs = botx;
   int botxs = topx;
   
   //diamond design
   int[] dxPoints = {0,50,100,50};
   int[] dyPoints = {75,0,75,150};
   
   //heart design
   int[] hxPoints = {0,10,25,50,75,90,100,50};
   int[] hyPoints = {10,0,5,10,5,0,10,150};
   
   //club design                                 
   int[] cxPoints = {0,15,25,17,26,50,74,83,75,85,100,85,75,83,74,50,26,17,25,15};
   int[] cyPoints = {75,40,50,52,20,0,20,52,50,40,75,110,100,98,130,150,130,98,100,110};
   
   //spade design
   int[] sxPoints = {0,10,25,50,75,90,100,50};
   int[] syPoints = {140,150,145,140,145,150,140,0};
   
   //back design
   int[] bxPoints = {1,100,100,1};
   int[] byPoints = {1,1,150,150};
   
   Polygon diamond = new Polygon(dxPoints,dyPoints,dxPoints.length);
   Polygon heart = new Polygon(hxPoints,hyPoints,hxPoints.length);
   Polygon club = new Polygon(cxPoints,cyPoints,cxPoints.length);
   Polygon spade = new Polygon(sxPoints,syPoints,sxPoints.length);
   Polygon back = new Polygon(bxPoints,byPoints,bxPoints.length);
   
   
   public Card(int inNum,int inSuit)
   {
      cardNum = inNum;
      
      setString(inNum);
      
      setSuit(inSuit);
           
      setBackground(Color.WHITE);
   }
   
   
   //sets the suit to the selected number
   public void setSuit(int num)
   {
      switch(num)
      {
         case 1:
            color = Color.RED;
            suitShape = diamond;
            break;
         case 2:
            color = Color.RED;
            suitShape = heart;
            break;
         case 3:
            color = Color.BLACK;
            suitShape = spade;
            break;
         case 4:
            color = Color.BLACK;
            suitShape = club;
            break;
         default:
            color = Color.BLUE;
            suitShape = back;
            break;
      }
      
   }
   
   
   //sets the number of a card object
   public void setNum(int i)
   {
      cardNum = i;
      
      if(cardNum == 0)
         setSuit(0);
         
      setString(i);
   }
   
   
   //returns number from the card
   public int getValue()
   {
      int num = cardNum;
      return num;
   }
   
   //this sends the suit shape
   public Polygon getSuit()
   {
      return suitShape;
   }

   //gets the number in string form
   public String getString()
   {
      return string;
   }
   
   //sets the number as a string
   public void setString(int num)
   {
      switch(num)
      {
         case 0:
            string = "";
            cardNum = num;
            suitShape = back;
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
   
   
   //this does the drawing
   public void populateOne(Graphics g)
   {      
      g.setColor(color);
      if(cardNum == 0)
      {
         suitShape = back;
         string = "";
      }else
         string = "" + string;
         
      g.drawString(string,topx,topy);
      g.drawPolygon(suitShape);
      g.drawString(string,midx,midy);
      g.drawString(string,botx,boty);
      g.drawLine(1,1,1,150);
      g.drawLine(100,150,100,1);
   }
   
}