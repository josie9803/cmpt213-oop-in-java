import java.awt.*;
import javax.swing.*;

/**
   This program animates a sort algorithm.
*/
public class SortAnimator extends JFrame
{
   public SortAnimator(Sorter s)
   {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      ArrayComponent panel = new ArrayComponent();
      add(panel, BorderLayout.CENTER);

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      setVisible(true);

      int[] values = new int[VALUES_LENGTH];
      for (int i = 0; i < values.length; i++)
         values[i] = (int) (Math.random() * panel.getHeight());

      s.setValues(values);
      s.setPanel(panel);
      Thread t = new Thread(s);
      t.start();
   }

   private static final int VALUES_LENGTH = 30;
   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 300;
}
