/*
Shark
extends Animal class with isInWater field
Ben Burger
9/25/2017
*/

public class Shark extends Animal
{
   String isInWater;
   
   void setIsInWater(String str)
   {
      isInWater = str;
   }
   
   String getIsInWater()
   {
      return isInWater;
   }
}