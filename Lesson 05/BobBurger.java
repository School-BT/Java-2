/*
BobBurger
register program... creates a food order
Ben Burger
10/11/2017
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BobBurger extends JFrame implements ItemListener
{
   //*****Start Prices*****
   public double total = 0;
   public double letPrice = .75;
   public double chePrice = .50;
   public double picPrice = .25;
   
   public double sinPrice = 5.00;
   public double douPrice = 7.00;
   
   public double smaPrice = 1.40;
   public double medPrice = 2.00;
   public double larPrice = 2.60;
   //****End Prices*****
   
   
   JLabel topLabel = new JLabel("Select Your Toppings:");
   JCheckBox letBox = new JCheckBox("Lettuce",false);
   JCheckBox cheBox = new JCheckBox("Cheese",false);
   JCheckBox picBox = new JCheckBox("Pickle",false);

   JLabel patLabel = new JLabel("Select Your Sandwich:");
   JCheckBox sinBox = new JCheckBox("Single Patty",true);
   JCheckBox douBox = new JCheckBox("Double Patty",false);
   
   JLabel driLabel = new JLabel("Select Your Drink:");
   JCheckBox smaBox = new JCheckBox("Small Drink",false);
   JCheckBox medBox = new JCheckBox("Medium Drink",false);
   JCheckBox larBox = new JCheckBox("Large Drink",false);
   
   JLabel finalPriceHint = new JLabel("Total Price:");
   JTextField finalPrice = new JTextField("");
   
   
   public BobBurger()
   {
      super("Register");
      setSize(425,175);
      setLayout(new FlowLayout());
           
      populateToppings();
      populatePatties();
      populateDrinks();

      populateFinal();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   
   //*****Helper methods for JField population*****
   //******************Start***********************
   public void populateFinal()
   {
      add(finalPriceHint);
      add(finalPrice);
      updateTotal();
      finalPrice.setPreferredSize(new Dimension(100, 25));
   }
   
   
   public void populateToppings()
   {
      add(topLabel);
      add(letBox);
      add(cheBox);
      add(picBox);
      letBox.addItemListener(this);
      cheBox.addItemListener(this);
      picBox.addItemListener(this);
   }
   
   
   public void populatePatties()
   {
      add(patLabel);
      add(sinBox);
      total = sinPrice;
      add(douBox);
      sinBox.addItemListener(this);
      douBox.addItemListener(this);
   }
   
   
   public void populateDrinks()
   {
      add(driLabel);
      add(smaBox);
      add(medBox);
      add(larBox);
      smaBox.addItemListener(this);
      medBox.addItemListener(this);
      larBox.addItemListener(this);
   }
   //*************END Population helpers**********
   
   
   //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   //!!!!!!!!!!!!!!!!MAIN START!!!!!!!!!!!!!!!!!!!
   //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   
   public static void main(String[] args)
   {
      JFrame frame = new BobBurger();
      frame.setVisible(true);
   }
   
   //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   //!!!!!!!!!!!!!!!!MAIN END!!!!!!!!!!!!!!!!!!!!!
   //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
   
   
   //*****input Handler*****
   @Override
   public void itemStateChanged(ItemEvent e)
   {
      Object source = e.getSource();
      int select = e.getStateChange();
      
      letCheck(source,select);
      cheCheck(source,select);
      picCheck(source,select);
      
      sinCheck(source,select);
      douCheck(source,select);
      
      smaCheck(source,select);
      medCheck(source,select);
      larCheck(source,select);
      
      updateTotal();
   }
   
   //rounds and updates the finalPrice text field
   public void updateTotal()
   {
      round();
      finalPrice.setText("$" + total);
   }
   
   //Quicky round function
   public void round()
   {
      String start = total + "00000";
      int threePast = start.indexOf(".") + 4;
      String shortnd = start.substring(0,threePast);
      int checkNum = Integer.parseInt(
            shortnd.substring(threePast-1,threePast));
      total = Double.parseDouble(shortnd.substring(0,threePast-1));
      if(checkNum>4)
      {
         total += .01;
      }
   }
   
   
//*****check if checkbox is checked then acts acordingly*****
 
   //lettuce
   public void letCheck(Object source,int select)
   {
      if(source == letBox)
         if(select == ItemEvent.SELECTED)
            total += letPrice;
         else
            total -= letPrice;
   }


   //cheese
   public void cheCheck(Object source,int select)
   {
      if(source == cheBox)
         if(select == ItemEvent.SELECTED)
            total += chePrice;
         else
            total -= chePrice;
   }
   

   //pickles
   public void picCheck(Object source,int select)
   {
      if(source == picBox)
         if(select == ItemEvent.SELECTED)
            total += picPrice;
         else
            total -= picPrice;
   }
   
   
   //single patty
   public void sinCheck(Object source,int select)
   {
      if(source == sinBox)
         if(select == ItemEvent.SELECTED)
         {
            total += sinPrice;
            douBox.setSelected(false);
         }else
         {
            total -= sinPrice; 
            douBox.setSelected(true);
         }
   }


   //double patty
   public void douCheck(Object source,int select)
   {
      if(source == douBox)
         if(select == ItemEvent.SELECTED)
         {
            total += douPrice;
            sinBox.setSelected(false);
         }else
         {
            total -= douPrice; 
            sinBox.setSelected(true);
         }
   }
   

   //small drink
   public void smaCheck(Object source,int select)
   {
      if(source == smaBox)
         if(select == ItemEvent.SELECTED)
         {
            total += smaPrice;
            medBox.setSelected(false);
            larBox.setSelected(false);
         }else
         {
            total -= smaPrice; 
         }
   }

   
   //medium drink
   public void medCheck(Object source,int select)
   {
      if(source == medBox)
         if(select == ItemEvent.SELECTED)
         {
            total += medPrice;
            smaBox.setSelected(false);
            larBox.setSelected(false);
         }else
         {
            total -= medPrice; 
         }
   }

   
   //large drink
   public void larCheck(Object source,int select)
   {
      if(source == larBox)
         if(select == ItemEvent.SELECTED)
         {
            total += larPrice;
            smaBox.setSelected(false);
            medBox.setSelected(false);
         }else
         {
            total -= larPrice; 
         }
   }


}