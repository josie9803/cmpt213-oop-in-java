import java.beans.*;
import java.util.*;
import javax.swing.*;

public class Ex7_31
{
   public static void main(String[] args) throws IntrospectionException
   {
      for (PropertyDescriptor pd : Introspector.getBeanInfo(JSlider.class).getPropertyDescriptors())
      {
         String name = pd.getName() + " ";
         if (pd.getReadMethod() != null) name += "R";
         if (pd.getWriteMethod() != null) name += "W";
         if (pd.getPropertyType() != null) 
            System.out.println(pd.getPropertyType().getName() + " " + name);
      }
   }
}
