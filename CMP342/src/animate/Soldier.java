package animate;

public class Soldier extends Sprite
{

   public static String[] pose()
   {
      String[] p =
      {
         "lt",
         "rt",
         "dn",
         "up"
      };

      return p;
   };

   public Soldier(int x, int y, int duration)
   {
      super(x, y, "g", pose(), duration, 5);
   }

}