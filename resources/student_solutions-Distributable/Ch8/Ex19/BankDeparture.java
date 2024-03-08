/**
   Class for representing a Customer departing from a bank teller
*/
class BankDeparture extends Event
{
   /**
      Constructs a departure object
      @param t the time at which the departure will occur
      @param teller the teller's position
   */
   public BankDeparture(double t, int teller)
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
      Bank bank = (Bank) s;
      Customer c = bank.remove(teller);
   }

   private int teller;
}
