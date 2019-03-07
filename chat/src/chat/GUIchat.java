package chat;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



public abstract class GUIchat extends AppletNLO 
implements ActionListener,ItemListener, Runnable
{
	
		TextArea logTA = new TextArea();
		TextField messageTF = new TextField();
		Button submitBN = new Button("submit");
		TextField nameTF = new TextField();
		
		List onlineLT = new List();
		List friendsLT = new List();
		
		
		DataInputStream input;
		DataOutputStream output;
		
		public GUIchat()
		{
			super();
			
		}
		
		public void init()
		{
			setupGUI();
			
			setupConnect();
			
			SUInputThread();
		}
		
		public void setupGUI()
		{
			add(logTA,		10,	 10, 800,	400);
			add(messageTF,	10, 420, 600,	 20, 	this);
			add(nameTF,  700, 420, 100,	 20,		this);
			
			//add(submitBN,  700, 420, 100,	 20,	this);
			
			add(onlineLT,  320,  10, 100,  100);
			add(friendsLT, 320, 120, 100, 100);
		
			onlineLT.add("Pedro");
			onlineLT.add("Aysmel");
			onlineLT.add("Brian");
			
			onlineLT.addItemListener(this);
			friendsLT.addItemListener(this);
			
			
			
			friendsLT.add("Pedro");
			friendsLT.add("Aysmel");
		}
			
			public void setupConnect()
			{
			
			
			try
			{
				//Socket socket = new Socket("localhost", 8080);
				Socket socket = connect();
				
				input = new DataInputStream(socket.getInputStream());
				output = new DataOutputStream(socket.getOutputStream());
				
			}
			
			catch(IOException x){}
			}

		
		
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			
			try 
			{
				
				output.writeUTF(nameTF.getText() +  ":" + messageTF.getText());
				
				logTA.appendText(nameTF.getText() + ":" + messageTF.getText() + " \n");
				
				messageTF.setText("");
			
			} 
			catch (IOException x) 
			{
				// TODO Auto-generated catch block
				x.printStackTrace();
			}
		}
		
		public class OnlineListener implements ItemListener
		{
			public void itemStateChanged(ItemEvent z)
			{
				friendsLT.add(onlineLT.getSelectedItem());
			}
		}
		public class FriendListener implements ItemListener
		{
			public void itemStateChanged(ItemEvent z)
			{
				
				
				friendsLT.remove(friendsLT.getSelectedIndex());
				
			}
				
		}	
		public abstract Socket connect() throws IOException;
		
			
		public void SUInputThread()
		{
			Thread t = new Thread(this);
			t.start();
		}
	
		public void run()
		{
		
			String message;
		
		while(true)
		{
			try
			{
				 message = input.readUTF();
				 logTA.append(message + "\n");
			}
			catch(IOException x){}
		}
		
		}
		
	
}

