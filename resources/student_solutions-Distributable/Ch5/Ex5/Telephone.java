import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   Presents a GridBag based phone GUI for the voice mail system.
*/
public class Telephone
{
   /**
      Constructs a telephone with a speaker, keypad, and microphone.
   */
   public Telephone()
   {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container contentPane = frame.getContentPane();

      GridBagLayout layout = new GridBagLayout();
      frame.setLayout(layout);

      GridBagConstraints constraints = new GridBagConstraints();

      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.anchor = GridBagConstraints.WEST;
      constraints.weightx = 0;
      constraints.weighty = 0;

      JLabel speakerLabel  =new JLabel("Speaker:");
      add(contentPane, speakerLabel, constraints, 0, 0, 3, 1);

      speakerField = new JTextArea(10, 25);
      add(contentPane, speakerField, constraints, 0, 1, 3, 5);

      // Pad the number buttons so they are wide enough
      constraints.ipadx = 60;
      String keyLabels = "123456789*0#";
      for (int i = 0; i < keyLabels.length(); i++)
      {
         final String label = keyLabels.substring(i, i + 1);
         JButton keyButton = new JButton(label);
         add(contentPane, keyButton, constraints,
               (i % 3), 6 + i / 3, 1, 1);
         keyButton.addActionListener(new
            ActionListener()
            {
               public void actionPerformed(ActionEvent event)
               {
                  connect.dial(label);
               }
            });
      }

      // No more padding needed
      constraints.ipadx = 0;
      JLabel microphoneLabel  =new JLabel("Microphone:");
      add(contentPane, microphoneLabel, constraints, 0, 10, 3, 1);

      final JTextArea microphoneField = new JTextArea(10, 25);
      add(contentPane, microphoneField, constraints, 0, 11, 3, 5);

      // The send button needs to be shifted over and not stretch
      constraints.insets.left = +55;
      constraints.fill = GridBagConstraints.NONE;
      JButton speechButton = new JButton("Send speech");
      add(contentPane, speechButton, constraints, 0, 17, 2, 1);
      speechButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               connect.record(microphoneField.getText());
               microphoneField.setText("");
            }
         });

      // The hangup button needs to be shifted over too
      constraints.insets.left = -35;
      JButton hangupButton = new JButton("Hangup");
      add(contentPane, hangupButton, constraints, 2, 17, 1, 1);
      hangupButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               connect.hangup();
            }
         });

      frame.pack();
      frame.setVisible(true);
   }

   /**
      A convenience method to add a component to given grid bag
      layout locations.
      @param c the component to add
      @param constraints the grid bag constraints to use
      @param x the x grid position
      @param y the y grid position
      @param w the grid width
      @param h the grid height
   */
   private void add(Container contentPane, Component c,
         GridBagConstraints constraints,
      int x, int y, int w, int h)
   {
      constraints.gridx = x;
      constraints.gridy = y;
      constraints.gridwidth = w;
      constraints.gridheight = h;
      contentPane.add(c, constraints);
   }

   /**
      Give instructions to the mail system user.
   */
   public void speak(String output)
   {
      speakerField.setText(output);
   }

   public void run(Connection c)
   {
      connect = c;
   }

   private JTextArea speakerField;
   private Connection connect;
}
