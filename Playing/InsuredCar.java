/*
pg572
you do it
*/

import javax.swing.*;
public class InsuredCar extends Vehicle implements Insured
{
   private int coverage;
   public InsuredCar()
   {
      super("gas",4);
      setCoverage();
   }
   
   public void setPrice()
   {
      String entry;
      final int MAX = 6000;
      entry = JOptionPane.showInputDialog
         (null, "Enter car price ");
         price = Integer.parseInt(entry);
         if(price>MAX)
            price = MAX;
   }
   
   @Override
   public void setCoverage()
   {
      coverage = (int)(price*0.9);
   }
   
   @Override
   public int getCoverage()
   {
      return coverage;
   }
   
   @Override
   public String toString()
   {
      return("The insured car is powered by " + getPowerSource() +
             "; it has " + getWheels() + " wheels, costs $" + 
             getPrice() + " and is insured for $" + getCoverage());
   }
}