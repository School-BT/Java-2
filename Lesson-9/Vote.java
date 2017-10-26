import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Vote extends JApplet implements ActionListener{
    
    public static int[] candidateOne = new int[500];
    public static int[] candidateTwo = new int[500];
    
    public static int canOneValue = 0;
    public static int canTwoValue = 0;
    
    public static String uCand = &quot;&quot;;
    
    JButton canOne = new JButton(&quot;Vote For Candidate ONE&quot;);
    JButton canTwo = new JButton(&quot;Vote For Candidate TWO&quot;);
    
    JButton results = new JButton(&quot;Results&quot;);
    
    JLabel resMsg = new JLabel();
    
    
    
    public Vote()
    {
        
        calculate(candidateOne);
        calculate(candidateTwo);
        
        JFrame f = new JFrame();
        
        results.addActionListener(this);
        canOne.addActionListener(this);
        canTwo.addActionListener(this);
        
        f.add(resMsg);
        f.add(canOne);
        f.add(canTwo);
        f.add(results);
        
    }
    
    
    
    
    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton)e.getSource();
        
        if(b == canOne)
            canOneFunction();
        else if(b == canTwo)
            canTwoFunction();
        else if(b == results)
            resultsFunction();
    }
    
    public void canOneFunction()
    {
        canOneValue += 1;
        uCand = &quot;Candidate One.&quot;;
        canOne.setVisible(false);
        canTwo.setVisible(false);
        results.setVisible(true);
    }
    
    public void canTwoFunction()
    {
        canTwoValue += 1;
        uCand = &quot;Candidate Two.&quot;;
        canTwo.setVisible(false);
        canOne.setVisible(false);
        results.setVisible(true);
    }
    
    public void resultsFunction()
    {
        String score = &quot;You voted for &quot; + uCand + &quot;&#92;n&quot; +
            &quot;Candidate One has&quot; + canOneValue + &quot;&#92;n&quot; +
            &quot;Candidate Two has&quot; + canTwoValue;
        
        resMsg.setText(score);
    }
    
    
    public static void initiateCandidates()
    {
        Random rand = new Random();
        
        for(int i = 0; i &lt; 500; ++i)
        {
            int oneVote = rand.nextInt(2);
            int twoVote = 0;
        
            if(oneVote == 1)
                twoVote = 0;
            else
                twoVote = 1;
              candidateOne[i] = oneVote;
              candidateTwo[i] = twoVote;
        }
    }
    
    
    public static void calculate(int[] cand)
    {
        int total = 0;
        for(int i = 0; i &lt; cand.length; ++i)
        {
            total += cand[i];
        }
        
        if(cand == candidateOne)
            canOneValue = total;
        else
            canTwoValue = total;
    }
    
    
    public static void main(String args[]) {
        initiateCandidates();
        calculate(candidateOne);
        calculate(candidateTwo);
        
        System.out.println(&quot;Sum of x+y = &quot; + canTwoValue);
        System.out.println(&quot;Sum of x+y = &quot; + canOneValue);
    }
}

