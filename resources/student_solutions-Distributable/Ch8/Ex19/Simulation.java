import java.util.*;

/**
   A generic event-driven simulation
*/
public abstract class Simulation
{
   /** 
      Initialize the simulation 
   */
   public abstract void initialize();

   /** 
      Update the simulation 
   */
   public abstract void update();

   /** 
      Terminate the simulation 
   */
   public abstract void terminate();

   /** 
      Construct a simulation object
   */
   public Simulation()
   {
      eventQueue = new PriorityQueue<Event>(QUEUE_SIZE);
   }

   /**
      Runs the simulation
      @param from the start time of the simulation
      @param to the end time of the simulation
   */
   public void run(double from, double to)
   {  
      now = from;

      initialize();

      while (eventQueue.size() > 0 && now <= to)
      {  
         Event event = eventQueue.remove();
         now = event.time();
         event.process(this);
         update();
      }
      terminate();
   }

   /**
      Queues an event to schedule it for execution
      @param e the event
   */
   public void schedule(Event e)
   {  
      eventQueue.add(e);
   }

   /**
      returns the current simulation time
      @return the current simulation time
   */
   public double getNow() 
   {  
      return now;
   }

   private double now;

   private static final int QUEUE_SIZE = 500;

   private PriorityQueue<Event> eventQueue;
}
