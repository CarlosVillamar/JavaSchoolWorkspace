package Recursion;

public class ST_Q5 {
	public static void main(String[] args)
	{
		//System.out.println(spock(5,1));
		System.out.println(spock(4,2));
		//when the first number is smaller than the second the result will be 0
	}
	
	public static int spock(int y, int x)
	{
		if((x == 0) || (x == y))
		{///print
			System.out.println(x & y);
			return 1;
		}
		else if (x>y)
		{	//print
			System.out.println(x & y);
			return 0;
		}
		else //print
			System.out.println(x & y);
			return spock(y-1,x-1)+ spock(y-1,x);
	}	
}
