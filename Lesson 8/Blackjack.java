import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Blackjack implements ActionListener
{
    
    public final static int DECK_NUM = 52;
   
   public static int[] deck = new int[DECK_NUM];
   public static int[] quarterDeck = {1,2,3,4,5,6,7,8,9,10,11,12,13};
   
   public static String[] suits = {&quot;spade&quot;,&quot;heart&quot;,&quot;diamond&quot;,&quot;club&quot;};
   public static int[] indexes = new int[DECK_NUM];
   
   public static int[] user = new int[8];
   public static int[] comp = new int[8];
   public static int userSelect = 0;
    
    JPanel scoreBoard = new JPanel();
    JPanel buttons = new JPanel();
    JPanel userCards = new JPanel();
    JPanel compCards = new JPanel();
    
    //buttons
    static JButton hitButton = new JButton(&quot;Hit&quot;);
    JButton stayButton = new JButton(&quot;Stay&quot;);
    
    //scoreBoard
    JTextField userScore = new JTextField();
    JTextField compScore = new JTextField();
    JLabel userName = new JLabel();
    JLabel compName = new JLabel();
    
    JFrame f = new JFrame();
    
    
    //builds the frame
    public void buildFrame()
    {
        int[] compUserArray = {1,2,3,4,5,6,7,8};
        
        buildCardField(compUserArray);//for comp array
        buildScoreBoard();
        buildButtons();
        buildCardField(compUserArray);//for user array
        
        f.add(compCards);
        f.add(scoreBoard);
        f.add(buttons);
        f.add(userCards);
    }
    
    
    //builds score board panel
    public void buildScoreBoard()
    {
        scoreBoard.add(compName);
        scoreBoard.add(compScore);
        scoreBoard.add(userName);
        scoreBoard.add(userScore);
        
    }
    
    //builds card field panel
    public void buildCardField(int[] aHand)
    {
        int[] xx = {2,2}; //delete
        int[] yy = {2,3}; //delete 
        if(aHand == xx)// aHand == userCardsArray
        {
            for(int i = 0; i &lt; 8; ++i)
            {
                //userCards.add(userCardsArray[i]);
            }
        }
        if(aHand == yy)//aHand == compCardsArray
        {
            for(int i = 0; i &lt; 8; ++i)
            {
                //compCards.add(compCardsArray[i]);
            //cycle through hand to print cards to screen
            }
        }
    }
    
    //builds buttons panel
    public void buildButtons()
    {
        hitButton.addActionListener(this);
        stayButton.addActionListener(this);
        
        buttons.add(hitButton);
        buttons.add(stayButton);
    }

    
    
    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton)e.getSource();
        if(b == hitButton)
        {   
            if(userSelect == 0)
            pickRandomCard(user);
            else
            {
                pickRandomCard(comp);
                compPlay();
            }
        }else if(b == stayButton)
        {
            userSelect = 1;
            compPlay();
        }
    }
    
    
    public static void compPlay()
    {
        if(calculate(comp) &gt; 17)
           hitButton.doClick();
        else
            print(&quot;stay&quot;);
    }
    
   
   public static void main(String[] args)
   {
       int LEN = 5;
       for(int i = 0;i &lt; LEN; ++i)
       {
        fullMonte();
       }
   }
   
   //initiates and populates everything
   public static void fullMonte()
   {
       initiate(user);
       initiate(comp);
       buildIndexes();
       createDeck();
       pickRandomCard(comp);
       pickRandomCard(comp);
       pickRandomCard(user);
       pickRandomCard(user);
       pickRandomCard(comp);
       pickRandomCard(user);
       
       System.out.println(calculate(user));
       System.out.println(calculate(comp));
       
       checkWin();
    
   }
   
   //rules for automated win/lose of hands.
   public static void checkWin()
   {
       if(calculate(user) &gt; 21 &amp;&amp; calculate(comp)&gt;21||calculate(user) &gt; 21 &amp;&amp; calculate(comp)&lt;=21)//user bust
           print(&quot;losex&quot;);
       else if(calculate(comp) &gt; 21 &amp;&amp; calculate(user) &lt;=21)//comp bust user not
           print(&quot;winx&quot;);
       else if(calculate(comp) &gt;= calculate(user))//comp equal to or greater than user
           print(&quot;losey&quot;);
       else//user greater than comp
          print(&quot;winy&quot;);
   }
   
   //simplified print sequence.
   public static void print(String str)
   {
       System.out.println(str);
   }
   
   //calculates value of a hand. either userCards or compCards
   public static int calculate(int[] inputList)
   {
       int output = 0;
       
       int LEN = inputList.length;
       for(int i = 0; i &lt; LEN ; ++i)
       {
           int cal = inputList[i];
           int number = calcHelp(cal);
           output += number;
       }
       
       return output;
   }
   
   //sets jack, queen, king, and ace to their actual values
   public static int calcHelp(int input)
   {
       switch(input)
       {
           case 1:
           case 11:
           case 12:
           case 13:
               return 10;
           default:
               return input;
       }
   }
   
   //initializes the list of avalibal card&#39;s indexes
   public static void buildIndexes()
   {
       indexes = new int[DECK_NUM];
       
       for(int i = 0; i &lt; DECK_NUM; ++i)
       {
           indexes[i] = i;
       }
   }
   
   //builds full deck at the begining of program.
   public static void createDeck()
   {
      for(int i = 0; i &lt; DECK_NUM; ++i)
      {
         deck[i] = quarterDeck[i %( DECK_NUM/4)];
      }
   }
   
   //simplified random int
   public static int randomNum(int topVal)
   {
       Random random = new Random();
       int randNum = random.nextInt(topVal);
       return randNum;
   }
   
   //picks a random card and puts it in the inputs array
   public static void pickRandomCard(int[] compUser)
   {
       int inLen = indexes.length;
       
       int LEN = indexes.length;
       int randomNum = randomNum(inLen);
       for(int i = 0; i &lt; LEN ;++i)
       {
            if(compUser[i] == 0)
            {
                compUser[i] = deck[indexes[randomNum]];
                break;
            }
       }
       removeIndex(randomNum);
   }
   
   
   //removes the number *int* from intdexes
   public static void removeIndex(int num)
   {
       int LEN = indexes.length;
       int[] tempIndex = new int[LEN];
       
       //copy indexes
       for(int i = 0;i &lt; LEN; ++i)
       {
           int inNum = indexes[i];
           tempIndex[i] = inNum;
       }
       
       //remove info from indexes
       indexes = new int[LEN - 1];
       
       remHelp(num,LEN,tempIndex);
       
   }
   
   
   //helps remove integers from the avalible cards index list.
   public static void remHelp(int num, int LEN, int[] tempIndex)
   {
       int x = 0;
       
       LEN -= 1;
       
       //add not the selected number&#39;s index to indexes.
       for(int i = 0; i &lt; LEN; ++i)
       {
           int inNum = tempIndex[i];
           
           if(num != inNum)
           {
               indexes[x] = inNum;
               x+=1;
           }
           
       }
   }
   
   //sets input int array to all zeros
   public static void initiate(int[] compUser)
   {
       int LEN = compUser.length;
       
       for(int i = 0; i &lt; LEN; ++i)
       {
           compUser[i] = 0;
       }
       
   }
   
   
   //prints an array of ints
   public static void print(int[] input)
   {
       int LEN = input.length;
       
       for(int i = 0; i &lt; LEN; ++i)
       {
           System.out.println(&quot;&quot; + input[i]);
           
       }
       
   }
}

