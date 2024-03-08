/*
   The script tests some properties of the CarBean class.

   According to the Rhino shell documentation, the Rhino shell can be
   invoked in two ways:
   
   1. java -jar js.jar 

   2. java org.mozilla.javascript.tools.shell.Main 

   However, the first way will override the classpath environment variable,
   and Rhino will not be able to find the CarBean.class in the current directory.
  
   Therefore, you need to use the second method. That requires that both js.jar and
   CarBean.class can be found using the classpath.  If both are in the
   current directory, for example, the classpath could be set with

      export CLASSPATH=.:/path/to/rhino/js.jar

   or

      set CLASSPATH=.;c:\path\to\rhino\js.jar
*/

// Packages with the prefix java do not need Packages as a prefix
importPackage(java.awt);

var frame = new Packages.javax.swing.JFrame();
frame.title = "Ex7-35";
frame.setSize(new Dimension(300, 300));

// Finds the class in the default package
var car = new Packages.CarBean();

car.color = Color.red;
car.dimension = new Dimension(200, 200);

frame.add(car);

frame.show();
