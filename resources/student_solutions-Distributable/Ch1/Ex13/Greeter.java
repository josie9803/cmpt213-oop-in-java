/**
   A class for producing simple greetings. (Revised to include methods
   from section 1.6)
*/
public class Greeter
{
   /**
      Constructs a Greeter object that can greet a person or 
      entity.
      @param aName the name of the person or entity who should
      be addressed in the greetings.
   */
   public Greeter(String aName)
   {
      name = aName;
   }

   /**
      Greet with a "Hello" message.
      @return a message containing "Hello" and the name of
      the greeted person or entity.
   */
   public String sayHello()
   {
      return "Hello, " + name + "!";
   }

   /**
      Sets theis greeter's name to the given name.
      @param name the new name for the object
   */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
      Sets another greeter's name to this Greeter's name.
      @param other a reference to the other Greeter
   */
   public void copyNameTo(Greeter other)
   {
      other.name = this.name;
   }

   /**
      Tries to copy the length of this greeter's name into an integer variable
      @param n the the variable into which the method tries to copy the length
   */
   public void copyLengthTo(int n)
   {
      n = name.length();
   }

   /**
      Tries to set another Greeter object to a copy of this object
      @param other the Greeter object to initialize
   */
   public void copyGreeterTo(Greeter other)
   {
      other = new Greeter(name);
   }


   private String name;
}
