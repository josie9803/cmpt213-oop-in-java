/**
   A class for (not very exhaustive) testing of the methods toString, 
   equals, and hashCode for the Employee and Manager classes that have
   buddy field.
*/
public class EmployeeTester
{
   /**
      Create a and use some Employee and Manager objects that have 
      a cycle in the buddy fields.
      @param args unused
   */
   public static void main(String[] args) throws CloneNotSupportedException
   {
      Employee e1 = new Employee("Jack");
      Employee e2 = new Employee("Jill");
      Employee e3 = new Employee("Joe");

      e1.setSalary(1000);
      e2.setSalary(2000);
      e3.setSalary(3000);

      Manager m1 = new Manager("mack");
      Manager m2 = new Manager("mill");
      Manager m3 = new Manager("moe");

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
      m3.setBuddy(e3);
      e3.setBuddy(m2);

      Employee f1 = new Employee("Jack");
      Employee f2 = new Employee("Jill");
      Employee f3 = new Employee("Joe");

      f1.setSalary(1000);
      f2.setSalary(2000);
      f3.setSalary(3000);

      Manager n1 = new Manager("mack");
      Manager n2 = new Manager("mill");
      Manager n3 = new Manager("moe");

      n1.setSalary(1111);
      n2.setSalary(2222);
      n3.setSalary(3333);

      n1.setBonus(100);
      n2.setBonus(200);
      n3.setBonus(300);

      n1.setBuddy(f1);
      f1.setBuddy(n2);
      n2.setBuddy(f2);
      f2.setBuddy(n3);
      n3.setBuddy(f3);
      f3.setBuddy(n2);

      System.out.println(m1.equals(n1));

      System.out.println(m1.hashCode());
      System.out.println(n1.hashCode() + "\n");
      
      System.out.println(m2.hashCode());
      System.out.println(n2.hashCode() + "\n");

      Employee c1 = m1.getBuddy();
      System.out.println(c1.hashCode());
      System.out.println(e1.hashCode() + "\n");

      System.out.println(m1 + "\n");
      System.out.println(c1 + "\n");
      System.out.println(e1);
   }
}
