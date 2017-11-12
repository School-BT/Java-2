/*
iPhone
iPhone class, impliments Phone interface
Ben Burger
9/28/2017
*/

public class iPhone implements Phone
{
   private String callStr;
   private String endStr;
   private String textStr;
   
   public iPhone()
   {
      callStr = "Call iPhone";
      endStr = "End iPhone";
      textStr = "Text iPhone";
   }
   
   @Override
   public void call(Person person)
   {
      print(callStr + " " + person.getNumber());
   }
   
   @Override
   public void end()
   {
      print(endStr);
   }
   
   @Override
   public void text()
   {
      print(textStr);
   }
   
   public void print(String str)
   {
      System.out.println(str);
   }
}