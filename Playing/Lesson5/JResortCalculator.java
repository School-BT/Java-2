import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JResortCalculator extends JFrame implements ItemListener
{
   final int base = 200;
   final int end = 100;
   final int brea = 20;
   final int golf = 75;
   int totalPrice = base;
   
   JCheckBox weekendBox = new JCheckBox("we prem $" + end,false);
   JCheckBox breakfastBox = new JCheckBox("bre $" + brea,false);
   JCheckBox golfBox = new JCheckBox("gol $" + golf,false);
   
   JLabel resortLabel = new JLabel("Resort Price calc");
   JLabel priceLabel = new JLabel("pricee");
   JTextField totPrice = new JTextField(4);
   JLabel optionExplainLabel = new JLabel("base $" + base);
   JLabel optionExplainLabel2 = new JLabel("checkOpt");
   
   public JResortCalculator()
   {
      super("resortPriceEst");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new FlowLayout());
      add(resortLabel);
      add(optionExplainLabel);
      add(optionExplainLabel2);
      add(weekendBox);
      add(breakfastBox);
      add(golfBox);
      add(priceLabel);
      add(totPrice);
      
      totPrice.setText("$" + totalPrice);
      weekendBox.addItemListener(this);
      breakfastBox.addItemListener(this);
      golfBox.addItemListener(this);
   }
   
   @Override
   public void itemStateChanged(ItemEvent event)
   {
      Object source = event.getSource();
      int select = event.getStateChange();
      
      if(source == weekendBox)
      {
         if(select == ItemEvent.SELECTED)
            totalPrice += end;
         else
            totalPrice -= end;
      }else if(source == breakfastBox)
      {
         if(select == ItemEvent.SELECTED)
            totalPrice += brea;
         else
            totalPrice -= brea;
      }else if(source == golfBox)
      {
         if(select == ItemEvent.SELECTED)
            totalPrice += golf;
         else
            totalPrice -= golf;
      }
      totPrice.setText("$" + totalPrice);
   }
   
   public static void main(String[] args)
   {
      JResortCalculator aFrame = new JResortCalculator();
      final int width = 300;
      final int height = 200;
      aFrame.setSize(width,height);
      aFrame.setVisible(true);
   }
   
}