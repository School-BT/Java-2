/*
BorderLocation
BorderLayout demonstration
Ben Burger
10/11/2017
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderLocation extends JFrame implements ActionListener
{
   JButton north = new JButton("  ");
   JButton south = new JButton("  ");
   JButton east = new JButton("  ");
   JButton west = new JButton("  ");
   JButton center = new JButton("  ");
      
   
   public BorderLocation()
   {
      super("BorderLocation");
      setSize(400,400);
      add(north,BorderLayout.NORTH);
      add(south,BorderLayout.SOUTH);
      add(east,BorderLayout.EAST);
      add(west,BorderLayout.WEST);
      add(center,BorderLayout.CENTER);
      
      north.addActionListener(this);
      south.addActionListener(this);
      center.addActionListener(this);
      east.addActionListener(this);
      west.addActionListener(this);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   
   public static void main(String[] args)
   {
      BorderLocation frame = new BorderLocation();
      frame.setVisible(true);
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      Object source = e.getSource();
      
      if(source == north)
      {
         center.setText("North");
         System.out.println("North");
      }else if(source == south)
         center.setText("South");
      else if(source == east)
         center.setText("East");
      else if(source == west)
         center.setText("West");
      else
         center.setText("Center");            
   }
}