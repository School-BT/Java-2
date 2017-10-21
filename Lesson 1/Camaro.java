/*
Camaro
Extends Car object with speed field
Ben Burger
9/25/2017
*/

public class Camaro extends Car
{
   int speed;
   
   public Camaro(int speedIn)
   {
      super("Chevy","Camaro");
      speed = speedIn;
   }
   
   void setSpeed(int num)
   {
      speed = num;
   }
   
   int getSpeed()
   {
      return speed;
   }
}