import java.util.*;

public class Blackjack {
   
   
    public ArrayList<Card> spades = new ArrayList<Card>();
    public ArrayList<Card> hearts = new ArrayList<Card>();
    public ArrayList<Card> clubs = new ArrayList<Card>();
    public ArrayList<Card> diamons = new ArrayList<Card>();
    
    public final String SPADE = "Spades";
    public final String HEART = "Hearts";
    public final String CLUB = "Clubs";
    public final String DIAMOND = "Diamons";
    
   
    public String name;
    public int value;
    public String suit;
   
    public class Card
    {
      public Card(int num,int suitInt)
      {
         setCard(num,suitInt);
      }
      
      public String getSuit()
      {
         return suit;
      }
      
      public String getName()
      {
         return name;
      }
      public int getValue()
      {
        return value;
      }
   
      public void setCard(int num,int suitNum)
      {
        switch(num)
        {
            case 1:
                name = "ACE";
                value = 1;
                suit = convertSuit(suitNum);
                break;
            case 11:
                name = "J";
                value = 10;
                suit = convertSuit(suitNum);
                break;
            case 12:
                name = "Q";
                value = 10;
                suit = convertSuit(suitNum);
                break;
            case 13:
                name = "K";
                value = 10;
                suit = convertSuit(suitNum);
                break;
            default:
                name = "" + num;
                value = num;
                suit = convertSuit(suitNum);
                break;
       }//end switch statement
     }//end setCard method
     
     public String convertSuit(int suitNum)
     {
         switch(suitNum)
         {
            case 0:
               return SPADE;
            case 1:
               return HEART;
            case 2:
                 return DIAMOND;
             default:
                 return CLUB;               
          }
       }
     }//end Card class
  
   public static void main(String args[])
   {
       deck();
   }
   
    public static ArrayList<Card> halfDeck(int x)
    {
        ArrayList<Card> deck = new ArrayList<Card>();
       
        int LEN = 14;
         
        for(int i = 1;i < LEN; ++i)
        {
            Blackjack bj = new Blackjack();
            deck.add(bj.new Card(i,x));
        }
        
        return deck;
    }
    
    public static ArrayList<Card> deck()
    {
         ArrayList<Card> deck = new ArrayList<Card>();
         
         for(int i = 0; i < 4 ; ++i)
         {
            deck = deck(i);
         }
         
         
         print(deck);
         return deck;
    }
   
    
    public static void draw()
    {
      
    }
    
    
    public static void print(ArrayList<Card> cards)
    {
        int LEN = cards.size();
        for(int i = 0; i<LEN ; ++i)
        {
            print(cards.get(i));
        }
    }
   
   
    
    public static void print(Card card)
    {
        System.out.println(card.getName()); 
        System.out.println(card.getValue() + "");
        System.out.println(card.getSuit());
    }
   
   
}