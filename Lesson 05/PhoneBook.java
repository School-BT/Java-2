/*
PhoneBook
a contacts program. select name get number
Ben Burger
9/12/2017
*/

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PhoneBook extends JFrame implements ActionListener
{
  static String[] names = {"Bob","Sally","Mike","Alice","Tom"};
  static String[] numbers = {"111-1111","222-2222","333-3333","444-4444",
                             "555-5555"};

  JComboBox<String> nameChoice = new JComboBox<String>();
  
  JLabel output = new JLabel("");
    
  public PhoneBook()
  {
    super("PhoneBook");
    setSize(150,75);
    setLayout(new FlowLayout());
        
    buildDropdown();
    add(nameChoice);
    add(output);
    output.setText(numbers[nameChoice.getSelectedIndex()]);
        
    nameChoice.addActionListener(this);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }


   public static void main(String args[]) 
   {
    JFrame frame = new PhoneBook();
    frame.setVisible(true);
   }

   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      int num = nameChoice.getSelectedIndex();
      output.setText(numbers[num]);
   }  
  
   public void buildDropdown()
   {
      for(int i = 0;i<names.length;++i)
      {
         nameChoice.addItem(names[i]);
      }
   }
  
 }