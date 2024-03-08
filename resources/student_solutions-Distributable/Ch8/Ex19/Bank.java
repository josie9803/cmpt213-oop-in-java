/**
   Simulation of customer traffic in a bank with a single queue and multiple 
   tellers.
*/
public class Bank extends Simulation
{
   /**
      Construct a Bank simulation
   */
   public Bank()
   {
      teller = new Customer[NUMBER_OF_TELLERS];
   }

   /**
      Initialize the bank simulation
   */
   public void initialize()
   {  
      schedule(new BankArrival(getNow()));
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
      Add a customer to the bank
      @param c the customer to add
   */
   public void add(Customer c)
   {  
      // Find an available teller
      for (int i = 0; i < NUMBER_OF_TELLERS; i++)
      {
         if (teller[i] == null)
         {  
            addToTeller(i, c);
            return;
         }
      }
      // No tellers available.  Put customer in queue
      custQueue.add(c);
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
      schedule(new BankDeparture(getNow() + t, i));
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

      if (custQueue.size() > 0)
         addToTeller(i, (Customer)custQueue.removeFirst());

      return c;
   }

   /**
      Print teller and queue
   */
   public void print() 
   {  
      for (int i = 0; i < NUMBER_OF_TELLERS; i++)
         System.out.print(teller[i] == null ? '.' : 'C');

      System.out.print( '<');

      int q = custQueue.size();

      for (int j = 1; j <= q; j++) 
         System.out.print('C');

      System.out.println();
   }

   private final double AVERAGE_PROCESSING_TIME = 5.0; // 5 minutes
   private static final int NUMBER_OF_TELLERS = 5;
   private static final int MAXIMUM_QUEUE_SIZE = 500;

   private Customer[] teller;
   private Statistics statistics = new Statistics();

   private Distribution distribution = new Exponential();

   private Queue custQueue = new Queue(MAXIMUM_QUEUE_SIZE);
}
