import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.lang.reflect.InvocationTargetException;

/**
   Implements a CopyOnWriteList proxy for the List interface.
   A copy of the list is only made if the list is modified.  Otherwise,
   clients share the list.
*/
public class CopyOnWriteList<E> implements List<E>
{
   /**
      Creates a CopyOnWriteList object.
      @param l the list that can be shared by clients.
   */
   public CopyOnWriteList(List<E> l)
   {
      this.list = l;
      listCopied = false;
   }

   public void add(int index,E element)
   {
      ensureCopyMade();
      list.add(index, element);
   }

   public boolean add(E o)
   {
      ensureCopyMade();
      return list.add(o);
   }

   public boolean addAll(int index, Collection<? extends E> c)
   {
      ensureCopyMade();
      return list.addAll(index, c);
   }

   public boolean addAll(Collection<? extends E> c)
   {
      ensureCopyMade();
      return list.addAll(c);
   }

   public void clear()
   {
      ensureCopyMade();
      list.clear();
   }

   public boolean contains(Object o)
   {
      return list.contains(o);
   }

   public boolean containsAll(Collection<?> c)
   {
      return list.containsAll(c);
   }

   public boolean equals(Object o)
   {
      return list.equals(o);
   }

   public E get(int index)
   {
      return list.get(index);
   }

   public int hashCode()
   {
      return list.hashCode();
   }

   public int indexOf(Object o)
   {
      return list.indexOf(o);
   }

   public boolean isEmpty()
   {
      return list.isEmpty();
   }

   public Iterator<E> iterator()
   {
      return list.iterator();
   }

   public int lastIndexOf(Object o)
   {
      return list.lastIndexOf(o);
   }

   public ListIterator<E> listIterator()
   {
      return list.listIterator();
   }

   public ListIterator<E> listIterator(int index)
   {
      return list.listIterator();
   }

   public E remove(int index)
   {
      ensureCopyMade();
      return list.remove(index);
   }

   public boolean remove(Object o)
   {
      ensureCopyMade();
      return list.remove(o);
   }

   public boolean removeAll(Collection<?> c)
   {
      ensureCopyMade();
      return list.removeAll(c);
   }

   public boolean retainAll(Collection<?> c)
   {
      ensureCopyMade();
      return list.retainAll(c);
   }

   public E set(int index, E element)
   {
         ensureCopyMade();
         return list.set(index,element);
   }
   public int size()
   {
      return list.size();
   }

   public List<E> subList(int fromIndex, int toIndex)
   {
      return list.subList(fromIndex, toIndex);
   }

   public Object[] toArray()
   {
      return list.toArray();
   }

   //public Object[] toArray(Object[] a)
   public <T> T[] toArray(T[] a)
   {
      return list.toArray(a);
   }
   // For demonstration purposes!
   List<E> getList()
   {
      return list;
   }

   private void ensureCopyMade()
   {
      try
      {
         if (!listCopied)
         {
            List<E> newList = (List<E>) list.getClass().newInstance();

            boolean valid = newList.addAll(list);
            list = newList;
            listCopied = true;
         }
      }
      catch(IllegalAccessException e)
      {
         e.printStackTrace();
      }
      catch(InstantiationException e)
      {
         e.printStackTrace();
      }
   }

   private List<E> list;
   private boolean listCopied;
}
