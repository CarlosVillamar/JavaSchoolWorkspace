package Recursion;

public class Ch3_example2 {
	public static void main(String[] main)
	{// boxtrace all of these examples
		System.out.println(rabbit(4));
		writeBack("loop");
	}

	public static void writeBack(String s)
	{
		if(s.length()==1)
		{
			System.out.println(s);//print out entire string backwards
			
		}
		else
		{ //recursive call
			// s.substring(0, s.length-1)
			System.out.print(s.substring(s.length()-1));//prints last character		
			writeBack(s.substring(0, s.length()-1));//Pass string without the last character
	
		}
	}
	
	
	public static int rabbit(int n)
	{
		if(n<=0)
		{//recursive call does 4 = 0, no 
			return 1;
			
		}
		else if(n==1)
		{//recursive call does 4 = 1, no
			return 1;
		}
		else 
		{//recursive call rabbit(4-1) + rabbit(4-2) = 3 + 2 +5
			return rabbit(n-1) + rabbit(n-2);
		}
		
	
}
}
