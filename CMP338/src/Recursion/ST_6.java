package Recursion;

public class ST_6 //towers of hanoi
{
	public static void main(String[] args)
	{	ST_6 tower = new ST_6();//Towers of hanoi example
		ST_6.solveTowers(3,'a','c','b');
	}
	
	public static void solveTowers(int count,char source,char destination,char spare)
	{//number if steps(count) is 2^n-1
		//can be a string also just change the conditions 
		int i = 0;
		if (count== 1)
		{	System.out.println(source);
			System.out.println(destination);
			System.out.println(spare);
			//i++;
			//System.out.println(i);
			System.out.println("Move top disk from pole " + source + " to pole " + destination);
		}
		else 
		{
			solveTowers(count-1, source,spare,destination);
			solveTowers(1,source,destination,spare);
			solveTowers(count-1,spare,destination,source);
			
			
		}
			
	
	}

}
