import java.util.Set;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
   An Adaptor that adapts a Map to an AbstractTableModel
*/
public class MapAdaptor extends AbstractTableModel
{
   /**
      Constructs a MapAdaptor for the given map
      @param map the Map to create an adaptor for
   */
   public MapAdaptor(Map<?, ?> map)
   {
      this.map = map;
   }

   public int getRowCount()
   {
      return map.size();
   }

   public int getColumnCount()
   {
      return 2;
   }

   public Object getValueAt(int row, int column)
   {
      Set keySet = map.keySet();
      Object keyArray[] = keySet.toArray();
      Object key = keyArray[row];
      if (column == 0)
         return key;
      else
         return map.get(key);
   }

   private Map<?, ?> map;
}
