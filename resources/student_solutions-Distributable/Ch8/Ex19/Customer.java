/** 
   A simulation customer
*/
public class Customer
{
      /** 
         Construct a customer who arrives at a particular time
         @param t the time at which the customer entered the simulation
      */
      public Customer(double t)
      {
         arrivalTime = t;
      }

      /**
         @return the time at which the customer entered the simulation
      */
      public double getArrivalTime() 
      {  
         return arrivalTime;
      }

   private double arrivalTime;
}
