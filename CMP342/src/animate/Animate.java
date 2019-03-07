package animate;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.io.*;


public class Animate extends Applet implements Runnable, KeyListener
{

   Soldier sprite1;

   boolean ltPressed = false;
   boolean rtPressed = false;
   boolean upPressed = false;
   boolean dnPressed = false;

   Thread t;

   Image    offscreen;
   Graphics offscreen_g;


   public void init()
   {
      offscreen   = createImage(1000, 800);
      offscreen_g = offscreen.getGraphics();



      sprite1 = new Soldier (100, 100, 4);

      t = new Thread(this);

      t.start();


      addKeyListener(this);

      requestFocus();
   }


   public void update(Graphics g)
   {
      offscreen_g.clearRect(0, 0, 1000, 800);

      paint(offscreen_g);

      g.drawImage(offscreen, 0, 0, this);
   }


   public void paint(Graphics g)
   {
      sprite1.draw(g);
   }


   public void run()
   {

      while(true)
      {
         if(ltPressed)
         {
            sprite1.moveLeftBy(10);
         }
         if(rtPressed)
         {
            sprite1.moveRightBy(10);
         }

         if(upPressed) sprite1.moveUpBy(10);
         if(dnPressed) sprite1.moveDownBy(10);

         try
         {
            t.sleep(50);
         }
         catch(Exception x){};

         repaint();


      }

   }


   public void keyPressed(KeyEvent e)
   {
      if (e.getKeyCode() == e.VK_LEFT)  ltPressed = true;

      if (e.getKeyCode() == e.VK_RIGHT) rtPressed = true;

      if (e.getKeyCode() == e.VK_UP)    upPressed = true;

      if (e.getKeyCode() == e.VK_DOWN)  dnPressed = true;
   }

   public void keyReleased(KeyEvent e)
   {
      if (e.getKeyCode() == e.VK_LEFT)  ltPressed = false;

      if (e.getKeyCode() == e.VK_RIGHT) rtPressed = false;

      if (e.getKeyCode() == e.VK_UP)    upPressed = false;

      if (e.getKeyCode() == e.VK_DOWN)  dnPressed = false;
   }


   public void keyTyped(KeyEvent e)
   {

   }


}

/*import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Animate extends Applet implements Runnable, KeyListener
{
	/*Animation animation;
	Animation animation1;
	Animation animation2;
	Animation animation3;
	
	Sprite sprite;
	Sprite sprite1;
	Sprite sprite2;
	Sprite sprite3;
	
	boolean LtPressed = false;
	boolean Rtpressed = false;
	boolean UPpressed = false;
	boolean DWpressed = false;
	
	

	
	Thread t;
	
	Image 	 offscreen;
	Graphics offscreen_g;

	
	public void init()
	{
		offscreen   = createImage(1000,1000);
		offscreen_g = offscreen.getGraphics();
		
		animation  = new Animation ("bi_it", 5, 5);
		animation1 = new Animation ("bi_it", 5, 5);
		animation2 = new Animation ("bi_it", 5, 5);
		animation3 = new Animation ("bi_it", 5, 5);
		// (your string input will indicate the name of the files/pictures)
		
		String[] pose = 
			(
				"lt";
				"rt";
				"dw";
				"up"
			);
		
		sprite  = new Sprite (100,200,"g_lt", 5, 5);
		sprite1 = new Sprite (100,200,"g_rt", 5, 5);
		sprite2 = new Sprite (100,200,"g_up", 5, 5);
		sprite3 = new Sprite (100,200,"g_dw", 5, 5);
		
		t = new Thread(this);
		
		t.start();
		
		addKeyListener(this);
		
		
		
	}
	
	/*public void update(Graphics g)
	{
		offscreen_g.clearRect(1000,800,0,0);
		
		paint(offscreen_g);
		 g.drawImage(offscreen,0,0,this);
		
		
	}
	public void paint(Graphics g)
	{
		sprite.draw(g);
		sprite1.draw(g);
		sprite2.draw(g);
		sprite3.draw(g);
		
		
	}
	
	public void run()
	{
		while(true)
		{
			if(LtPressed)
			{
				sprite. moveBy(-10,0);
				sprite1.moveBy(-10, 0);
				sprite2.moveBy(-10,0);
				sprite3.moveBy(-10,0);
			}
			if(Rtpressed)
			{
				sprite. moveBy(10,0);
				sprite1.moveBy(10, 0);
				sprite2.moveBy(10,0);
				sprite3.moveBy(10,0);
			}
			if(UPpressed) 
				sprite.moveBy(0, -10);
			
			if(DWpressed)
				sprite.moveBy(0, 10);
			
			try
			{
				Thread.sleep(50);
				
			}
			catch(Exception x){};
			
			repaint();
		}
	}

	
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			LtPressed = true;
		
		
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			Rtpressed = true;
		
		
		if(e.getKeyCode() == KeyEvent.VK_UP)
			UPpressed = true;
		
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			DWpressed = true;
		
		
	}

	
	public void keyReleased(KeyEvent e)
	{
	
		
	}


	public void keyTyped(KeyEvent e) 
	{
	
		
	}

}*/

