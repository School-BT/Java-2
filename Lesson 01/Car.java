/*
Car
Object with make and model data fields
Ben Burger
9/25/2017
*/

public class Car
{
   String make;
   String model;
   
   public Car(String makeIn,String modelIn)
   {
      make = makeIn;
      model = modelIn;
   }
   
   void setMake(String str)
   {
      make = str;
   }
   
   void setModel(String str)
   {
      model = str;
   }
   
   String getMake()
   {
      return make;
   }
   
   String getModel()
   {
      return model;
   }
   
}