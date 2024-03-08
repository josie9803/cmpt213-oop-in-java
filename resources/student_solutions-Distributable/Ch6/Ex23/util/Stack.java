package util;

import java.util.ArrayList;


/**
  A class that implements stacks using aggregation of an ArrayList.
*/
public class Stack<E>
{
   /**
      Constructs a Stack object.
   */
   public Stack()
   {
      elements = new ArrayList<E>();
   }

   /**
      Puts an element onto the stack
      @param item the item to put onto the stack
   */
   public void push(E item)
   {
      elements.add(item);
   }

   /**
      Returns the top element of the stack and removes it from the stack.
      @return the top element from the stack
   */
   public E pop()
   {
      return elements.remove(elements.size() - 1);
   }

   /**
      Returns the top element of the stack
      @return the top element from the stack
   */
   public E top()
   {
      return elements.get(elements.size() - 1);
   }

   /**
      Returns whether the stack is empty
      @return whether the stack is empty
   */
   public boolean isEmpty()
   {
      return elements.isEmpty();
   }

   /**
      Returns the number of elements on the stack
      @return the number of elements on the stack
   */
   public int size()
   {
      return elements.size();
   }

   private ArrayList<E> elements;
}
