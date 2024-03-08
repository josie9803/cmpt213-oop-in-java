/**
   A class for testing the clone method for the Employee with buddies class.
*/
public class EmployeeTester
{
   /**
      Create and clone some Employee and Manager objects that have buddies
      @param args unused
   */
   public static void main(String[] args)
   {
      Employee e1 = new Employee("Jack");
      Employee e2 = new Employee("Jill");
      Employee e3 = new Employee("Joe");

      Manager m1 = new Manager("Mack");
      Manager m2 = new Manager("Mill");
      Manager m3 = new Manager("Moe");

      e1.setSalary(1000);
      e2.setSalary(2000);
      e3.setSalary(3000);

      m1.setSalary(1111);
      m2.setSalary(2222);
      m3.setSalary(3333);

      m1.setBonus(100);
      m2.setBonus(200);
      m3.setBonus(300);

      m1.setBuddy(e1);
      e1.setBuddy(m2);
      m2.setBuddy(e2);
      e2.setBuddy(m3);
      m3.setBuddy(m1);

      Employee cloned = (Employee) m1.clone();

      // Conditions clone should fulfill
      System.out.println(cloned != m1);
      System.out.println(cloned.equals(m1));
      System.out.println(cloned.getClass() == m1.getClass());

      System.out.println(m1.toString().equals(cloned.toString()));

      System.out.println(m1.hashCode());
      System.out.println(cloned.hashCode());
   }
}
