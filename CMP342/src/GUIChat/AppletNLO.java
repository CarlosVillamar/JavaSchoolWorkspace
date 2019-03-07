package GUIChat;


import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


@SuppressWarnings("serial")
public class AppletNLO extends Applet
{
	public AppletNLO()
	{
		setLayout(null);
	}
	
	public void add(Component a, int x, int y, int w, int n)
	{
		a.setBounds(x,y,w,n);
		
		add(a);
	}
	
	public void add(Component a, int x, int y)
	{
		add(a,x,y,100,20);
	}
	
	public void add(TextField m2, int x, int y, int w, int n, ActionListener al)
	{
		add(m2,x,y,w,n);
		m2.addActionListener(al);
	}
	
	public void add(TextField b, int x,int y,ActionListener al)
	{
		add(b,x,y,100,20,al);
		b.addActionListener(al);
	}
	
	public void addBN(Button c, int x, int y,int w, int n, ActionListener al)
	{
		add(c,x,y,w,n);
		c.addActionListener(al);
	}

	//The add methods with ActionListner involved were meant for buttons
	

}
