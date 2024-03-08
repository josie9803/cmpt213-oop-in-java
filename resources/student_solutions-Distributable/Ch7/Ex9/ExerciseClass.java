import java.lang.reflect.*;
import java.util.*;

/**
   This program uses reflection to allow the user to create an instance
   of any class and to execute the methods of that class.
*/
public class ExerciseClass
{
   /**
     Creates an instance of a class specified by the user and invokes the
     methods specified by the user.
     @param args unused
   */
   public static void main(String[] args) throws NoSuchMethodException,
         IllegalAccessException, InvocationTargetException,
         ClassNotFoundException, InstantiationException
   {
      Scanner sc = new Scanner(System.in);
      String constructorString = "";
      Class theClass = null;
      Object theInstance = null;

      while (theInstance == null)
      {
         try
         {
            System.out.print("Construct object (blank line to quit): ");

            constructorString = sc.nextLine();

            if (constructorString.equals(""))
               break;

            StringTokenizer t = new StringTokenizer(constructorString);

            theClass = Class.forName(t.nextToken());

            theInstance = getInstance(theClass, t);
         }
         catch (Exception e)
         {
            System.out.println("Could not construct instance using "
                  + constructorString);
            System.out.println("Exception occurred: " + e);
         }
      }

      String methodString = "";
      while (true)
      {
         try
         {
            System.out.print("Invoke method (blank line to quit): ");

            methodString = sc.nextLine();

            if (methodString.equals("")) break;

            Object resultObject = getResult(
                  theClass, theInstance, methodString);

            System.out.println(resultObject);
         }
         catch (Exception e)
         {
            System.out.println("Could not invoke method using "
                  + methodString);
            System.out.println("Exception occurred: " + e);
         }
      }
   }


   // Create an instance of the specified class using the arguments
   // specifed in the tokenizer t
   static private Object getInstance(Class theClass, StringTokenizer t)
      throws InstantiationException, IllegalAccessException,
             InvocationTargetException
   {
      int numArgs = t.countTokens();

      Constructor[] conList = theClass.getConstructors();

      Constructor theConstructor = null;
      Class[] consParamTypes = null;

      int numMatches = 0;

      for (Constructor c : conList)
      {
         if (c.getParameterTypes().length == numArgs)
         {
            theConstructor = c;
            consParamTypes = theConstructor.getParameterTypes();
            numMatches++;
         }
      }

      if (numMatches != 1)
         throw new IllegalArgumentException( "Error: there are "
               + numMatches + "constructors with " + numArgs + "parameters");

      Object[] consParams = createParamList(t, consParamTypes);

      return theConstructor.newInstance(consParams);
   }

   // Use a tokenizer to create a parameter list that matches a list of types
   private static Object[] createParamList(
         StringTokenizer t, Class[] paramTypeList)
   {
      int numArgs = paramTypeList.length;
      Object[] params = new Object[numArgs];

      int j=0;
      for (Class p : paramTypeList)
      {
         Class paramType = p;
         String token = t.nextToken();
         if (paramType == byte.class)
            params[j++] = Byte.valueOf(token);

         else if (paramType == short.class)
            params[j++] = Short.valueOf(token);

         else if (paramType == int.class)
            params[j++] = Integer.valueOf(token);

         else if (paramType == long.class)
            params[j++] = Long.valueOf(token);

         else if (paramType == float.class)
            params[j++] = Float.valueOf(token);

         else if (paramType == double.class)
            params[j++] = Double.valueOf(token);

         else if (paramType == boolean.class)
            params[j++] = Boolean.valueOf(token);

         else if (paramType == String.class)
            params[j++] = token;

         else if (token.equals("null"))
            params[j++] = null;

         else
            throw new IllegalArgumentException(
                  "Object parameter can only be null");

      }
      return params;
   }

   // Invoke a method and return the result object
   static private Object getResult(
         Class theClass, Object theInstance, String methodString)
      throws InvocationTargetException, IllegalAccessException
   {
      StringTokenizer t = new StringTokenizer(methodString);

      String methodName = t.nextToken();

      int numArgs = t.countTokens();

      Method theMethod = null;

      Method[] methodList = theClass.getMethods();

      Class[] methodParamTypes = null;

      int numMatches = 0;

      for (Method m : methodList)
      {
         if (m.getName().equals(methodName))
         {
            theMethod = m;
            methodParamTypes = theMethod.getParameterTypes();
            numMatches++;
         }
      }

      if (numMatches != 1)
      {
         throw new IllegalArgumentException("Error: there are "
               + numMatches + " methods with name " + methodName);
      }

      Object[] methodParams = createParamList(t, methodParamTypes);

      Object theResult = null;
      theResult = theMethod.invoke(theInstance, methodParams);

      return theResult;
   }
}
