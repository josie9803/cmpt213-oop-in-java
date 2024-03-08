import java.util.Random;
import java.util.ArrayList;
import java.awt.Rectangle;


/**
   A class for testing the Measurer interface
*/
public class MeasurerTester
{
   /**
     Creates an ArrayList of Rectangles and sorts them using an instance of
     the Measurer interface
     @param args unused
   */
   public static void main(String[] args)
   {
      int count = 25;
      Random g = new Random();

      ArrayList<Rectangle> a = new ArrayList<Rectangle>();

      for (int i = 0; i < count; i++)
         a.add(new Rectangle(
                  g.nextInt(10),
                  g.nextInt(10),
                  g.nextInt(10),
                  g.nextInt(10)
                  ));
      for (Rectangle r : a)
         System.out.println(r);
      System.out.println();

      Measurer meas = new
         Measurer()
         {
            public double measure(Object x)
            {
               Rectangle r = (Rectangle) x;
               return r.width * r.height;
            }
         };

      Rectangle r = (Rectangle) maximum(a.toArray(), meas);
      System.out.println(r);
   }

   /**
     Finds the maximum object in the ArrayList, using the given measure
     @param a the ArrayList to search
     @param m the Measurer that defines the measure of the object
   */
   public static Object maximum(Object[] a, Measurer m)
   {
      int positionOfMax = 0;
      Object max = a[0];
      double maxMeasure = m.measure(max);

      for (int i = 1; i < a.length; i++)
      {
         Object toCheck = a[i];
         double measureToCheck = m.measure(toCheck);

         if (measureToCheck > maxMeasure)
         {
            positionOfMax = i;
            max = toCheck;
            maxMeasure = measureToCheck;
         }
      }

      return max;
   }
}
