/**
   A class for testing the Bank simulation
*/
public class BankTester
{
   /**
      Create and run a Bank simulation for the specified time period.
      @param args unused
   */
   public static void main(String[] args)
   {  
      Bank bank = new Bank();

      bank.run(9 * 60, 17 * 60);
   }
}

