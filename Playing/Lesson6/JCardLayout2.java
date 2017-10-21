import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JCardLayout2 extends JFrame implements ActionListener
{
   CardLayout cardLayout = new CardLayout();
   private JButton nb = new JButton("North");
   private JButton sb = new JButton("South");
   private JButton eb = new JButton("East");
   private JButton wb = new JButton("West");
   private JButton cb = new JButton("Center");
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      cardLayout.next(getContentPane());
   }
   
   public JCardLayout2()
   {
      setLayout(cardLayout);
      add("south",sb);      
      add("north",nb);      
      add("west",wb);      
      add("east",eb);      
      add("center",cb);     
      
      nb.addActionListener(this);
      sb.addActionListener(this);
      eb.addActionListener(this);
      wb.addActionListener(this);
      cb.addActionListener(this); 
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public static void main(String[] args)
   {
      JCardLayout2 jbl = new JCardLayout2();
      jbl.setSize(250,250);
      jbl.setVisible(true);
   }
   
}
