package Recursion;

public class arrSwap
{
	public static void main()
	{	int[] arr = new int[20];
		swap(arr,2,4);
		System.out.print(arr[2]);
		System.out.print(arr[4]);
	}
		
	public static void swap(int[] arr,int i, int j)
	{	
			int z =arr[i];
			arr[i]=arr[j];
			arr[j]=z;
			
	}
	
	 
}
