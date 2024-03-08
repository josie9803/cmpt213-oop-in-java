import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.table.TableModel;
import java.awt.BorderLayout;

import java.awt.Rectangle;
/**
   Tests the MapAdaptor class
*/
public class MapAdaptorTester extends JFrame
{
   /**
      Constructs a MapAdaptorTester object
   */
   public MapAdaptorTester()
   {
      super("MapAdaptorTester");

      Map<String, Object> map = new TreeMap<String, Object>();
      map.put("Integer", new Integer(3));
      map.put("Over", "Under");
      map.put("Hello", "Goodbye");
      TableModel tableModel = new MapAdaptor(map);

      JTable table = new JTable(tableModel);
      JScrollPane scrollPane = new JScrollPane(table);
      add(scrollPane, BorderLayout.CENTER);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   /**
      Create and show a MapAdaptorTester object
      @param args unused
   */
   public static void main(String[] args)
   {
      MapAdaptorTester test = new MapAdaptorTester();
      test.pack();
      test.setVisible(true);
   }
}
