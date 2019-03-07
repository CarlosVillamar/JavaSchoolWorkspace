package chat;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


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
	
	public void add(TextField b, int x, int y, int w, int n, ActionListener al)
	{
		add(b,x,y,w,n);
		b.addActionListener(al);
	}
	
	public void add(TextField b, int x,int y,ActionListener al)
	{
		add(b,x,y,100,20,al);
	}
	public void add(Button a, int x, int y , int w, int h,ActionListener al)
	{
		add(a,x,y,w,h);
		a.addActionListener(al);
	}
	//The add methods with ActionListner involved were origanly meant for buttons
	

}
