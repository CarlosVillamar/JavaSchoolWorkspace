package Recursion;

public class CH3_Example1 {
	public static void main(String[] args)
	{
		int arr[] = {1,2,4,4,5,4,7,8,9};
		System.out.println(getNumberEq(arr,9,4));
	}
	public static int getNumberEq(int arr[], int n, int val)
	{/**
		 * getNumberEq method has clear criertia in its method
		 * (the array it's self, the number of values in the array we are searching, the number we are looking for)
		 */
		if(n<=0)// if the number of values in array is less than or equal to zero return zero
			//makes no sense if there are no items in the array
		{
			return 0;
		}
		else
		{
			if(arr[n-1]==val)
			{//if the item in the array is equal to the value we are looking for we will add to a count of how many times it will appear
				return getNumberEq(arr,n-1,val)+1;
				
			}
			else
				return getNumberEq(arr,n-1,val);
		}
		
		
		
	}

}
