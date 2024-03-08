/**
   A class for producing simple greetings. (Revised to include setName)
*/
public class Greeter
{
   /**
      Constructs a Greeter object that can greet a person or entity.
      @param aName the name of the person or entity who should
      be addressed in the greetings.
   */
   public Greeter(String aName)
   {
      name = aName;
   }

   /**
      Change the name of this Greeter object
      @param newName the new name for this Greeter object
   */
   public void setName(String newName)
   {
      name = newName;
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

   private String name;
}
