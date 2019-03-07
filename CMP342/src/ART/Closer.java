package ART;

import java.awt.Color;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Closer extends Rect implements ActionListener,MouseListener
{
	public Closer(int x, int y)
	{
		super(x,y,20,20);
		addMouseListener(this);
		addActionListener(this);
	}
	private void addActionListener(Closer closer) {
		// TODO Auto-generated method stub
		
	}
	private void addMouseListener(Closer closer) {
		// TODO Auto-generated method stub
		
	}
	public void draw(Graphics win)
	{
		win.setColor(Color.green);
		super.fill(win);
		win.setColor(Color.black);
		super.draw(win);
		win.drawString("x", x+5,y+15);
	}
	//overwritten to remove functionality of base class
	public void resizeBy(int dw, int dh)
	{
		super.resizeBy(0, 0);
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) 
	{
		Scanner M = new Scanner(System.in);
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
