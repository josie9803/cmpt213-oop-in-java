import java.awt.event.*;
import java.util.Date;
import javax.swing.Timer;

/**
   This program shows a clock that is updated once per second.
*/
public class TimerTester
{
   public static void main(String[] args) throws InterruptedException
   {
      ActionListener listener = new 
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               Date now = new Date();
               System.out.println(now.toString());
            }
         };

      final int DELAY = 1000; 
         // milliseconds between timer ticks
        
      Timer t = new Timer(DELAY, listener);
      t.start();

      // Wait until the time has ticked 10 or so times
      Thread.sleep(10*DELAY);
   }
}
