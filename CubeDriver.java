
import javax.swing.JFrame; 
/**
 * Frame of the Instant Insanity Solver.
 * Sets specifics of the frame.
 * @author Rachel Naidich
 */
public class CubeDriver 
{
   public static JFrame frame;
    /**
    * Creates Instant Insanity JFrame and sets specifics like size and location.
    */
   public static void main(String[] args)
   {
      frame = new JFrame("Instant Insanity");
      frame.setSize(500,500); 
      frame.setLocation(100,50); 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      frame.setContentPane(new StartPanel()); 
      frame.setVisible(true); 
   }
}