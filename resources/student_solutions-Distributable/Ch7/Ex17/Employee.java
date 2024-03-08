import java.util.ArrayList;

/**
  A class for modeling Employees that have buddy field
*/
public class Employee implements Cloneable
{
   /**
      Constructs an Employee object
      @param aName the employee's name
   */
   public Employee(String aName)
   {
      name = aName;
   }

   /**
      Returns a String representing the Employee
      @return the Employee as a String
   */
   public String toString()
   {
      return toStringHelper(new ArrayList<Employee>());
   }

   /*
      Recursive helper that uses a list of already visited Employees to know
      when to end the recursion.  Must be overridden.
      @return the Employee as a String
   */
   protected String toStringHelper(ArrayList<Employee> visited)
   {
      String buddyString="";
      if (visited.contains(this))
      {
         buddyString = "...";
      }
      else
      {
         visited.add(this);
         if (buddy!=null)
            buddyString = buddy.toStringHelper(visited);
      }

      return getClass().getName()
         + "[name=" + name
         + ",salary=" + salary
         + ",buddy=" + buddyString
         + "]";
   }

   /**
      Returns whether this Employee is identical to another
      @return whether this Employee is identical to another
      @param otherObject the other Employee
   */
   public boolean equals(Employee otherObject)
   {
      return equalsHelper(otherObject, new ArrayList<Pair>());
   }

   /*
      Checks if two Employees have equal fields and recursively checks
      if the buddies are equal and not yet compared.
   */
   protected boolean equalsHelper(Employee otherObject, ArrayList<Pair> visited)
   {
      if (this == otherObject) return true;
      if (null == otherObject) return false;
      if (getClass() != otherObject.getClass()) return false;

      Employee otherEmployee = otherObject;
      if (!name.equals(otherEmployee.name) || salary != otherEmployee.salary)
         return false;

      if (this.buddy == null || otherEmployee.buddy == null)
         return this.buddy == otherEmployee.buddy;

      if (visited.contains(new Pair(this, otherEmployee))) return true;

      visited.add(new Pair(this, otherEmployee));

      return this.buddy.equalsHelper(otherEmployee.buddy, visited);
   }

   /**
      Returns the hash code of this Employee
      @return the hash code of this Employee
   */
   public int hashCode()
   {
      return hashCodeHelper(0, new ArrayList<Employee>());
   }

   /*
      Mutually recursive helper function for finding hash codes.
      Parameter code is the hash code of the Employees visited so far.
      Parameter visited is an ArrayList of the Employees visited so far.
   */
   protected int hashCodeHelper(int code, ArrayList<Employee> visited)
   {
      if (visited.contains(this)) return code;

      code = 31 * code
            + (11 * name.hashCode() + 15 * new Double(salary).hashCode());

      visited.add(this);
      return hashCodeHelper(code, visited);
   }


   /**
      Sets the buddy
      @param the new buddy
   */
   public void setBuddy(Employee aBuddy)
   {
      buddy = aBuddy;
   }

   /**
      Returns the employee's buddy
      @return the buddy
   */
   public Employee getBuddy() throws CloneNotSupportedException
   {
      return (Employee) buddy.clone();
   }

   /**
      Sets the salary
      @param the new salary
   */
   public void setSalary(double aSalary)
   {
      salary = aSalary;
   }

   /**
      Returns the employee's name
      @return the name
   */
   public String getName()
   {
      return name;
   }

   /**
      Returns the employee's salary
      @return the salary
   */
   public double getSalary()
   {
      return salary;
   }

   /*
      A class that allows us to maintain a list of pairs of Employees that
      have already been compared for equality.
   */
   protected class Pair{
      Pair(Employee e1, Employee e2)
      {
         this.e1 = e1;
         this.e2 = e2;
      }

      public boolean equals(Object other)
      {
         if (other == null) return false;
         Pair p =  (Pair) other;
         return this.e1 == p.e1 && this.e2 == p.e2;
      }

      private Employee e1;
      private Employee e2;
   }

   private String name;
   private double salary;

   private Employee buddy;
}
