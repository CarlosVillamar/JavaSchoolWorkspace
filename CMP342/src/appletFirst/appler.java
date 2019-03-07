package appletFirst;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ActiveEvent;
import java.awt.Button;
import java.awt.Event;
import java.awt.Label;
import java.awt.TextField;
import java.applet.Applet;
import java.math.*;
import java.awt.*;

public class appler {
	

	public abstract class AreaofCircle extends Applet implements ActionListener
	{
		
		Label radiusLB = new Label ("radius");
		TextField radiusTF = new TextField("");
		Label resultLB = new Label("area");
		Button areaBN = new Button("find area");
		Button circleBN = new Button("find circle");
		

	public void init()
	{
		
		setLayout(null);
		radiusLB.setBounds(10,10,100,20);
		radiusTF.setBounds(10,30,100,20);
		resultLB.setBounds(10,60,100,20);
		areaBN.setBounds(10,90,100,20);
		
		AreaListener al = new AreaListener();
		CircleListener c1 = new CircleListener();
		
		add(radiusLB);
		add(radiusTF);
		add(resultLB);
		add(areaBN);
		add(circleBN,10,120);
	
		
		areaBN.addActionListener(this);
		circleBN.addActionListener(this);
		
		
	}
	public class AreaListener implements ActionListener
	{

		public void ActionPerfromed(ActionEvent e)
		{
			double radius = Double.parseDouble(radiusTF.getText());
			double area = Math.PI * radius * radius;
			
			resultLB.setText("area" + area);
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public class CircleListener implements ActionListener
	{
		
		public void ActionPerformed(ActionEvent e)
		{
			double radius = Double.parseDouble(radiusTF.getText());
			double circle = Math.PI * radius;
			resultLB.setText("circle =" + circle);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	/*public void ActionPerfromed(ActionEvent e)
	{
		double radius = Double.parseDouble(radiusTF.getText());
		
		if(e.getActionCommand().equals("find area"))
		{

		
		double area = Math.PI * radius * radius;
		
		resultLB.setText("area" + area);
		
		}
		else
		{
			double circle = Math.PI * radius;
			resultLB.setText("circle =" + circle);
			
		}*/		
	}
	}
	


