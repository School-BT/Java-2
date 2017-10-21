import javax.swing.*;
import java.awt.*;

public class JGridLayout extends JFrame
{
   private JButton nb = new JButton("North");
   private JButton sb = new JButton("South");
   private JButton eb = new JButton("East");
   private JButton wb = new JButton("West");
   private JButton cb = new JButton("Center");
   
   
   public JGridLayout()
   {
      setLayout(new GridLayout(2,3,2,4));
      add(sb);      
      add(nb);      
      add(wb);      
      add(eb);      
      add(cb);      
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public static void main(String[] args)
   {
      JGridLayout jbl = new JGridLayout();
      jbl.setSize(250,250);
      jbl.setVisible(true);
   }
   
}
