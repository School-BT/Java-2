import javax.swing.*;

public class CreateJFrameWithComponents
{
   public static void main(String[] args)
   {
      JFrameWithComponents aFrame = new JFrameWithComponents();
      final int width = 350;
      final int height = 100;
      aFrame.setSize(width,height);
      aFrame.setVisible(true);
   }
}