/**
    This program shows how multiple threads can safely access a data structure.
*/

import java.util.concurrent.locks.*;

public class BankAccount
{
   /**
      Constructs a bank account with a zero balance
   */
   public BankAccount()
   {
      balance = 0;
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount) throws InterruptedException
   {
      bankLock.lock();
      try
      {
         System.out.print("Depositing " + amount);
         double newBalance = balance + amount;
         System.out.println(", new balance is " + newBalance);
         balance = newBalance;
         sufficientFunds.signalAll();
      }
      finally
      {
         bankLock.unlock();
      }
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount) throws InterruptedException
   {
      bankLock.lock();
      try
      {
         while (balance < amount)
            sufficientFunds.await();
         System.out.print("Withdrawing " + amount);
         double newBalance = balance - amount;
         System.out.println(", new balance is " + newBalance);
         balance = newBalance;
      }
      finally
      {
         bankLock.unlock();
      }
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {
      bankLock.lock();
      try
      {
         return balance;
      }
      finally
      {
         bankLock.unlock();
      }
   }
   
   private double balance;
   private Lock bankLock = new ReentrantLock();
   private Condition sufficientFunds = bankLock.newCondition();
}
