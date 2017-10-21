/*
Vehicle
Ch6ExampleONE start pg542
*/

//  ***abstract***
public abstract class Vehicle
{
   private String powerSource;
   private int wheels;
   protected int price;
   
   public Vehicle(String powerSource,int wheels)
   {
      setPowerSource(powerSource);
      setWheels(wheels);
      setPrice();
   }
   
   public String getPowerSource()
   {
      return powerSource;
   }
   
   public int getWheels()
   {
      return wheels;
   }
   
   public int getPrice()
   {
      return price;
   }
   
   public void setPowerSource(String source)
   {
      powerSource = source;
   }
   
   public void setWheels(int wls)
   {
      wheels = wls;
   }
   
//This is abstract
   public abstract void setPrice();
}