import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

/**
   An applet that allows users to edit a scene composed of items.
*/
public class SceneEditor extends JApplet
{
   public void init()
   {
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

   }
}
