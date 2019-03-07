package ExceptionDemo;
import java.util.Scanner;


public class ExceptionDemo {

	public static void main(String[] args)
	{
	Scanner keyboard = new Scanner(System.in);
	try
	{ System.out.println("Enter number of donuts:");
	int donutCount = keyboard.nextInt();
	System.out.println("Enter number of glasses of milk:");
	int milkCount = keyboard.nextInt();
	
	if (milkCount < 1)
		throw new DividedByZero();
	
	/*if (milkCount < 2)
		throw new Exception("Exception: Short on milk!");*/
	
	if (milkCount < 2)
		throw new MilkEx();
	
		
	double donutsPerGlass = donutCount / (double)milkCount;
		System.out.println(donutCount + " donuts.");
		System.out.println(milkCount + " glasses of milk.");
		System.out.println("You have " + donutsPerGlass +
		" donuts for each glass of milk.");
	}
	
		catch(MilkEx e)
	{
			System.out.println(e.getMessage());
			System.out.println("Go buy some milk.");
	}
		catch(DividedByZero e)
		{
		System.out.println(e.getMessage());
		System.out.println("Go buy some milk.");
		}
	
		
		catch(Exception e) //if the general exception is first, it will gain priority over the other exceptions 
		{
			System.out.println(e.getMessage());
			System.out.println("Go buy some milk.");
		}
	
	System.out.println("End of program.");
	}
	
	}
