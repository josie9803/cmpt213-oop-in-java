import java.lang.reflect.*;

/**
   This class contains method dumpClass which uses reflection to
   access information about a class.
*/
public class Dumper
{
   /**
     This method uses reflection to allow the user to find out information
     about a class.
     @param argClass the class to be queried. Can be either a Class object
     that describes the class or an instance of that class.
   */
   public static void dumpClass(Object argClass)
   {
      // What kind of parameter do we have
      if (argClass == null)
      {
         dumpln(0, "null");
         return;
      }

      Class theClass;
      if (argClass instanceof Class)
         theClass = (Class) argClass;
      else
         theClass = argClass.getClass();

      // The package
      Package thePackage = theClass.getPackage();

      if (thePackage != null)
         dumpln(0, "package " + thePackage.getName() + ";\n");

      // Name of the class or interface
      String className;
      if (thePackage == null)
         className = theClass.getName();
      else
         className =
            theClass.getName().substring(1 + thePackage.getName().length());

      String fullClassName;

      String modifiers = Modifier.toString(theClass.getModifiers());
      if (!modifiers.equals(""))
         modifiers = modifiers + " ";
      // modifiers contains "interface" but not "class"!
      if (theClass.isInterface())
         fullClassName = modifiers + className;
      else
         fullClassName = modifiers + "class " + className;

      // Superclass
      if (theClass.getSuperclass() != null
           && theClass.getSuperclass() != Object.class)
      {
         fullClassName = fullClassName +
               " extends " + theClass.getSuperclass().getName();
      }

      dumpln(0, fullClassName);

      // What interfaces does theClass extend or implement?
      Class[] interfaceList = theClass.getInterfaces();
      if (interfaceList.length != 0)
      {
         if (theClass.isInterface())
            dump(1, "extends ");
         else
            dump(1, "implements ");

         for (Class c : interfaceList)
            dump(0, c.getName() + ", ");
         dumpln(0, interfaceList[interfaceList.length - 1].getName());
      }

      // Ready for members
      dumpln(0, "{");

      // Constructors
      Constructor[] constructorList = theClass.getDeclaredConstructors();
      if (constructorList.length > 0)
      {
         for (Constructor ct : constructorList)
         {
            String constructorName = ct.toString();
            modifiers = Modifier.toString(ct.getModifiers());
            if (!modifiers.equals(""))
               modifiers = modifiers + " ";

            String parameterList = constructorName.substring(
                  constructorName.indexOf("("));

            dumpln(1, modifiers + className + parameterList + ";");
         }
      }

      // Methods
      Method[] methodList = theClass.getDeclaredMethods();
      if (methodList.length > 0)
      {
         // Add a blank line, if needed
         if (constructorList.length > 0)
            dumpln(0, "");

         for (Method m : methodList)
         {
            String methodString = m.toString();

            modifiers = Modifier.toString(m.getModifiers());
            if (!modifiers.equals(""))
               modifiers = modifiers + " ";

            String returnType = m.getReturnType().getName();

            String parameterList = methodString.substring(
                  methodString.indexOf("("));

            String methodName = m.getName();

            dumpln(1, modifiers + returnType + " "
                  + methodName + parameterList + ";");
         }
      }

      // Fields
      Field[] fieldList = theClass.getDeclaredFields();
      if (fieldList.length > 0)
      {
         // Add a blank line, if needed
         if (constructorList.length + methodList.length > 0)
            dumpln(0, "");

         for (Field f : fieldList)
         {
            String fieldString = f.toString();

            modifiers = Modifier.toString(f.getModifiers());
            if (!modifiers.equals(""))
               modifiers = modifiers + " ";

            String fieldType = f.getType().getName();

            String fieldName = f.getName();

            dumpln(1, modifiers + fieldType + " " + fieldName + ";");
         }
      }

      // All done
      dumpln(0, "}");
   }

   private static void dump(int level, String s)
   {
      System.out.print(BLANKS.substring(1, 1 + INDENT * level) + s);
   }

   private static void dumpln(int level, String s)
   {
      dump(level, s + "\n");
   }

   private static final String BLANKS = "                             ";
   private static final int INDENT = 3;
}
