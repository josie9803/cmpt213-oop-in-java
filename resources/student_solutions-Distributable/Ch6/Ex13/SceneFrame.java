import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

/**
   A class for the main frame for a scene editor.
*/
public class SceneFrame extends JFrame
{

   /**
     Construct the main frame for a scene editor.
   */
   public SceneFrame()
   {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      final SceneComponent scene = new SceneComponent();

      JButton houseButton = new JButton("House");
      houseButton.addActionListener(new
            ActionListener()
            {
               public void actionPerformed(ActionEvent event)
               {
                  scene.add(new HouseShape(20, 20, 50));
               }
            });

      JButton carButton = new JButton("Car");
      carButton.addActionListener(new
            ActionListener()
            {
               public void actionPerformed(ActionEvent event)
               {
                  scene.add(new CarShape(20, 20, 50));
               }
            });

      JButton removeButton = new JButton("Remove");
      removeButton.addActionListener(new
            ActionListener()
            {
               public void actionPerformed(ActionEvent event)
               {
                  scene.removeSelected();
               }
            });

      JPanel buttons = new JPanel();
      buttons.add(houseButton);
      buttons.add(carButton);
      buttons.add(removeButton);

      add(scene, BorderLayout.CENTER);
      add(buttons, BorderLayout.NORTH);

      setSize(300, 300);
   }
}


