import java.util.*;

/**
   A class for storing and operating on sparse two dimensional matrices.
   Note: For simplicity, we use an ArrayList<Entry>. A HashSet
   or TreeSet would be more efficient, but these aren't covered until ch. 8.
*/
public class Matrix
{
   /**
      Construct a Matrix object
      @arg rows the number of rows in the matrix
   */
   public Matrix(int rows, int cols)
   {
      if (rows <= 0 || cols <= 0)
         throw new IllegalArgumentException("Can not construct this matrix");

      this.rows = rows;
      this.cols = cols;
      entries = new ArrayList<Entry>();
   }

   /**
      Get the number of rows in this matrix
      @return the number of rows in the matrix
   */
   public double getRows()
   {
      return rows;
   }

   /**
      Get the number of columns in this matrix
      @return the number of columns in the matrix
   */
   public double getCols()
   {
      return cols;
   }

   /**
      Get the value of a particular element from this matrix
      @arg r the row of the element to get
      @arg c the column of the element to get
      @return the value of the specified element from the matrix
   */
   public double get(int r, int c)
   {
      for (Entry e : entries)
      {
         if (e.getRow() == r && e.getColumn() == c)
            return e.getValue();
      }
      if (r == c)
         return 1.0;
      else
         return 0.0;
   }

   /**
      Set the value of a particular element from this matrix
      @arg r the row of the element to get
      @arg c the column of the element to get
      @arg v the value to store in the specified location
   */
   public void set(int r, int c, double v)
   {
      for (Entry e : entries)
      {
         if (e.getRow() == r && e.getColumn() == c)
         {
            if (r == c && v == 1 || r != c && v == 0)
               entries.remove(e);
            else
               e.setValue(v);
            return;
         }
      }
      entries.add(new Entry(r, c, v));
   }

   public String toString()
   {
      String r = "";
      for (int i = 0; i < rows; i++)
      {
         r += "[";
         for (int j = 0; j < cols; j++)
            r += String.format("%10.2f ", get(i, j));
         r += "]\n";
      }
      return r;
   }

   /**
      Add this matrix to another
      @arg other the matrix to add to this one
      @return a matrix containing the sum of the two matrices
   */
   public Matrix plus(Matrix other)
   {
      if (other == null || rows != other.rows || cols != other.cols)
      {
         throw new IllegalArgumentException("Matrix is null");
      }

      Matrix result = new Matrix(rows, cols);

      for (int i = 0; i < rows; i++)
         for (int j = 0; j < cols; j++)
            result.set(i, j, get(i, j) + other.get(i, j));
      return result;
   }

   /**
      Multiply this matrix by another
      @arg other the matrix to muliply by this
      @return a matrix containing the product of the two matrices
   */
   public Matrix times(Matrix other)
   {
      if (other == null || cols != other.rows)
      {
         throw new IllegalArgumentException("Cannot multiply these matrices");
      }

      Matrix result = new Matrix(rows, other.cols);
      for (int i = 0; i < rows; i++)
         for (int j = 0; j < other.cols; j++)
         {
            double temp = 0;
            for (int k = 0; k < cols; k++)
               temp = temp + get(i, k) * other.get(k,j);
            result.set(i, j, temp);
         }

      return result;
   }

   private ArrayList<Entry> entries;
   private int rows;
   private int cols;
}
