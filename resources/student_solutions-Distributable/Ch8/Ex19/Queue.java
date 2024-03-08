/** 
    A first-in, first-out bounded collection of Events
*/ 
public class Queue 
{ 
   /** 
       Constructs an empty event queue. 
       @param capacity the maximum capacity of the queue 
       @precondition capacity > 0
   */ 
   public Queue(int capacity) 
   { 
      elements = new Object[capacity]; 
      count = 0; 
      head = 0; 
      tail = 0; 
   } 

   /** 
       Remove message at head. 
       @return the message that has been removed from the queue
       @precondition size() > 0 
   */ 
   public Object removeFirst() 
   { 
      Object r = elements[head]; 
      head = (head + 1) % elements.length; 
      count--; 
      return r; 
   } 

   /** 
       Append a message at tail. 
       @param anEvent the message to be appended 
       @precondition size() < getCapacity();
   */ 
   public void add(Object anObject) 
   { 
      elements[tail] = anObject; 
      tail = (tail + 1) % elements.length; 
      count++; 
   } 

   /** 
       Get the total number of messages in the queue. 
       @return the total number of messages in the queue 
   */ 
   public int size() 
   { 
      return count; 
   } 

   /** 
       Get the maximum number of messages in the queue. 
       @return the capacity of the queue 
   */ 
   public int getCapacity() 
   { 
      return elements.length; 
   } 


   /** 
       Get message at head. 
       @return the message that is at the head of the queue 
       @precondition size() > 0 
   */ 
   public Object getFirst() 
   { 
      return elements[head]; 
   } 

   private Object[] elements; 
   private int head; 
   private int tail; 
   private int count; 
}
