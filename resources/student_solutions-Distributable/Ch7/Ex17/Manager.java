import java.util.ArrayList;
/**
  A class for modeling Employees who are Managers.  Each Employee has a buddy.
*/
public class Manager extends Employee
{
   /**
      Constructs a Manager object
      @param aName the employee's name
   */
   public Manager(String aName)
   {
      super(aName);
      bonus = 0;
   }

   /*
      Mutually recursive helper that adds a Manager's information to
      the string returned by the superclass version of the method.
   */
   protected String toStringHelper(ArrayList<Employee> visited)
   {
      return super.toStringHelper(visited)
         + "[bonus=" + bonus
         + "]";
   }

   /*
      Checks if two Managers have equal bonus fields and calls the
      mutually recursive overridden version in the superclass to check the
      Employee fields, including the buddies,  and to check if this pair
      is on the list of pairs that have already been compared.
      Returns whether the two Managers are equal.
   */
   protected boolean equalsHelper(Employee otherEmployee, ArrayList<Employee.Pair> visited)
   {
      if (otherEmployee == this) return true;
      if (otherEmployee == null) return false;
      if (getClass() != otherEmployee.getClass()) return false;

      Manager otherManager = (Manager) otherEmployee;
      if (bonus != otherManager.bonus) return false;

      return super.equalsHelper(otherManager, visited);
   }

   /*
      Mutually recursive helper method that adds the bonus portion to the
      hash code of the Manager.
      Returns the hash code of this Manager.
   */
   protected int hashCodeHelper(int code, ArrayList<Employee> visited)
   {
      return 17 * super.hashCodeHelper(code, visited)
         + 19 * new Double(bonus).hashCode();
   }

   /**
      Sets the bonus
      @param the new bonus
   */
   public void setBonus(double aBonus)
   {
      bonus = aBonus;
   }

   /**
      Returns the manager's salary
      @return the salary
   */
   public double getSalary()
   {
      return super.getSalary() + bonus;
   }

   private double bonus;
}
