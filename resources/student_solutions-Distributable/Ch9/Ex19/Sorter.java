import java.util.*;

/**
   This runnable executes a sort algorithm.
   When two elements are compared, the algorithm
   pauses and updates a panel.
*/
public abstract class Sorter implements Runnable
{
   /**
      Sets the values for this sorter.
      @param values the array to sort
   */
   public void setValues(int[] values)
   {
      this.values = values;
   }

   /**
      Sets the panel for this sorter.
      @param panel the panel for showing the sort animiation
   */
   public void setPanel(ArrayComponent panel)
   {
      this.panel = panel;
   }


   /**
      Sorts the array managed by this Sorter.
   */
   public abstract void sort(int[] values);

   /**
      Either waits for the gate to open or sleeps, depending on the 
      current state of the gate.  Then displays the current state of the sort.
   */
   public void pause(int marked1, int marked2)
   {
      panel.setValues(values, marked1, marked2);
      try
      {
         Thread.sleep(DELAY);
      }
      catch (InterruptedException exception)
      {
         Thread.currentThread().interrupt();
      }
   }

   public void swap(int i, int j)
   {
      int temp = values[i];
      values[i] = values[j];
      values[j] = temp;
   }

   public void run()
   {
      sort(values);
   }

   private int[] values;
   private ArrayComponent panel;
   private static final int DELAY = 100;
}
