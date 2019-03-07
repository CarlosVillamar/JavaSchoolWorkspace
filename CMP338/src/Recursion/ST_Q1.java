package Recursion;



public class ST_Q1 {
	public static void main(String[] args)
	{	

		double[] array = {45,12,23,89,76};
		System.out.print(product(array,5));
		
	}
	public static double product(double anArray[], int n)
	{	
		//postcondition 1<= n <= max size of anArray
		//Postcondition:Returns the product of the first n items of an Array, anAray remains unchanged
		if(n==1)
		{
			return anArray[0];
		}
	
			return anArray[n-1]*product(anArray,n-1);
	}
}
