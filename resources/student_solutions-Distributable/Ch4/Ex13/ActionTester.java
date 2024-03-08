import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

/**
   A class for testing buttons and text fields
*/
public class ActionTester
{
   /**
      Create a textfield that displays the time at which a button was pressed.
      @param args unused
   */
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FIELD_WIDTH = 20;
      final JTextField textField = new JTextField(FIELD_WIDTH);
      textField.setText("Click button for current date");

      JButton helloButton = new JButton("Date");
      String dateAndTime = new Date().toString();
      textField.setText(dateAndTime);

      helloButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               String dateAndTime = new Date().toString();
               textField.setText(dateAndTime);
            }
         });

      frame.setLayout(new FlowLayout());

      frame.add(helloButton);
      frame.add(textField);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
