import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;
import java.net.*;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JLabel;


public class Server extends JFrame {

	private JPanel contentPane;
	private javax.swing.JButton btnsend;  
	private javax.swing.JLabel jLabel1;  
	private javax.swing.JLabel jLabel2;  
	private javax.swing.JScrollPane jScrollPane1;  
	private static javax.swing.JTextArea txtbxarea;  
	//private static javax.swing.JTextField replyBox;  

	//java.net vars
	static ServerSocket sersock;
	static Socket socket;
	static DataInputStream Dinput;
	static DataOutputStream Doutput;
	private JTextField textField;
	private JTextArea textArea;
	static JTextField replyBox = new JTextField();
	/**
	 * @wbp.nonvisual location=347,29
	 */
	private final JLabel label = new JLabel("New label");
	
	
	
	/**
	 * Create the frame.
	 */
	public Server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		replyBox.setBounds(15, 503, 642, 75);
		contentPane.add(textField);
		replyBox.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(674, 503, 172, 52);
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(15, 39, 661, 400);
		contentPane.add(textArea);
		
		JList list = new JList();
		list.setBounds(688, 65, 200, 200);
		contentPane.add(list);
	}
private void btnsendActionPerformed(java.awt.event.ActionEvent evt){
		
		try
		{
			String message =" ";
			message = replyBox.getText().trim();
			Doutput.writeUTF(message);
		}
		catch (Exception e)
		{
			
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Server().setVisible(true);
			String message = "";
				
				try {
					sersock = new ServerSocket(8080);
					socket = sersock.accept();
					Dinput = new DataInputStream(socket.getInputStream());
					Doutput = new DataOutputStream(socket.getOutputStream());  
		            while(!message.equals("exit"))  
		            {  
		                message = Dinput.readUTF();  
		                replyBox.setText(replyBox.getText().trim()+"\n Client:"+message);  
		            }  
					
					Server frame = new Server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
