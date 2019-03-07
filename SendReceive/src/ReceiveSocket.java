import java.net.*;
import java.awt.*;
import java.io*;
import java.awt.event.*;

public class ReceiveSocket extends SocketChat implements ActionListener, Runnable {
	
	TextArea logTA = new TextArea();
	TextArea logTA = new TextArea();
	TextField messageTF = new TextField();
	Button sumbit = new Button(Submit);
	
	list recieveLT = new List();
	
	DataInputStream input;
	DataOutputStream output;
	
	/////////////////////////////////////////////
	
	private static InetAddress myAddress = null;

	public static void main(String[] args) {

		try {
			myAddress = InetAddress.getLocalHost();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		System.out.println("My Address = " + myAddress.getHostAddress());

		DatagramSocket inSocket = null;
		byte[] inBuffer = new byte[1000];
		DatagramPacket inPacket = new DatagramPacket(inBuffer, inBuffer.length);
		
		try {
			inSocket = new DatagramSocket(64000, myAddress);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		do {
			for ( int i = 0 ; i < inBuffer.length ; i++ ) {
				inBuffer[i] = ' ';
			}
			
			try {
				// this thread will block in the receive call
				// until a message is received
				System.out.println("Waiting for input...");
				inSocket.receive(inPacket);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
			
			String message = new String(inPacket.getData());
			System.out.println("Received message = " + message);
			
		} while(true);
	}
}
