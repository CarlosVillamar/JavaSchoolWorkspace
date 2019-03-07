package chat;

import java.io.*;
import java.applet.*;
import java.net.*;
import java.awt.event.*;
import java.awt.*;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class GUIserver extends AppletNLO implements ActionListener, Runnable {

	TextArea 	logTA = 		new TextArea();
	TextField 	messageTF = 	new TextField();
	Button 		submitBN = 		new Button("submit");
	
	DataInputStream input;
	DataOutputStream output;
	
	public GUIserver()
	{
		super();
	}
	public void init()
	{
		add(logTA,		10,	 10, 800,	400);
		add(messageTF,	10, 420, 600,	 20);
		add(submitBN,  700, 420, 100,	 20,	this);
		
		
	try 
	{
		ServerSocket server = new ServerSocket(8080);
		Socket socket = server.accept();
		input = new DataInputStream(socket.getInputStream());
		output = new DataOutputStream(socket.getOutputStream());
	}
	
	catch(IOException x){}
	
	Thread t = new Thread(this);
	
	}
	public void run()
	{
		String message;
		
		while(true)
			try {
				message = input.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void add(TextField messageTF2, int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		
	}
	private void add(Button submitBN2, int i, int j, int k, int l,
			GUIserver guIserver) {
		// TODO Auto-generated method stub
		
	}
	private void add(TextArea logTA2, int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{	// TODO Auto-generated method stub
		
		try
		{
			output.writeUTF(messageTF.getText());
			logTA.appendText(messageTF.getText() + "\n");
			messageTF.setText("");
			
		}
		
		catch(IOException x){}
		
		
	}
	
	

}