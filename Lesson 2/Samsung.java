/*
Samsung
Samsung class, impliments Phone interface
Ben Burger
9/28/2017
*/

public class Samsung implements Phone
{
   private String callStr;
   private String endStr;
   private String textStr;
   
   public Samsung()
   {
      callStr = "Call Samsung";
      endStr = "End Samsung";
      textStr = "Text Samsung";
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