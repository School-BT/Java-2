import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.util.Random;

public class Checkerboard extends JFrame implements ActionListener
{
   private final int rows = 6;
   private final int cols = 6;
   private final int gap = 2;
   private final int num = rows * cols;
   private int x;
   private Random rand = new Random();
   private int n = rand.nextInt(6);
   public static Checkerboard frame;
   
   private JPanel pane = new JPanel(new GridLayout(rows,cols,gap,gap));
   private JPanel[] panel = new JPanel[num];
   private Color color1 = Color.WHITE;
   private Color color2 = Color.RED;
   private Color tempColor;
   
   
   //horizontal ship
   public Checkerboard()
   {
      add(pane);
      
      System.out.println("" + n);
      for(x=0;x<num;++x)
      {
         panel[x] = new JPanel();
         pane.add(panel[x]);
         
         if(x >= n*6 && x < 6*(n+1))
            panel[x].setBackground(color1);
         else
            panel[x].setBackground(color2);
      }
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   
   //vertical ship
   public Checkerboard(int z)
   {
      add(pane);
      
      System.out.println("" + n);
      for(x=0;x<num;++x)
      {
         panel[x] = new JPanel();
         pane.add(panel[x]);
         
         if((n + x)%cols == 0)
            panel[x].setBackground(color1);
         else
            panel[x].setBackground(color2);
      }
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   
   public void loadButton(int t)
   {
      JButton b = new JButton("" + t);
      pane.add(b);
      b.addActionListener(this);
      
   }
   
   
   public static void randBoard()
   {
      Random r = new Random();
      int rand = r.nextInt(2);
      if(rand == 0)
      {
         System.out.println("INT");
         frame = new Checkerboard(1);
      }else
      {
         frame = new Checkerboard();
      }
   }
   
   
   public static void main(String[] args)
   {
      randBoard();
      frame.setSize(300,300);
      frame.setVisible(true);
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e)
   {
      String b = e.getActionCommand();
      System.out.println(b);
   }
   
}