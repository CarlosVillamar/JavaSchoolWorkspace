package Recursion;

public class ABrecursion {
	public static void main (String[] args)
	{	
		countdown(10);
		
	}
	public static void countdown(int num)
	{
	if (num == 10)
	{
	System.out.println();
	}
	else
	{
		countdown(num + 1);
	System.out.print(num);
	
	}
	}
	public static int IntsRecurse(int a, int b)
	{
		if(a == 0)
		{
			return b;
			
		}
		else 
		{
			 int currentsum = IntsRecurse(a-1,b+1);
			return currentsum;
		}
	}
}
