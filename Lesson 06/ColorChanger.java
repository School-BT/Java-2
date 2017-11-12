/*
ColorChanger
Changes color randomly when button is clicked
Ben Burger
10/11/2017
*/

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorChanger extends JFrame implements ActionListener
{
   public static Color color = new Color(0,0,0);   
   
   public static JPanel north = new JPanel();
   public static JPanel south = new JPanel();
   public static JPanel east = new JPanel();
   public static JPanel west = new JPanel();
   public static JPanel center = new JPanel(new GridBagLayout());
   
   JButton push = new JButton("Switch");
   
   
   public ColorChanger()
   {
      super("Color Changer");
      setLayout(new BorderLayout());
      add(north,BorderLayout.NORTH);
      add(south,BorderLayout.SOUTH);
      add(east,BorderLayout.EAST);
      add(west,BorderLayout.WEST);
      add(center,BorderLayout.CENTER);
      
      center.add(push);
      
      push.addActionListener(this);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(200,200);
      setResizable(false);
   }
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      fullMonte();
   }
   
   public static void main(String[] args)
   {
      ColorChanger frame = new ColorChanger();
      frame.setVisible(true);
   }
   
   public static void randomizeColor()
   {
      Random rand = new Random();
      int r = rand.nextInt(256);
      int g = rand.nextInt(256);
      int b = rand.nextInt(256);
      
      color = new Color(r,g,b);
   }
   
   public static void fullMonte()
   {
      Random rand = new Random();
      int place = rand.nextInt(5);
      randomizeColor();
      randomizeRegion(place);
   }
   
   public static void randomizeRegion(int place)
   {
      switch(place)
      {
         case 0:
            north.setBackground(color);
            break;
         case 1:
            south.setBackground(color);
            break;
         case 2:
            east.setBackground(color);
            break;
         case 3:
            west.setBackground(color);
            break;
         default:
            center.setBackground(color);
            break;
      }
   }
   
}