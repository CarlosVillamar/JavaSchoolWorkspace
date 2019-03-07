package ART;

import java.awt.Color;
import java.awt.Graphics;

public class FakeWindow extends Rect
{
	//Rect titlebar; since we created the titlebar class we will eliminate this
	Titlebar titlebar;
	Resizer resizer;
	
	public FakeWindow(int x, int y, int w, int h) // TODO Auto-generated constructor stub
	{
		super(x, y, w, h);
		
		titlebar = new Titlebar("message",x,y,w);
		
		resizer = new Resizer(x,y);
	}

	public void draw(Graphics win)
	{
		//super.draw(win);
		win.setColor(Color.lightGray);
		super.fill(win);
		win.setColor(Color.black);
		super.draw(win);
		titlebar.draw(win);
		resizer.draw(win);
	}
	
	public void moveBy(int dx,int dy)
	{
		super.moveBy(dx, dy);
		
		titlebar.moveBy(dx, dy);
		
		resizer.moveBy(dx, dy);
		
	}
	
	public void resizeBy(int dw, int dh)
	{
		super.resizeBy(dw, dh);
		
		titlebar.resizeBy(dw, 0);
		
		resizer.moveBy(dw, dh);
		
	}
	
	
}
