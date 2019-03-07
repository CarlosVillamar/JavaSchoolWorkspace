package Animate2;

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.io.*;

import animate.Soldier;


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