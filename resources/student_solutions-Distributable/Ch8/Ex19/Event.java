/** 
   An event that is scheduled for execution at some time
*/
public abstract class Event implements Comparable
{
   /**
      Constructs an event object at a particular time
      @param t the execution time of this event
   */
   public Event(double t)
   {
      time = t;
   }

   public int compareTo(Object o)
   {
      if (o == null || !(o instanceof Event))
         throw new IllegalArgumentException();

      Event other = (Event) o;
      if (time < other.time)
         return -1;
      if (time > other.time)
         return 1;
      return 0;
   }

   /* 
      The actions to take when the event occurs
      @param s the simulation the event is part of
   */
   public abstract void process(Simulation s);

   /**
      Returns the time at which the event is to be executed
      @return the time at which the event is to be executed
   */
   public double time() 
   {  
      return time;
   }

   private double time;
}
