/**
   A class for modeling bank accounts
*/
public class BankAccount
{

   /**
     Adds an amount to the account's balance
     @arg amount the amount to add
   */
   public void deposit(double amount)
   {
      balance += amount;
   }

   /**
     Subtracts an amount to the account's balance
     @arg amount the amount to subtract
   */
   public void withdraw(double amount)
   {
      balance -= amount;
   }

   /**
     Returns an account's balance
     @return the account's balance
   */
   public double getBalance()
   {
      return balance;
   }

   private double balance;
}
