package chat;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Server {

	public static final int n = 10;
	public static int N = 3;
	
	ServerSocket server;
	ClinetHandler[] clinethandler = ClinetHandler[n];
	public static void main(String[] args)
	{
		Server server = new Server();
		
		server.init();
	
	}
	public void init()
	{
		try
		{
			server = new ServerSocket(8080);
			for (int i = 0; i < n; i++)
			{
				clinethandler[i] = new ClinetHandler[i];
			}
			catch(IOException e){}
			
		}
		public class ClinetHandler implements Runnable
		{
			DataInputStream = input;
			DataOutputStream = output;
		
		public ClinetHandler
		{ 
				Socket socket = server.accept();
				
				input	= 	new DataInputStream(socket.getInputStream());
				output  =   new DataOutputStream(socket.getOutputStream());
			
			
		}
		public void run() 
		{
		while(true)
		{
			try
			{
				String message = input.readUTF;
				for (int i = 0; i < n; i++)
					//if(clienthandler[i] != this)
					
					clinetHandler[i].output.writeUTF(message);				
			}
			catch(IOException x){}
		}
		}
		
		

