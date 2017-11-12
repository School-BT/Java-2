/*
Ben Burger
JLottery2.java
a simple lottery game.
10/21/2017
*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.awt.Color;


public class JLottery2 extends JFrame implements ActionListener
{
   final int MAX_NUM = 31;
   final int CB_MAX = 6;      
   
   public static int count;
   
   int sameCount = 0;
   
   JPanel pan1 = new JPanel(new GridLayout(2,MAX_NUM,2,2));
   JPanel pan2 = new JPanel(new GridLayout(2,MAX_NUM,2,2));
   JPanel pan3 = new JPanel(new GridLayout(2,MAX_NUM,2,2));
   JPanel pan4 = new JPanel(new GridLayout(2,MAX_NUM,2,2));
   JPanel pan5 = new JPanel(new GridLayout(2,MAX_NUM,2,2));
   JPanel pan6 = new JPanel(new GridLayout(2,MAX_NUM,2,2));
   
   ButtonGroup g1 = new ButtonGroup();
   ButtonGroup g2 = new ButtonGroup();
   ButtonGroup g3 = new ButtonGroup();
   ButtonGroup g4 = new ButtonGroup();
   ButtonGroup g5 = new ButtonGroup();
   ButtonGroup g6 = new ButtonGroup();
   
   JPanel spacer1 = new JPanel();
   JPanel spacer2 = new JPanel();
   JPanel spacer3 = new JPanel();
   JPanel spacer4 = new JPanel();
   JPanel spacer5 = new JPanel();
   
   JPanel spacer6 = new JPanel(new GridLayout(1,5,2,2));
   JPanel pan7 = new JPanel(new GridLayout(1,4,2,2));
   
   int[] numbers = new int[31];
   
   public static int[] user = new int[31];
   public static int[] comp = new int[31];
   public static int[] userL = new int[6];
   public static int[] compL = {1,2,3,5,6,7};
   
   
   JButton play = new JButton("Play");   
   
   JLabel compList = new JLabel("");
   JLabel playerList = new JLabel("");
   JLabel countTotaler = new JLabel("");
   JLabel winnings = new JLabel("");
   
   
   public JLottery2()
   {        
      menuBarStuff();
      
      setLayout(new GridLayout(13,1,2,2));
      
      makeGui();
      
      setVisible(true);
      setSize(800,500);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   
   
   //makes the full gui
   public void makeGui()
   {
      buildNumberGrids();
      
      addLastPan();
      
      buildFull();
   }
   
   //builds all number grid pannels
   public void buildNumberGrids()
   {
      buildNumberGrid(g1,pan1);
      buildNumberGrid(g2,pan2);
      buildNumberGrid(g3,pan3);
      buildNumberGrid(g4,pan4);
      buildNumberGrid(g5,pan5);
      buildNumberGrid(g6,pan6);
      buildFinalizePan(pan7);
      play.addActionListener(this);      
   }
   
   //builds last Pannel
   public void addLastPan()
   {
      JLabel label = new JLabel("");
      JLabel RealNums = new JLabel("Lotery Numbers");
      JLabel YourNums = new JLabel("Your Picks");
      JLabel SameCount = new JLabel("Matches");
      JLabel Prize = new JLabel("Prize");
      
      spacer6.add(label);
      spacer6.add(RealNums);
      spacer6.add(YourNums);
      spacer6.add(SameCount);
      spacer6.add(Prize);
   }
   
   //pulls all panels together
   public void buildFull()
   {
      add(pan1);
      add(spacer1);
      add(pan2);
      add(spacer2);
      add(pan3);
      add(spacer3);
      add(pan4);
      add(spacer4);
      add(pan5);
      add(spacer5);
      add(pan6);
      add(spacer6);
      add(pan7);
   }
   
   
   public static void main(String[] args)
   {
      
      JLottery2 frame = new JLottery2();
   }
      
   //this builds a pannel with numbers 0 through 30 inclusive.
   public void buildNumberGrid(ButtonGroup group,JPanel pan)
   {
      for(int i = 0; i < MAX_NUM; ++i)
      {
         JCheckBox cb = new JCheckBox(i + "");           
         cb.setActionCommand(i + "");
         cb.setSelected(true);
         group.add(cb);
         pan.add(cb);
      }
   }
   
   
   //this is the "Score Board" part of the gui
   public void buildFinalizePan(JPanel pan)
   {
      pan.add(play);
      pan.add(compList);
      pan.add(playerList);
      pan.add(countTotaler);
      pan.add(winnings);
   }
   
   //This is the extra stuff from the Rubric
   public void menuBarStuff()
   {
      JMenuBar mainBar = new JMenuBar();
      JMenu menu = new JMenu("File");
      JMenuItem about = new JMenuItem("About");
      
      setJMenuBar(mainBar);
      mainBar.add(menu);
      menu.add(about);
      about.addActionListener(this);
   }
   
   
   
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource() == play)   
      {
         randomize();
         buildUser();
         buildCount(userL,user);
         buildCount(compL,comp);
         calculate();
         print(userL,playerList);
         print(compL,compList);
         countTotaler.setText(count + "");
         winnings.setText("$" + winnings(count));
      }
      else
      {
         JOptionPane.showMessageDialog(null,
            "Made By: Ben Burger" );
      }
   }
   
  
   //returns the winnigs due to number of matched numbers
   public int winnings(int num)
   {
      switch(num)
      {
         default:
            return 0;
         case 3:
            return 100;
         case 4:
            return 10000;
         case 5:
            return 50000;
         case 6:
            return 1000000;
      }
   }
   
   //prints entire int[] to a jLabel
   public void print(int[] nums,JLabel textBox)
   {
      int LEN = nums.length - 1;
      
      String listString = nums[0] + ", ";
      
      for(int i = 1; i < LEN ; ++i)
      {
         listString = listString + nums[i] + ", ";
      }
      
      listString = listString + nums[LEN] + ".";
      
      textBox.setText(listString);
   }
   
   
    //counts same numbers... the logic part...
    public static void calculate()
    {
      count = 0;
        for(int t = 0;t < 31;++t)
        {
            int x = user[t];
            int i = comp[t];
            
            while(x > 0 && i > 0)
            {
                ++count;
                --x;
                --i;
            }
        }
    }

   
   // builds the count arrays for the given user
   //*****Must be the same... User-user or comp-comp
   public void buildCount(int[] userComp,int[] count)
   {
      init(count);
      
       for(int i = 0; i < 6; ++i)   
       { 
    	   for(int x = 0;x < 31; ++x)
         {  
       		if(userComp[i] == x)                
		         count[x] += 1;
        }
      }
   }
   
   //builds the user's array of numbers to be tested later
   public void buildUser()
   {
	   userL[0] = getUser(g1);
	   userL[1] = getUser(g2);
	   userL[2] = getUser(g3);
	   userL[3] = getUser(g4);
	   userL[4] = getUser(g5);
	   userL[5] = getUser(g6);
   }
   
   //gets the user's selected item from one group.
   public static int getUser(ButtonGroup group)
   {
      String string = group.getSelection().getActionCommand();
	   int num = Integer.parseInt(string);
	   return num;
   }
   
   
    //initiates number count to zero
    public static void init(int[] uco)
    {
        for(int i = 0; i < 31;++i)
        {
            uco[i] = 0;
        }
    }

   
   //This randomizes the numbers from the lottery
   public void randomize()
   {
      Random rand = new Random();
      
      for(int i = 0; i < CB_MAX; ++i)
      {
         int random = rand.nextInt(MAX_NUM);
         compL[i] = random;
      }
      
   }   
   
}