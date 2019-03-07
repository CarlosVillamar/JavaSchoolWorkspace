package BinarySearch;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import ExceptionDemo.WindowDestroyer;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileOrganizer extends JFrame implements ActionListener
{
public static final int WIDTH = 400;
public static final int HEIGHT = 300;
public static final int NUMBER_OF_CHAR = 30;
private JTextField fileNameField;
private JTextField firstLineField;

public FileOrganizer()
{
	setSize(WIDTH, HEIGHT);
	WindowDestroyer listener = new WindowDestroyer();
	listener.addWindowListener() ;
	Container contentPane = getContentPane();
	contentPane.setLayout(new FlowLayout());
	
	JButton showButton = new JButton("Show first line");
	showButton.addActionListener(this);
	contentPane.add(showButton);
	
	JButton removeButton = new JButton("Remove file");
	removeButton.addActionListener(this);
	contentPane.add(removeButton);
	
	JButton resetButton = new JButton("Reset");
	resetButton.addActionListener(this);
	contentPane.add(resetButton);
	
	JButton addButton = new JButton("Add a Line");
	addButton.addActionListener(this);
	contentPane.add(addButton);
	
	JButton copy = new JButton("copy file");
	copy.addActionListener(this);
	contentPane.add(copy);
	
	fileNameField = new JTextField(NUMBER_OF_CHAR);
	contentPane.add(fileNameField);
	fileNameField.setText("Enter file name here.");
	
	firstLineField = new JTextField(NUMBER_OF_CHAR);
	contentPane.add(firstLineField);
	}
public void actionPerformed(ActionEvent e)
{
	
	String actionCommand = e.getActionCommand();
	if (actionCommand.equals("Show first line"))
		showFirstLine();

	else if (actionCommand.equals("Remove file"))
		removeFile();
	else if (actionCommand.equals("Reset"))
		resetFields();
	else if (actionCommand.equals("Add a Line"))
		addFile();
	else if (actionCommand.equals("copy file"))
	{		copyfile();
			firstLineField.setText("success");
	}
	else
		firstLineField.setText("Unexpected error.");
}
private void showFirstLine()
{
	Scanner fileInput = null;
	String fileName = fileNameField.getText();
	File fileObject = new File(fileName);
	
	if (!fileObject.exists())
		firstLineField.setText("No such file");

	else if (!fileObject.canRead())
		firstLineField.setText("That file is not readable.");
else
{

	try
{

		fileInput = new Scanner(fileObject);
}
	catch(FileNotFoundException e)
{
		firstLineField.setText("Error opening the file " +
				fileName);
}
String firstLine = fileInput.nextLine();
firstLineField.setText(firstLine);
fileInput.close();
}
}
private void copyfile() 

{
	Scanner fileInput = null;
	String fileName = fileNameField.getText();
	File fileObject = new File(fileName);
	Scanner inputStream = null;
	PrintWriter outputStream = null; 
	String fileContents = "";

	try
	{
	inputStream = new Scanner (new File (fileName));
	outputStream = new PrintWriter (fileName);
	//outputStream = new PrintWriter (new FileOutputStream (outFile, true); //appends (adds) to already existing File.
	
	
	while (inputStream.hasNextLine())
	{
	int i = 1;
	fileContents = inputStream.nextLine();
	outputStream.println (i+" " + fileContents);
	
	}
	}
	catch (Exception e)
	{
	e.printStackTrace();
	}

	finally
	{
	inputStream.close();
	outputStream.close();
	}
	}
private void addFile() {
	// TODO Auto-generated method stub
	
	Scanner fileInput = null;
	String fileName = fileNameField.getText();
	File fileObject = new File(fileName);
	PrintWriter printWriter = null;
	String newline = ("Hi There");
	

	 try {
	        if (!fileObject.exists())
	        	fileObject.createNewFile();
	        printWriter = new PrintWriter(new FileOutputStream(fileName, true));
	        printWriter.write(newline);
	    } 
	 catch (IOException e)
	 {
		 	e.printStackTrace();
	 } 
	 finally 
	 {
	        if (printWriter != null) 
	        {
	            printWriter.flush();
	            printWriter.close();
	        }
	   }
	}

private void resetFields()
{
	fileNameField.setText("Enter file name here.");
	firstLineField.setText("");
}
private void removeFile()
{
	Scanner fileInput = null;
	String firstLine;
	String fileName = fileNameField.getText();
	File fileObject = new File(fileName);
	if (!fileObject.exists())
	firstLineField.setText("No such file");
	else if (!fileObject.canWrite())
		firstLineField.setText("Permission denied.");
	else
	{
		if (fileObject.delete())
			firstLineField.setText("File deleted.");
	else
		firstLineField.setText("Could not delete file.");
	}
	}
public static void main(String[] args)
{
FileOrganizer gui = new FileOrganizer();
gui.setVisible(true);
}
}



