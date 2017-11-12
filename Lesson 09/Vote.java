/*
Vote
This is a Voting applet
Ben Burger
10/30/2017
*/


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

//Extends JApplet
public class Vote extends JApplet implements ActionListener{
    
    public static int canOneValue = 0;
    public static int canTwoValue = 0;
    
    public static String uCand = "";
    public static String winning = "";
    
    //Three Buttons
    JButton canOne = new JButton("Vote For Candidate 1.");
    JButton canTwo = new JButton("Vote For Candidate 2.");
    JButton results = new JButton("See Results.");
    
    //Displays user selection
    JLabel yourChoice = new JLabel();
    
    //Displays Random Results
    JLabel oneResMsg = new JLabel();
    JLabel twoResMsg = new JLabel();
    JLabel winnerMsg = new JLabel();
    
    
    JPanel scorePan = new JPanel(new GridLayout(4,1,2,2));
    JPanel pan = new JPanel();
    
    public Vote()
    {
        initiateCandidates();      
    }
    
    
   public void init() 
   {
      canOne.addActionListener (this);
      canTwo.addActionListener (this);
      results.addActionListener(this);
                
      buildPan();
      buildScorePan();
      results.setVisible(false);
      getContentPane().add(pan);
   }
   
   //this hosts the buttons and scoreBoard
   public void buildPan()
   {    
      pan.add(canOne);
      pan.add(canTwo);
      pan.add(results);
      
      pan.add(scorePan);
   } 
    
   //this hosts the results
   public void buildScorePan()
   {
      yourChoice.setForeground(Color.RED);
      scorePan.add(yourChoice);
      scorePan.add(oneResMsg);
      scorePan.add(twoResMsg);
      winnerMsg.setFont(new Font("Arial",Font.BOLD,17));
      winnerMsg.setForeground(Color.RED);
      scorePan.add(winnerMsg);
   }
    
    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton)e.getSource();
        
        if(b == canOne)
        {
            canOneFunction();
        }
        else if(b == canTwo)
        {
            canTwoFunction();
        }
        else
        {
            resultsFunction();
        }
    }
    
    //what happens on button click
    public void canOneFunction()
    {
        canOneValue += 1;
        uCand = "Candidate One.";
        canTwo.setEnabled(false);
        canOne.setEnabled(false);
        results.setVisible(true);
    }
    
    //what happens on button click
    public void canTwoFunction()
    {
        canTwoValue += 1;
        uCand = "Candidate Two.";
        canTwo.setEnabled(false);
        canOne.setEnabled(false);
        results.setVisible(true);
    }
    
    //what happens on button click 
   public void resultsFunction()
   {        
      String yourCand = "You voted for " + uCand;
      String candOneStr = "Candidate One has " + canOneValue + " votes.";
      String candTwoStr = "Candidate Two has " + canTwoValue + " votes.";
      
      getWinning();
      
      yourChoice.setText(yourCand);
      oneResMsg.setText(candOneStr);
      twoResMsg.setText(candTwoStr);
      winnerMsg.setText(winning);
      
      results.setVisible(false);
    }
    
    
    public void getWinning()
    {
      if(canOneValue > canTwoValue)
         winning = "Candidate One WON!";
      else if(canTwoValue > canOneValue)
         winning = "Candidate Two WON!";
      else
         winning = "The Candidates Tied!";
    }
    
    //creates random results
    public static void initiateCandidates()
    {
        Random rand = new Random();
        
        for(int i = 0; i < 500; ++i)
        {
            int oneVote = rand.nextInt(2);
            int twoVote = rand.nextInt(2);
        
            canOneValue += oneVote;
            canTwoValue += twoVote;
        }
    }  
    

}