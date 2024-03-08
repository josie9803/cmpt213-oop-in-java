/**
   An algorithm for animating the lowly bubble sort
*/
public class BubbleSorter extends Sorter
{
   public void sort(int[] values)
   {
      for (int i = 0; i < values.length; i++)
      {
         for (int j = 0; j < values.length - 1; j++)
         {
            pause(j, j + 1);
            if (values[j] > values[j + 1])
               swap(j, j + 1);
         } 
      } 
   }
}
