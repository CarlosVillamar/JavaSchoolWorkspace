package ART;

import java.awt.Color;
import java.awt.Graphics;

public class Titlebar extends Rect
{

	String title;
	Closer closer;
	
	public Titlebar(String title, int x, int y, int w)
	{
		super(x,y,w,20);
		this.title = title;
		closer = new Closer(x + w -20,y);
		
	}
	public void draw(Graphics win)
	{
		
		win.setColor(Color.yellow);
		super.fill(win);
		win.setColor(Color.blue);
		super.draw(win);
		closer.draw(win);
		win.setColor(Color.red);
		win.drawString(title,x + 10,y + 15);
		
		
	}

	public void moveBy(int dx,int dy)
	{
		super.moveBy(dx,dy);
		closer.moveBy(dx, dy);
		
	}
	
	public void resize(int dw)
	{	//we will be an assgined a defined set height no need to resize the all of the titlebar
		super.resizeBy(dw,0);
		closer.moveBy(dw, 0);// re-check could be move by
	}
	
}
