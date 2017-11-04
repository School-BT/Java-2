public class MyClass {
    
    public static int[] user = new int[31];
    public static int[] comp = new int[31];

    public static int[] userL = {1,2,3,4,5,6};
    public static int[] compL = {1,2,3,5,6,7};
    
    public static void main(String args[]) {
     
        init(user);
        init(comp);
	buildComp();
	buildUser();
	buildCount(userL,user);
	buildCount(compL,comp);
        compareCount(user,comp);
        System.out.println("" + count);
    }
    
    public static void init(int[] uco)
    {
        for(int i = 0; i < 31;++i)
        {
            uco[i] = 0;
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

   public static void buildCount(int[] userComp,int[] count)

   {
       for(int i = 0; i < 6; ++i)
        
       { 
            
    	   for(int x = 0;x < 31; ++x)
            
 	   {  
                
		if(userComp[i] == x)
                
		{	
                    
		   count[x] += 1;
                
                }
            
           }
        
       }
    
   }

   public static void buildComp()
   {
	Random ran = new Random();

	for(int i = 0; i < 6; ++i)
	{
	   int rand = ran.nextInt(31);
	   comp[i] = rand;
	}
   }

   public static void buildUser()
   {
	user[0] = getUser(g1);
	user[1] = getUser(g2);
	user[2] = getUser(g3);
	user[3] = getUser(g4);
	user[4] = getUser(g5);
	user[5] = getUser(g6);
   }

   public static int getUser(ButtonGroup group)
   {
	String string = group.getSelection();
	int num = Integer.parseInt(string);
	return num;
   }
   
}

