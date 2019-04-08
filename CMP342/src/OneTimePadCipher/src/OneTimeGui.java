
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


public class OneTimeGui extends AppletNLO implements ActionListener
{
	   Label   Message   = new Label("message");
	   Label key = new Label ("Key");
	   Label cypher = new Label("cypher");
	   TextField  key2 = new TextField();
	   TextField  cypher2    = new TextField();
	   TextField  M2 = new TextField("M2");
	   Button Encrypt = new Button("Encrypt");
	   Button Decrypt = new Button("Decrypt");
	   
	   String message;
	   String Key;
	   
	   public OneTimeGui()
	   {
		   super();
	   }
	   
	   public void init()
	   {
		   GUI();
		   
		 
		
	   }
	   
	   
	   
	private void GUI() 
	{
		add(Message, 10,10,70,30);
		add(M2, 10, 50,300,100);
		add(key, 10,220, 50, 20);
		add(key2, 10, 240, 50, 20);
		add(cypher,  10, 320,  50, 20);
		add(cypher2, 10, 340, 50, 20);
		add(Encrypt, 400, 10,  100, 50, this);
		add(Decrypt, 400, 100, 100, 50, this);
		
	}

	


	public void actionPerformed(ActionEvent al) 
	{
		// TODO Auto-generated method stub
		
		if(al.getActionCommand().equalsIgnoreCase("Encrypt"))
				{
					
					message = M2.getText();
					Key = OneTime2.genKey(message.length());
					String keyString = OneTime2.encrypt(message, Key);
					key2.setText(keyString);
				}
		
		if(al.getActionCommand().equalsIgnoreCase("Decrypt")){
				
				message = M2.getText();
				String keyString2 = OneTime2.decrypt(message, Key); 
				cypher2.setText(keyString2);
		}
	
}}
