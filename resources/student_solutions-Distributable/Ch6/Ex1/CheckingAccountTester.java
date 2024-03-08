/**
   Tests the CheckingAccount class
*/
public class CheckingAccountTester
{
   /**
     Creates and uses a CheckingAccount 
    */
   public static void main(String[] args)
   {
      CheckingAccount account = new CheckingAccount(1000);

      for (int i = 0; i < 10; i++)
      {
         account.deposit(20);
         account.withdraw(10);
      } 

      System.out.println(account.getBalance());
      account.deductFees();
      System.out.println(account.getBalance());
      account.deductFees();
      System.out.println(account.getBalance());
   } 
}
