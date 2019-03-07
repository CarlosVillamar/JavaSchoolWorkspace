package ART;

import java.awt.Graphics;

public abstract class shape 
{
	int x;
	int y; //axis align refers to x and y
	

public shape(int x, int y)
{
	this.x = x;
	this.y = y;
	
	
}
public void moveBy(int dx, int dy)
{
	x+=dx;
	y+=dy;
}
public abstract void draw(Graphics win);



public abstract boolean contains(int mx, int my);
}
