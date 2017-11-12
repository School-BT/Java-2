/*
ZeroInputError
extends Exception to catch a dev by zero
Ben Burger
10/9/2017
*/

public class ZeroInputError extends Exception
{   
   public ZeroInputError()
   {
      super();
   }
   
   @Override
   public String getMessage()
   {
      return "Error! Can't divide by zero!";
   }
   
}