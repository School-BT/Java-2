import javax.swing.*;

public class VegetarianMenu extends Menu
{
   String[] vegEntreeChoice = {"Spinich Lasagna",
      "Cheese enchiladas","fuit plate"};
   
   public VegetarianMenu()
   {
      super();
      for(int x = 0; x<vegEntreeChoice.length; ++x)
      {
         entreeChoice[x] = vegEntreeChoice[x];
      }
   }
}