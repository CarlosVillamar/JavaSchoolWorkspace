package ART;

import java.awt.Graphics;

public class Rect extends shape {
	/*int x;
	int y; //axis align refers to x and y*/
	
	int w;
	int h;
	 boolean held = false;
	
	public Rect(int x, int y, int w, int h)
	{
		super(x,y);
		
		//Remember w and h cannot be negative values
		this.w = w;
		this.h = h;
	}
	
	public void draw(Graphics win)
	{
		win.drawRect(x, y, w, h);
		
	}
	public void fill(Graphics win)
	{
		win.fillRect(x, y, w, h);
		
		
	}
	
		
		
	
	public boolean contains(int mx,int my)
	{
		  return (mx >= x) && (mx <= x+w) && (my > y) && (my <= y+h);
	}
	public void resizeBy(int dw, int dh)
	{
		w += dw;
		h += dh;
		
	}
}
