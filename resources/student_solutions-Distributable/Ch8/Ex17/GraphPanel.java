import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
   A panel to draw a graph
*/
public class GraphPanel extends JComponent
{
   /**
      Constructs a graph.
      @param aToolBar the tool bar with the node and edge tools
      @param aGraph the graph to be displayed and edited
   */
   public GraphPanel(ToolBar aToolBar, Graph aGraph)
   {
      toolBar = aToolBar;
      graph = aGraph;
      setBackground(Color.WHITE);

      addMouseListener(new
         MouseAdapter()
         {
            public void mousePressed(MouseEvent event)
            {
               Point2D mousePoint = event.getPoint();
               Node n = graph.findNode(mousePoint); 
               Edge e = graph.findEdge(mousePoint);
               Object tool = toolBar.getSelectedTool();
               if (tool == null) // select
               {
                  if (e != null)
                  {
                     selected = e;
                  }
                  else if (n != null)
                  {
                     selected = n;
                     dragStartPoint = mousePoint;
                     dragStartBounds = n.getBounds();
                  }
                  else 
                  {
                     selected = null;
                  }
               }
               else if (tool instanceof Node)
               {
                  Node prototype = (Node) tool;
                  Node newNode = (Node) prototype.clone();
                  boolean added = graph.add(newNode, mousePoint);
                  if (added)
                  {
                     selected = newNode;
                     dragStartPoint = mousePoint;
                     dragStartBounds = newNode.getBounds();
                  }
                  else if (n != null)
                  {
                     selected = n;
                     dragStartPoint = mousePoint;
                     dragStartBounds = n.getBounds();
                  }
               }
               else if (tool instanceof Edge)
               {
                  if (n != null) rubberBandStart = mousePoint;
               }
               lastMousePoint = mousePoint;
               repaint();
            }

            public void mouseReleased(MouseEvent event)
            {
               Object tool = toolBar.getSelectedTool();
               if (rubberBandStart != null)
               {
                  Point2D mousePoint = event.getPoint();
                  Edge prototype = (Edge) tool;
                  Edge newEdge = (Edge) prototype.clone(); 
                  if (graph.connect(newEdge, 
                         rubberBandStart, mousePoint))
                     selected = newEdge;
               }

               revalidate();
               repaint();

               lastMousePoint = null;
               dragStartBounds = null;
               rubberBandStart = null;
            }
         });

      addMouseMotionListener(new
         MouseMotionAdapter()
         {
            public void mouseDragged(MouseEvent event)
            {
               Point2D mousePoint = event.getPoint();
               if (dragStartBounds != null)
               {
                  if (selected instanceof Node)
                  {
                     Node n = (Node) selected;
                     Rectangle2D bounds = n.getBounds();
                     n.translate(
                        dragStartBounds.getX() - bounds.getX() 
                        + mousePoint.getX() - dragStartPoint.getX(),
                        dragStartBounds.getY() - bounds.getY() 
                        + mousePoint.getY() - dragStartPoint.getY());
                  }
               }
               lastMousePoint = mousePoint;
               repaint();
            }
         });
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      Rectangle2D bounds = getBounds();
      Rectangle2D graphBounds = graph.getBounds(g2);
      graph.draw(g2);

      if (selected instanceof Node)
      {
         Rectangle2D grabberBounds = ((Node) selected).getBounds();
         drawGrabber(g2, grabberBounds.getMinX(), grabberBounds.getMinY());
         drawGrabber(g2, grabberBounds.getMinX(), grabberBounds.getMaxY());
         drawGrabber(g2, grabberBounds.getMaxX(), grabberBounds.getMinY());
         drawGrabber(g2, grabberBounds.getMaxX(), grabberBounds.getMaxY());
      }

      if (selected instanceof Edge)
      {
         Line2D line = ((Edge) selected).getConnectionPoints();
         drawGrabber(g2, line.getX1(), line.getY1());
         drawGrabber(g2, line.getX2(), line.getY2());
      }

      if (rubberBandStart != null)
      {
         Color oldColor = g2.getColor();
         g2.setColor(PURPLE);
         g2.draw(new Line2D.Double(rubberBandStart, lastMousePoint));
         g2.setColor(oldColor);
      }
   }

   /**
      Puts a copy of the selected node or edge into the clipboard.
   */
   public void copySelected()
   {
      clipboard.clear();

      if (selected instanceof Node)
         clipboard.add(((Node) selected).clone());

      else if (selected instanceof Edge)
      {
         Edge edge = (Edge) selected;

         // Paste assumes the edge was added to the clipboard before the nodes
         clipboard.add(edge.clone());

         Node start = edge.getStart();
         clipboard.add(start.clone());

         // If start and end are the same, only put one of them in the clip
         if (start != edge.getEnd())
            clipboard.add(edge.getEnd().clone());
      }
   }

   /**
      Puts the selected node or edge into the clipboard and removes it from
      the graph.
   */
   public void cutSelected()
   {
      clipboard.clear();
      if (selected instanceof Node)
         clipboard.add(selected);

      else if (selected instanceof Edge)
      {
         Edge edge = (Edge) selected;

         // Paste assumes the edge was added to the clipboard before the nodes
         clipboard.add(edge);

         Node start = edge.getStart();
         // Since the node is still in the graph, we clone it
         clipboard.add((Node)start.clone());

         // If start and end are the same, only put one of them in the clip
         if (start != edge.getEnd())
            clipboard.add((Node)edge.getEnd().clone());
      }
      removeSelected();
   }

   /**
      Pastes whatever is in the clipboard, if anything, into the graph.
   */
   public void pasteClipboard()
   {
      if (clipboard.isEmpty())
         return;

      Object o = clipboard.get(0);
      if (o instanceof Node)
      {
         Node node = (Node) o;
         graph.add((Node)node.clone(), new Point2D.Double(0, 0));
      }
      else // (o instanceof Edge)
      {
         Edge edge = (Edge)o;

         Node node1 = (Node)clipboard.get(1);
         // If the start and end nodes of the edge were the same, it was
         // only added once, so we must handle that special case.
         if (clipboard.size() == 2)
         {
            Rectangle2D bounds1 = node1.getBounds();
            Node clone1 = (Node) node1.clone();
            graph.add((Node)clone1, new Point2D.Double(0, 0));

            // We may have moved clone1 so we need new bounds
            bounds1 = clone1.getBounds();
            Point2D center =
               new Point2D.Double(bounds1.getCenterX(), bounds1.getCenterY());
            graph.connect((Edge)edge.clone(), center, center);
         }
         else
         {
            Node node2 = (Node) clipboard.get(2);

            Rectangle2D bounds1 = node1.getBounds();
            Rectangle2D bounds2 = node2.getBounds();
            Rectangle2D bounds3 = new Rectangle2D.Double();
            Rectangle2D.union(bounds1, bounds2, bounds3);

            Node clone1 = (Node) node1.clone();
            Node clone2 = (Node) node2.clone();

            clone1.translate(-bounds3.getX(), -bounds3.getY());
            clone2.translate(-bounds3.getX(), -bounds3.getY());

            bounds1 = clone1.getBounds();
            bounds2 = clone2.getBounds();

            graph.add(clone1,
               new Point2D.Double(bounds1.getX(), bounds1.getY()));
            graph.add(clone2,
               new Point2D.Double(bounds2.getX(), bounds2.getY()));

            graph.connect((Edge)edge.clone(),
               new Point2D.Double(bounds1.getCenterX(), bounds1.getCenterY()),
               new Point2D.Double(bounds2.getCenterX(), bounds2.getCenterY()));
         }
      }
      repaint();
   }

   /**
      Removes the selected node or edge.
   */
   public void removeSelected()
   {
      if (selected instanceof Node)
      {
         graph.removeNode((Node) selected);
      }
      else if (selected instanceof Edge)
      {
         graph.removeEdge((Edge) selected);
      }          
      selected = null;
      repaint();               
   }

   /**
      Edits the properties of the selected graph element.
   */
   public void editSelected()
   {
      PropertySheet sheet = new PropertySheet(selected);
      sheet.addChangeListener(new
         ChangeListener()
         {
            public void stateChanged(ChangeEvent event)
            {
               repaint();
            }
         });
      JOptionPane.showMessageDialog(null, 
         sheet, 
         "Properties", 
         JOptionPane.QUESTION_MESSAGE);        
   }

   /**
      Draws a single "grabber", a filled square
      @param g2 the graphics context
      @param x the x coordinate of the center of the grabber
      @param y the y coordinate of the center of the grabber
   */
   public static void drawGrabber(Graphics2D g2, double x, double y)
   {
      final int SIZE = 5;
      Color oldColor = g2.getColor();
      g2.setColor(PURPLE);
      g2.fill(new Rectangle2D.Double(x - SIZE / 2,
         y - SIZE / 2, SIZE, SIZE));      
      g2.setColor(oldColor);
   }

   public Dimension getPreferredSize()
   {
      Rectangle2D bounds 
         = graph.getBounds((Graphics2D) getGraphics());
      return new Dimension(
         (int) bounds.getMaxX(), 
         (int) bounds.getMaxY());
   }

   private Graph graph;
   private ToolBar toolBar;
   private Point2D lastMousePoint;
   private Point2D rubberBandStart;
   private Point2D dragStartPoint;
   private Rectangle2D dragStartBounds;
   private Object selected;

   private ArrayList<Object> clipboard = new ArrayList<Object>();

   private static final Color PURPLE = new Color(0.7f, 0.4f, 0.7f);   
}                               
