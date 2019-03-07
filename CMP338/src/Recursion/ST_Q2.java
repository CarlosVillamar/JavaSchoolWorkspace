package Recursion;

import java.util.Scanner;
import java.util.function.*;

public class ST_Q2
{
	public static void main(String[] args)
	{	Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a Number: ");
		int n = keyboard.nextInt();
		System.out.print(countDown(n));
		
	}
	
	public static int countDown(int n)
	{
		do
		{	System.out.print(n + " ");
			n--;
		} 
		while(1<n);
		
		return n;
	}
	

}
