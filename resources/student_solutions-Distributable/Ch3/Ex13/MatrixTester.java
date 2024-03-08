/**
   A class for testing the Matrix class
*/
public class MatrixTester
{
   /**
      Creates and uses a Matrix object 
      @arg args unused
   */
   public static void main(String[] args)
   {
      Matrix a = new Matrix(3, 6);
      Matrix b = new Matrix(3, 6);

      for (int i = 0; i < 3; i++)
         for (int j = 0; j < 6; j++)
         {
            a.set(i, j, 10 * i + j);
            b.set(i, j, 20 * i + j);
         }

      System.out.println(a);
      System.out.println("-------------");
      System.out.println(b);
      System.out.println("-------------");
      System.out.println(a.plus(b));
      System.out.println("-------------");

      Matrix c = new Matrix(6, 3);
      Matrix d = new Matrix(3, 2);

      for (int i = 0; i < 6; i++)
         for (int j = 0; j < 3; j++)
            c.set(i, j, 10 * i + j);

      for (int i = 0; i < 3; i++)
         for (int j = 0; j < 2; j++)
            d.set(i, j, 10 * i + j);

      System.out.println(c);
      System.out.println("-------------");
      System.out.println(d);
      System.out.println("-------------");
      System.out.println(c.times(d));
   }
}
