/**
  Customer arrives at bank
*/
public class BankArrival extends Event
{
   /**
     Construct an BankArrival Event
     @param t the time at which the arrival will occur
   */
   public BankArrival(double t)
   {
      super(t);
   }

   /** 
     Processes an arrival event
     @param s the Simulation generating the event
   */
   public void process(Simulation s)
   {   
      Bank bank = (Bank) s;
      Customer c = new Customer(bank.getNow());
      bank.add(c);

      double t = random.get(INTER_ARRIVAL_TIME);
      bank.schedule(new BankArrival(bank.getNow() + t));
   }

   private Distribution random = new Exponential();

   private static final double INTER_ARRIVAL_TIME = 1.0; // 1 minute
}
