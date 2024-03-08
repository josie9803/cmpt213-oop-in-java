/**
   This class sorts an array, using the selection sort algorithm
*/
public class SelectionSorter extends Sorter
{
   /**
      Sorts the array managed by this selection sorter.
   */
   public void sort(int[] values)
   {  
      for (int i = 0; i < values.length - 1; i++)
      {  
         int minPos = i;
         for (int j = i + 1; j < values.length; j++)
         {
            if (values[j] < values[minPos]) 
               minPos = j;
            pause(minPos, j);
         }
         pause(minPos, i);
         swap(minPos, i);
      }
   }
}
