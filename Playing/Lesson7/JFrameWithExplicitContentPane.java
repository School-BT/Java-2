import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class JFrameWithExplicitContentPane extends JFrame
{
   private final int SIZE = 180;
   private Container con = getContentPane();
   private JButton button = new JButton("Press Me");
   
   public JFrameWithExplicitContentPane()
   {
      setSize(SIZE,SIZE);
      con.setLayout(new FlowLayout());
      con.add(button);
      con.setBackground(Color.YELLOW);
      button.setBackground(Color.RED);
      button.setForeground(Color.WHITE);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public static void main(String[] args)
   {
      JFrameWithExplicitContentPane frame = new JFrameWithExplicitContentPane();
      frame.setVisible(true);
   }
}