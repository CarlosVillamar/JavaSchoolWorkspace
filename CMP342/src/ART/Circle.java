package ART;

import java.awt.*;


public class Circle extends shape
{
	/*int x;
	int y;*/
	
	int r;
	boolean held = false;
	
	public Circle(int x, int y, int r)
	{
		super(x,y);
		
		if(r>=0)
			this.r = r;
		else 
			this.r= 0; // or this.r = -r;
		//Distance = square root of (x-mx)^2 + (y - my)^2
		//diameter = (2*pi)* r
		
		
	}
	
	
	public void draw(Graphics win)
	{
		win.drawOval(x-r,y-r,2*r,2*r); // (x,y,width,height)
		
	}
	public void fill(Graphics win)
	{
		win.fillOval(x-r,y-r,2*r,2*r); // (x,y,width,height)
		
	}
	
	public boolean contains(int mx, int my)
	{
		
		return Math.pow((x - mx), 2)+ Math.pow((y - my), 2) <= r*r;
		
		
		/*double d = Math.sqrt(Math.pow((x - mx), 2)+Math.pow((y - my), 2));
		
		if(d<= r) return true;
		
		else return true;
		
		return d<= r;*/ 
		
		//same thing as the commented out statements above
		
	}
	
	public void  resizeBy(int dr)
	{
		r += dr;
	}
	

	



}
