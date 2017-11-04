public class MyClass {
    
    public static int[] user = new int[31];
    public static int[] comp = new int[31];
    
    public static void main(String args[]) {
     
        init(user);
        init(comp);
        compareCount(user,comp);
        System.out.println("" + count);
    }
    
    public static void init(int[] uco)
    {
        for(int i = 0; i < 31;++i)
        {
            uco[i] = 1;
        }
    }
    
    public static int count;
    public static void compareCount(int[] countUser,int[] countComp)
    {
        for(int t = 0;t < 31;++t)
        {
            int x = countUser[t];
            int i = countComp[t];
            
            while(x > 0 && i > 0)
            {
                ++count;
                --x;
                --i;
            }
        
        }
    }
}

