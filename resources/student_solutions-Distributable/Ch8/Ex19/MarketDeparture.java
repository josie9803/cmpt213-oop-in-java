/**
   Class for representing a Customer departing from a supermarket teller
*/
class MarketDeparture extends Event
{
   /**
      Constructs a departure object
      @param t the time at which the departure will occur
      @param teller the teller's position
   */
   public MarketDeparture(double t, int teller)
   {
      super(t); 
      this.teller = teller;
   }

   /* 
      Processes a departure event
      @param s the simulation generating the event
   */
   public void process(Simulation s)
   {  
      Market market = (Market) s;
      Customer c = market.remove(teller);
   }

   private int teller;
}
