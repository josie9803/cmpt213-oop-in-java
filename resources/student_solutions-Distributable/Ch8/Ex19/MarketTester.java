/**
   A class for testing the supermarket simulation
*/
public class MarketTester
{
   /**
      Create and run a Market simulation for the specified time period.
      @param args unused
   */
   public static void main(String[] args)
   {  
      Market market = new Market();

      market.run(9 * 60, 17 * 60);
   }
}

