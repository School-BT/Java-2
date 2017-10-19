/*
Blackjack
allows user to play the game blackjack
Ben Burger
10/18/2017
*/


public class Blackjack
{    
    public static int[] hearts = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    public static int[] clubs = {1,2,3,4,5,6,7,8,9,10,11,12,13};  
    public static int[] diamonds = {1,2,3,4,5,6,7,8,9,10,11,12,13};    
    public static int[] spades = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    
    
    
    public static void main(String[] args)
    {
        for(int i = 0;i < 13;++i)
        {
            print(nameReturn(i+1));
        }
    }
    
    
    public static String nameReturn(int num)
    {
        switch(num)
        {
            case 1:
                return "ace";
                break;
            case 11:
                return "Jack";
                break;
            case 12:
                return "Queen";
                break;
            case 13:
                return "King";
                break;
        }
    }
    
    
    public static void print(String str)
    {
        System.out.print(str);
    }
}
