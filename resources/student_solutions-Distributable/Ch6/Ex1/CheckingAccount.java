/**
   A class for modeling checking accounts
*/
public class CheckingAccount extends BankAccount
{

   /**
     Constructs an account with a specified balance
     @arg initialBalance the starting balance for the account
   */
   public CheckingAccount(double initialBalance)
   {
      super.deposit(initialBalance);

   }

   /**
     Adds an amount to the account's balance
     @arg amount the amount to add
   */
   public void deposit(double amount)
   {
      super.deposit(amount);
      transactionsThisMonth++;
   }

   /**
     Subtracts an amount to the account's balance
     @arg amount the amount to subtract
   */
   public void withdraw(double amount)
   {
      super.withdraw(amount);
      transactionsThisMonth++;
   }

   /**
     Deducts fees from an account's balance
   */
   public void deductFees()
   {
      if (transactionsThisMonth > FREE_TRANSACTIONS_PER_MONTH)
         super.withdraw((transactionsThisMonth - FREE_TRANSACTIONS_PER_MONTH) 
               * TRANSACTION_COST);
      transactionsThisMonth = 0;
   }

   private static final int FREE_TRANSACTIONS_PER_MONTH = 5;
   private static final double TRANSACTION_COST = 1.0;

   private static int transactionsThisMonth;
}
