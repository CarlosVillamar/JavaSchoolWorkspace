
package InClassGUI_Interface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class MyCalc extends JApplet implements ActionListener{
	
	JLabel sumLabel;
	JLabel difflabel;
	JLabel PROLabel;
	JLabel QuoLabel;
	JTextField tf1;
	JTextField tf2;
	JButton addBtn;
	JButton subBtn;
	JButton MultiBtn;
	JButton QuoBtn;

	
	public void init(){
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(5,2));
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
		sumLabel = new JLabel("the sum will appear here");
		difflabel = new JLabel("the difference is here");
		PROLabel = new JLabel("The product is here");
		QuoLabel = new JLabel("The quotient is here");
		jp.add(tf1);
		jp.add(tf2);
		jp.add(addBtn);
		jp.add(subBtn);	
		jp.add(MultiBtn);
		jp.add(QuoBtn);	
		jp.add(sumLabel);
		jp.add(difflabel);
		jp.add(PROLabel);
		jp.add(QuoLabel);	
		add(jp);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	//TODO Auto-generated method stub
	{ if(e.getActionCommand().equalsIgnoreCase("Add")){
		//System.out.print("the add button was clicked");
		int a = Integer.parseInt(tf1.getText());
		//System.out.print("val of a is " +a);
		int b = Integer.parseInt(tf2.getText());
	    //System.out.print("val of a " + a};
		int sum = a+b;
		///System.out.print("val of sum" + sum);
		sumLabel.setText("the sum is " + sum);
		//System.out.print("should be done);
	}
	if(e.getActionCommand().equalsIgnoreCase("Subtract")){
		//System.out.print("the add button was clicked");
		int a = Integer.parseInt(tf1.getText());
		//System.out.print("val of a is " +a);
		int b = Integer.parseInt(tf2.getText());
	    //System.out.print("val of a " + a};
		int sum = a-b;
		///System.out.print("val of sum" + sum);
		difflabel.setText("the diff is " + sum);
		//System.out.print("should be done);
	}
	if(e.getActionCommand().equalsIgnoreCase("Multiply")){
		//System.out.print("the add button was clicked");
		int a = Integer.parseInt(tf1.getText());
		//System.out.print("val of a is " +a);
		int b = Integer.parseInt(tf2.getText());
	    //System.out.print("val of a " + a};
		int sum = a*b;
		///System.out.print("val of sum" + sum);
		PROLabel.setText("the product is " + sum);
		//System.out.print("should be done);
	}
	if(e.getActionCommand().equalsIgnoreCase("Divide")){
		//System.out.print("the add button was clicked");
		int a = Integer.parseInt(tf1.getText());
		//System.out.print("val of a is " +a);
		int b = Integer.parseInt(tf2.getText());
	    //System.out.print("val of a " + a};
		int sum = a/b;
		///System.out.print("val of sum" + sum);
		QuoLabel.setText("the diff is " + sum);
		//System.out.print("should be done);
	}
	}}
