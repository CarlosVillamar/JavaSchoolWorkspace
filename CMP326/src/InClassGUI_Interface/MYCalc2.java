package InClassGUI_Interface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MYCalc2 extends JApplet implements ActionListener{
	
	JLabel ResultLabel;
	JTextField tf1;
	JTextField tf2;
	JButton addBtn;
	JButton subBtn;
	JButton MultiBtn;
	JButton QuoBtn;

	
	public void init(){
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(5,5));
		tf1 = new JTextField("");
		tf2 = new JTextField("");
		addBtn = new JButton("ADD");
		addBtn.addActionListener(this);
		subBtn = new JButton("Subtract");
		subBtn.addActionListener(this);
		MultiBtn = new JButton("Multiply");
		MultiBtn.addActionListener(this);
		QuoBtn = new JButton("Divide");
		QuoBtn.addActionListener(this);
		ResultLabel = new JLabel("the result will appear here");
		
		jp.add(tf1);
		jp.add(tf2);
		jp.add(addBtn);
		jp.add(subBtn);	
		jp.add(MultiBtn);
		jp.add(QuoBtn);	
		jp.add(ResultLabel);
		add(jp);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	//TODO Auto-generated method stub
	{
	int a = Integer.parseInt(tf1.getText());
	int b = Integer.parseInt(tf2.getText());
	
	if(e.getActionCommand().equalsIgnoreCase("ADD")){
		ResultLabel.setText("the sum is "+ MyMath.myadd(a, b));
	}
	if(e.getActionCommand().equalsIgnoreCase("Subtract")){
		ResultLabel.setText("the different is "+ MyMath.mysub(a, b));
	}
	if(e.getActionCommand().equalsIgnoreCase("Multiply")){
		ResultLabel.setText("the product is "+ MyMath.myproduct(a, b));
	}
	if(e.getActionCommand().equalsIgnoreCase("Divide")){
		ResultLabel.setText("the quotent is "+ MyMath.myQuo(a, b));
	}
	
	
	
	
	}}

	
	//if(e.getActionCommand().equalsIgnoreCase("Add")){
		//System.out.print("the add button was clicked");
		//int a = Integer.parseInt(tf1.getText());
		//System.out.print("val of a is " +a);
		//int b = Integer.parseInt(tf2.getText());
	    //System.out.print("val of a " + a};
		//int sum = a+b;
		///System.out.print("val of sum" + sum);
		//sumLabel.setText("the sum is" + sum);
		//System.out.print("should be done);
	//if(e.getActionCommand().equalsIgnoreCase("Subtract")){
		//System.out.print("the add button was clicked");
		//int a = Integer.parseInt(tf1.getText());
		//System.out.print("val of a is " +a);
		//int b = Integer.parseInt(tf2.getText());
	    //System.out.print("val of a " + a};
		//int sum = a-b;
		///System.out.print("val of sum" + sum);
		//difflabel.setText("the diff is" + sum);
		//System.out.print("should be done);
	
	//if(e.getActionCommand().equalsIgnoreCase("Multiply")){
		//System.out.print("the add button was clicked");
		//int a = Integer.parseInt(tf1.getText());
		//System.out.print("val of a is " +a);
		//int b = Integer.parseInt(tf2.getText());
	    //System.out.print("val of a " + a};
		//int sum = a*b;
		///System.out.print("val of sum" + sum);
		//PROLabel.setText("the product is" + sum);
		//System.out.print("should be done);
	
	//if(e.getActionCommand().equalsIgnoreCase("Divide")){
		//System.out.print("the add button was clicked");
		//int a = Integer.parseInt(tf1.getText());
		//System.out.print("val of a is " +a);
		//int b = Integer.parseInt(tf2.getText());
	    //System.out.print("val of a " + a};
		//int sum = a/b;
		///System.out.print("val of sum" + sum);
		//QuoLabel.setText("the diff is" + sum);
		//System.out.print("should be done);
	

