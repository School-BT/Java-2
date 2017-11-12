/*
CarDemo
Demonstrates Car, Camaro and SmartCar Objects
Ben Burger
9/25/2017
*/

public class CarDemo
{
   
   public static void main(String[] args)
   {
      Car car = new Car("Chevy","MonteCarlo");
      Camaro camaro = new Camaro(140);
      SmartCar smart = new SmartCar("Is always Charging");
      
      print("Car make: " + car.getMake());  
      print("Car model: " + car.getModel());
      print("");
      print("Camaro make: " + camaro.getMake());
      print("Camaro model: " + camaro.getModel());
      print("Camaro speed: " + camaro.getSpeed());
      print("");
      print("Smart Car make: " + smart.getMake());
      print("Smart Car model: " + smart.getModel());
      print("Smart Car isCharging: " + smart.getIsCharging());
      
   }
   
   public static void print(String str)
   {
      System.out.println("" + str);
   }
}