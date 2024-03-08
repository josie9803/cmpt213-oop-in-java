/**
   A deposit Runnable that makes periodic deposits to a bank account.
*/
class DepositRunnable implements Runnable
{
   /**
      Constructs a runnable that does deposits the amount in the account
      @param anAccount the account into which to deposit money
      @anAmount the amount to deposit in each repetition
   */
   public DepositRunnable(BankAccount anAccount, double anAmount)
   {
      account = anAccount;
      amount = anAmount;
   }

   public void run()
   {
      try
      {
         for (int i = 1; i <= REPETITIONS; i++)
         {
            account.deposit(amount);
            Thread.sleep(DELAY);         
         }
      }
      catch (InterruptedException exception)
      {
      }
   }

   private BankAccount account;
   private double amount;

   private static final int REPETITIONS = 10;
   private static final int DELAY = 10;
}

