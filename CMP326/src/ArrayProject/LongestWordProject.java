package ArrayProject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;



@SuppressWarnings("serial")
public class LongestWordProject extends JApplet implements ActionListener 
{
	public String LWord;//private?
	//public String LWords;//private?
	//public double[] lword;//Private?
	
	JLabel L1;//"In one sentence tell me what is on your mind today.
	JLabel L2;//display all the longest words in session
	static JTextField tf1;//allows user to type in the answer
	JButton b1;//submits answer
	JButton b2;//request all longest words in session
	
	public void init()
	{
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(5,2));
		tf1= new JTextField("");
		b1 = new JButton("Submit Your Answer");
		b1.addActionListener(this);
		b2 = new JButton("Find the longest word!!!");
		b2.addActionListener(this);
		L1 = new JLabel("In one sentence tell me what is on your mind today");
		L2 = new JLabel("The Longest word or words are");
		jp.add(tf1);
		jp.add(b1);
		jp.add(b2);
		jp.add(L1);
		jp.add(L2);
		add(jp);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equalsIgnoreCase("Submit Your Answer"))
		{
			LWord = tf1.getText();
			L1.setText(LWord);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Find the longest word!!!"))
		{	
			LWord = tf1.getText();
			String Long = new String();
			String[ ] Words = LWord.split(" ");
		
			for(int i = 0; i< LWord.length(); i++)
			{		
				if(Long.length() <Words[ i ].length())
			
					Long = Words[i];
				L2.setText(Long);
			}
		
		}
	}
}
			
	





	
	/*for (String LWord:.split(" ")) {
	    System.out.println(LWord);
	}}}}
				//LWords = LWords+", "+ LWord;
				//String Long = tf1.getText();
				if(LWord.length() == 3)
				{
					for(String LWord:LWord.split("-"))
					{
						L2.setText("Tell me more about longestword please" + "  "+ LWord);
					}

					
					
				}
					
					if(LWord.length() == 4)
					{
					
						for(String LWord:LWord.split("-"))
						{
						L2.setText("Why do you feel longestword" +"   "+  lword +"   "+ "is important" + LWord);
						
						}
					}
					if(LWord.length() == 5)
					{
						for(String LWord:LWord.split("-"))
						{
						
						L2.setText("how does longest word affect you"+ " "+ LWord);
						}
					}
					else if(LWord.length() >= 5)
					{
						for(String LWord:LWord.split("-"))
						{
					
						L2.setText("We seem to be making great progress with longest word"+" "+ LWord);
						}
					
					
					else if(LWord.length() <= 3)
					{
						for(String LWord:LWord.split("-"))
						{
						L2.setText("is there something else you would like to discuss"+" "+ LWord);
					}
					}
					
				}
		}
		}*/
	