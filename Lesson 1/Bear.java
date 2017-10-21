/*
Bear
extends object Animal with isHibernating field
Ben Burger
9/25/2017
*/

public class Bear extends Animal
{
   String isHibernating;
   
   void setIsHibernating(String str)
   {
      isHibernating = str;
   }
   
   String getIsHibernating()
   {
      return isHibernating;
   }
}