import java.util.Random;

/**
   This program runs two threads that deposit and withdraw
   money from the same bank account. 
*/
public class BankAccountThreadTester
{
   /**
      Creates and runs threads for depositing and withdrawing to and from a 
      bank account.
      @param args unused
   */
   public static void main(String[] args)
   {
      BankAccount account = new BankAccount();

      DepositRunnable r0 = new DepositRunnable(account, 100);
      WithdrawRunnable r1 = new WithdrawRunnable(account, 100);

      Thread t0 = new Thread(r0);
      Thread t1 = new Thread(r1);

      t0.start();
      t1.start();
   }
}

