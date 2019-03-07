package ART;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ART extends Applet implements MouseListener, MouseMotionListener
{
   //Circle[] c = new Circle[10];

   //Rect r1 = new Rect(100, 100, 50, 50);

  //FakeWindow f1 = new FakeWindow(100,100, 100,100);

   FakeWindow [] fw = new  FakeWindow[10]; 
   int mx;
   int my;
   
   boolean held;



   public void init()
   {
     /* for(int i = 0; i < c.length; i++)

         c[i] = new Circle(20*i, 20*i, 10*i);*/
	   for(int i = 0; i < fw.length; i++)
	   {
		 fw[i] = new FakeWindow(20*i,20*i,400,300);  
	   }

      addMouseListener(this);

      addMouseMotionListener(this);
   }


   public void paint(Graphics win)
   {
      //r1.draw(win);
      
	   for(int i = 0; i < fw.length; i++)
		   fw[i].draw(win);

      /*win.drawString("             ", 10, 40);

      for(int i = 0; i < c.length; i++)
      {
         c[i].draw(win);


         if(c[i].contains(mx, my))

            win.drawString("Inside C" + i, 10, 40);
      }*/

   }


   public void mouseMoved(MouseEvent e)
   {

   }

   public void mouseDragged(MouseEvent e)
   {
      int nx = e.getX();
      int ny = e.getY();

      int dx = nx - mx;
      int dy = ny - my;
      
      
     
      if(fw[fw.length-1].resizer.held) fw[fw.length-1].resizeBy(dx, dy);
      if(fw[fw.length-1].titlebar.held) fw[fw.length-1].resizeBy(dx,dy);
      
     /* for(int i = 0; i < c.length; i++)

         //if (c[i].held) c[i].moveBy(dx, dy);
    	  if (c[i].held)c[i].resizeBy((int)Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2)));

      
      if (r1.held) r1.resizeBy(dx, dy);*/
      
      mx = nx;
      
      my = ny;

      repaint();
   }



   public void mousePressed(MouseEvent e)
   {
      mx = e.getX();
      my = e.getY();
      
      for(int i = 0; i < fw.length; i--)
      {
    	  if(fw[i].contains(mx,my)) 
    		  {
    		  rotateUp(fw,i);
    		  break;
    		  }
    	  
    	  
      }
      
      /*for(int i = 0; i < c.length; i++)

         if (c[i].contains(mx, my))  c[i].held = true;*/
    
      if(fw[fw.length - 1].resizer.contains(mx, my))fw[fw.length - 1].resizer.held = true;
      
	  if(fw[fw.length - 1].titlebar.contains(mx,my)) fw[fw.length - 1].titlebar.held = true;

      repaint();
   }

   public void rotateUp(FakeWindow[] fw, int index)
   {
	   FakeWindow temp = fw[index];
	   
	   for(int i = index; i < fw.length -1; i++)
	   {
		   fw[i] = fw[i+1];
		   fw[fw.length -1] = temp;
	   }
   }
   
   public void mouseReleased(MouseEvent e)
   {
      /*for(int i = 0; i < c.length; i++)

         c[i].held = false;
      		r1.held = false;*/
	   for(int i = 0; i < fw.length; i++)
	   {
	   fw[i].held = false;
	   fw[i].titlebar.held = false;
	   fw[i].resizer.held = false;
	   }
   }
   




   public void mouseClicked(MouseEvent e)
   {
   }

   public void mouseEntered(MouseEvent e)
   {


   }

   public void mouseExited(MouseEvent e)
   {


   }




}

/*public class ART extends Applet implements MouseListener, MouseMotionListener
{
	int my;
	int mx;
	
	Circle c1 = new Circle(	100, 100, 50);
	Circle c2 = new Circle(	400, 100, 200);
	Circle c3 = new Circle(	600, 300, 5);

	Rect r1 = new Rect( 100, 100, 50, 50);
	
	boolean  held = false;
	
	public void init()
	{
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}
	public void paint(Graphics win)
	{
		
		
		c1.draw(win);
		c2.draw(win);
		c3.draw(win);
		r1.draw(win);
		
		if (c1.contains(mx, my))
		{
			win.drawString("inside c1", 10, 40);
		}
		else
		{
			win.drawString("insdie all", 10, 40);
		}
		
	}

	
	public void mouseClicked(MouseEvent e) 
	{
		System.out.println("clicked");
		c1.moveBy(10,0);
		c2.moveBy(1,-1);
		c3.moveBy(0, 2);
		
		repaint();
	}

	
	public void mouseEntered(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		System.out.println("Entered");
	}

	
	public void mouseExited(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		System.out.println("Exited");

	}
	public void mouseMoved(MouseEvent e)
	{
		
	}
	
	public void mouseDragged(MouseEvent e)
	{
		int nx = e.getX();
		int ny = e.getY();
		
		int dx = nx - mx;
		int dy = nx - my;
		
		if (held)c1.moveBy(dx, dy);
		repaint();
		
	}

	public void mousePressed(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		System.out.println("Pressed");
		
		 mx = e.getX();
		 my = e.getY();
		
		repaint();
		
		if (c1.contains(mx,my)) held = true;
			
				/*System.out.println("inside");
				win.drawString("inside c3", 10, 40);
		
		}
		else
			System.out.println("outside");
			win.drawString("inside all", 10, 40);	
			{
			  inside = true;
			}
		if(r1.contains(mx, my))
		{
			System.out.println("inside Rectangle");
			
		}
		else
			System.out.println("Try again");
	}

	
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		//System.out.println("Released");
		held = false;
	}*/


