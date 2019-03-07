package chat;
import java.applet.Applet;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class GUIclinet extends AppletNLO implements ActionListener  
	{
		TextArea logTA = new TextArea();
		TextField messageTF = new TextField();
		Button submitBN = new Button("submit");
		
		DataInputStream input;
		DataOutputStream output;
		
		public GUIclinet()
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
				Socket socket = new Socket("localhost", 8080);
				
				input = new DataInputStream(socket.getInputStream());
				output = new DataOutputStream(socket.getOutputStream());
				
			}
			
			catch(IOException x)
			{
				
			}
		}

		private void add(TextField messageTF2, int i, int j, int k, int l) {
			// TODO Auto-generated method stub
			
		}

		private void add(Button submitBN2, int i, int j, int k, int l,
				GUIclinet guIclinet) {
			// TODO Auto-generated method stub
			
		}

		private void add(TextArea logTA2, int i, int j, int k, int l) {
			// TODO Auto-generated method stub
			
		}

		
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			
			try {
				output.writeUTF(messageTF.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			logTA.appendText(messageTF.getText() + " \n");
			
			messageTF.setText("");
		}	
		
	}

	
