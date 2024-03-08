import java.util.Random;

/**
   This program runs four threads that deposit and withdraw
   money from the same bank account. 
*/
public class BankAccountThreadTester
{
   public static void main(String[] args)
   {
      BankAccount account = new BankAccount();

      Runnable d0 = new DepositRunnable(account, 100);
      Runnable d1 = new WithdrawRunnable(account, 100);

      Runnable w0 = new DepositRunnable(account, 100);
      Runnable w1 = new WithdrawRunnable(account, 100);

      Thread t0 = new Thread(d0);
      Thread t1 = new Thread(d1);

      Thread t2 = new Thread(w0);
      Thread t3 = new Thread(w1);

      t0.start();
      t1.start();
      t2.start();
      t3.start();
   }
}

