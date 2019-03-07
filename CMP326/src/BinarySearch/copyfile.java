package BinarySearch;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JTextField;

public class copyfile {
	private JTextField fileNameField;
	Scanner fileInput = null;
	String fileName = fileNameField.getText();
	File fileObject = new File(fileName);
	PrintWriter printWriter = null;
	
	public static void addLineNumberToOutFile (String inFile, String outFile)
	{
		Scanner inputStream = null;
		PrintWriter outputStream = null;
		String fileContents = "";

	try
	{
		inputStream = new Scanner (new File (inFile));
		outputStream = new PrintWriter (outFile);
		//outputStream = new PrintWriter (new FileOutputStream (outFile, true); //appends (adds) to already existing File.
		
	while (inputStream.hasNextLine())
	{
		fileContents = inputStream.nextLine();
		outputStream.println (" " + fileContents);
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
}
