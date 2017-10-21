   import java.io.*;

   public class DisplayQuote
   {
      public static void main(String[] args)
      {	
         try
         {
            File text = new File("Quote.txt");							// Which file to use.
            FileInputStream in = new FileInputStream(text);			// Open that file now!
         	
				int letter;
            while ((letter = in.read()) != -1) 							// Read each letter from the stream
            {
               System.out.print((char)letter);
            }
            
            in.close();															// Close the file.
         }
            catch (IOException exc)
            {
               System.out.println("Oops!  Can't display file.");
            }
      }
   }