package animate;

import java.awt.Graphics;

public class Sprite
{

   int x;
   int y;

   int action = 0;

   boolean moving = false;

   Animation[] animation;

   public Sprite
   (
      int x,
      int y,
      String name,
      String[] pose,
      int duration,
      int images
   )
   {
      this.x = x;
      this.y = y;

      animation = new Animation[pose.length];

      for(int i = 0; i < animation.length; i++)

         animation[i] = new Animation(name + "_" + pose[i] + "_", duration, images);
   }


   public void draw(Graphics g)
   {
      if (moving)
         g.drawImage(animation[action].getNextImage(), x, y, null);
      else
         g.drawImage(animation[action].getStillImage(), x, y, null);

      moving = false;
   }


   public void moveLeftBy(int dx)
   {
      x -= dx;

      action = 0;

      moving = true;
   }

   public void moveRightBy(int dx)
   {
      x+= dx;

      action = 1;

      moving = true;
   }

   public void moveUpBy(int dy)
   {
      y -= dy;

      action = 3;

      moving = true;
   }

   public void moveDownBy(int dy)
   {
      y += dy;

      action = 2;

      moving = true;
   }

   public void moveBy(int dx, int dy)
   {
      x += dx;
      y += dy;
   }

}
