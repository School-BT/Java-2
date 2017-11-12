/*
Triangle
Ben Burger
Drawing a triangle that flips on button push
10/22/2017
*/ 

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Triangle extends JPanel implements ActionListener
{
   int[] xPoints = {43,92,142};
   int[] yPoints = new int[3];
   
   int x = 1;
   
   JButton flip = new JButton("Flip");
   
   public Triangle()
   {
      setBackground(Color.WHITE);
      add(flip);
      flip.addActionListener(this);
   }
   
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      if(x == 0)
      {
         yPoints[0] = 51;
         yPoints[1] = 150;
         yPoints[2] = 51;
      }else
      {
         yPoints[0] = 150;
         yPoints[1] = 51;
         yPoints[2] = 150;
      }     
      g.drawPolygon(xPoints,yPoints,xPoints.length);
   }
   
   
   public void actionPerformed(ActionEvent e)
   {
      if(x == 0)
      {
         x = 1;
      }else
      {
         x = 0;
      }      
      
      repaint();
   }
   
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.add(new Triangle());
      frame.setSize(200,200);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}