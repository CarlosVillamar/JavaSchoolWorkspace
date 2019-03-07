package Recursion;

public class ST_Q3 {
	public static void main(String[] args)
	{
		int array[] = {1,2,3,4,5,6,7,8,9};
		System.out.println(compute(array,0,8));
		
	}
	public static int compute(int[] array,int start, int end)
	{	int result = 0;
	if(start==end)
	{	
		result = array[start];	
	}
	else 
		System.out.println(result = array[end] * compute(array,start,end-1));
		
	return result;
	}

}
