/**
   A class for gathering simulation statistics to compute averages
*/
public class Statistics
{
   /**
      Construct an object for gathering simulation statistics to 
      compute averages.
   */
   public Statistics()
   {
      numberOfCustomers = 0;
      totalTime = 0;
   }

   /** 
      Adds a customer who is leaving to the statistics
      @param t the time the customer left
   */
   public void add(double t)
   {  
      numberOfCustomers++;
      totalTime += t;
   }


   /**
      Returns the average time the customers spent waiting and being served
      @return the average time the customers spent waiting and being served
   */
   public double average_time() 
   {  
      if (numberOfCustomers == 0) 
         return 0;
      else 
         return totalTime / numberOfCustomers;
   }


   /**
      Prints a summary of the gathered statistics
   */
   public void print() 
   {  
      System.out.println( numberOfCustomers
         +  " customers. Average time "
         +  average_time() +  " minutes." );
   }

   private int numberOfCustomers;
   private double totalTime;
}
