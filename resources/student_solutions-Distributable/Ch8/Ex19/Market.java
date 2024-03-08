/**
   Simulation of customer traffic in a supermarket with multiple 
   queues and multiple tellers.
*/
public class Market extends Simulation
{
   /**
      Construct a Market object
   */
   public Market()
   {
      teller = new Customer[NUMBER_OF_TELLERS];

      for (int i = 0; i < NUMBER_OF_TELLERS; i++)
         queue[i] = new Queue(MAXIMUM_QUEUE_SIZE);
   }

   /**
      Initialize the supermarket simulation
   */
   public void initialize()
   {  
      schedule(new MarketArrival(getNow()));
   }

   /**
      Action that occurs after processing each event 
   */
   public void update()
   {  
      print();
   }

   /**
      Action that occurs after simulation ends
   */
   public void terminate()
   {  
      statistics.print();
   }

   /**
      Add a customer to the supermarket
      @param c the customer to add
   */
   public void add(Customer c)
   {  
      // Find an available teller 
      for (int i = 0; i < NUMBER_OF_TELLERS; i++)
      {
         if (teller[i] == null)
         {  addToTeller(i, c);
            return;
         }
      }

      // No available tellers; look for teller with smallest queue
      int smallestQueue = queue[0].size();
      int smallestQueueIndex = 0;
      for (int i = 1; i < NUMBER_OF_TELLERS; i++)
      {
         int size = queue[i].size();
         if (size < smallestQueue)
         {
            smallestQueue = size;
            smallestQueueIndex = i;
         }
      } 
      // No available tellers.  Put customer in smallest queue
      queue[smallestQueueIndex].add(c);
   }

   /** 
      Add a customer to an empty teller
      @param i the teller position
      @param c the customer to add
      @precondition teller[i] = null;
   */
   public void addToTeller(int i, Customer c)
   {  
      teller[i] = c;

      double t  = distribution.get(AVERAGE_PROCESSING_TIME);
      schedule(new MarketDeparture(getNow() + t, i));
   }

   /**
      Remove the customer from a teller
      @param i the position of the teller 
   */
   public Customer remove(int i)
   {  
      Customer c = teller[i];
      teller[i] = null;
      statistics.add(getNow() - c.getArrivalTime());

      if (queue[i].size() > 0)
         addToTeller(i, (Customer)queue[i].removeFirst());

      return c;
   }

   /**
      Print teller and queue
   */
   public void print() 
   {  
      System.out.println( "-------------------");
      for (int i = 0; i < NUMBER_OF_TELLERS; i++)
      {
         System.out.print(i + ":");
         System.out.print(teller[i] == null ? '.' : 'C');

         System.out.print( '<');

         int q = queue[i].size();
         for (int j = 1; j <= q; j++) 
            System.out.print('C');

         System.out.println();
      }
   }

   private final double AVERAGE_PROCESSING_TIME = 5.0; // 5 minutes
   private static final int NUMBER_OF_TELLERS = 5;
   private static final int MAXIMUM_QUEUE_SIZE = 500;

   private Customer[] teller;
   private Queue[] queue = new Queue[NUMBER_OF_TELLERS];

   private Statistics statistics = new Statistics();

   private Distribution distribution = new Exponential();
}
