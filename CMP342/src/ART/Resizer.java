package ART;

import java.awt.Color;
import java.awt.Graphics;

public class Resizer extends Rect
{
	public Resizer(int x, int y)
	{
		super(x,y,20,20);
	}
	public void draw(Graphics win)
	{
		win.setColor(Color.pink);
		super.fill(win);
		win.setColor(Color.black);
		super.draw(win);
	}
	//overwritten to remove functionality of base class
	public void resizeBy(int dw, int dh)
	{
		super.resizeBy(0, 0);
		
	}
	

}
