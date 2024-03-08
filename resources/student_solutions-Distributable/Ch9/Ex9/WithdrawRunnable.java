/**
   A withdraw Runnable that makes periodic withdrawals from a bank account.
*/
class WithdrawRunnable implements Runnable
{
   /**
      Constructs a withdraw thread.
      @param anAccount the account from which to withdraw money
      @anAmount the amount to withdraw in each repetition
   */
   public WithdrawRunnable(BankAccount anAccount, double anAmount)
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
            account.withdraw(amount);
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

