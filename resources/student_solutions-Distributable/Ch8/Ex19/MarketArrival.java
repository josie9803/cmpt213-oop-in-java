/**
   Customer arrives at supermarket
*/
public class MarketArrival extends Event
{
   /**
      Construct an MarketArrival Event
      @param t the time at which the arrival will occur
   */
   public MarketArrival(double t)
   {
      super(t);
   }

   /** 
     Processes an arrival event
     @param s the Simulation generating the event
   */
   public void process(Simulation s)
   {   
      Market market = (Market) s;
      Customer c = new Customer(market.getNow());
      market.add(c);

      double t = random.get(INTER_ARRIVAL_TIME);
      market.schedule(new MarketArrival(market.getNow() + t));
   }

   private Distribution random = new Exponential();

   private static final double INTER_ARRIVAL_TIME = 1.0; // 1 minute
}
