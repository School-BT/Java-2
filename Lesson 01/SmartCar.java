/*
SmartCar
extends Car object with isCharging field
Ben Burger
9/25/2017
*/

public class SmartCar extends Car
{
   String isCharging;
   
   public SmartCar(String isChar)
   {
      super("Smart","Electric");
      isCharging = isChar;
   }
   
   void setIsCharging(String str)
   {
      isCharging = str;
   }
   
   String getIsCharging()
   {
      return isCharging;
   }
}