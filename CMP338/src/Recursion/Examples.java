package Recursion;

public class Examples {
	
	public static void main(String[] args)
	{
		int[] arr = {31,39,23,26,65};
		int val = 65;
		System.out.println("found "+ val + " at location " + sequentialSearch(val,arr,0));
		
		System.out.println("found "+ val + " at location " + binarySearch(val, arr, 0,4));
		/**System.out.println(fact(5));
		writeBack("cats");
		System.out.print(rabbit(5));
		System.out.println(findMaxInArray(arr,0,4));
		
		for(int i=0; i<3;i++)
		{
			System.out.println("Calling fib now"+ i +"\n\n");
			System.out.print(rabbit(7));
			
		}
		int [] arr={31,39,23,54,26,65,15,99,42};
		int k = 3;
		System.out.println("the"+ k +"smallest"+ findKsmall(k,arr,0,arr.length-1));
		*/
		
	}
		
		/**
		 * 
		 * @param val
		 * @param arr
		 * @return location of the value found
		 * @return -1 if not in the array
		 */
	
	public static int sequentialSearch(int val,int[] arr, int start)
	{
		if(start>=arr.length)
		{ return -1;//value not in the array or wrong start passed in 
			
		}
		else if(arr[start] == val)
		{
			return start;//found the match at current location
			
		}
		else 
		{
			return sequentialSearch(val, arr, start+1);
		}
	}
	/**
	 * *
	 * @param val
	 * @param arr
	 * @param start(
	 * @param end(length-1)
	 * @return
	 */
	public static int binarySearch(int val, int[] arr, int start, int end)
	{	//do we want to put the midpoint calculation here?
		if (start > end)
		{
			return -1;
		}
		else
		{//do we want to put the midpoint calculation here?
			// we want to calculate it here to save a step
			int midpt = (start + end/2 );
			if (val == arr[midpt])
			{
				return midpt;
			}
			//either go left or go right
			else if(val < arr[midpt])
			{
				return binarySearch(val, arr, start, midpt-1);
			}
			else 
			return binarySearch(val, arr, midpt+1, end-1);
		}
			
		}
		/**
		 * factorial 
		 * f(n) =n*f(n-l)
		 */
		public static int fact(int n)
		{	int i =n+1;
			do
			n = n*(n-1);
			while(n<i);
			System.out.print(n);
			
			if (n==0)
			{
				return 1;//base case..
					
			}
			return n;		
		}
	/**
	 * 
	 * @param s
	 * base case length -1
	 */
	public static void writeBack(String s)
	{
		if(s.length()==1)
		{
			System.out.println(s);//print out entire string backwards
			
		}
		else
		{//recursive call
			// s.substring(0, s.length-1)
			System.out.print(s.substring(s.length()-1));//prints last character
			writeBack(s.substring(0, s.length()-1));//Pass string without the last character
			
		}
	}
	public static void writeBack2(String s)
	{
		if(s.length()==1)//base case..last char
		{
			System.out.print(s);//prints s
		}
		else
		{
			writeBack(s.substring(1));//cats ats ts s
			System.out.println(s.charAt(0));//print the first char
			
		}
	}
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int rabbit(int n)
	{
		if(n<=0)
		{
			return 1;
			
		}
		else if(n==1)
		{
			return 1;
		}
		else 
		{
			return rabbit(n-1) + rabbit(n-2);
		}
		
	}
	public static int findMaxInArray(int[] arr, int start,int end)
	{///this is how you find the max in an unsorted array
		
		if(start<end)//went too far something is wrong
		{	
			System.out.print(" It's not here.. ");
		
		}
		else if (start==end)
		{	
			return arr[start];//last value to look at
		}	
			int midpt = (start+end)/2;
			return (Math.max(findMaxInArray(arr, start, midpt), findMaxInArray(arr,midpt+1,end)));
	}
	private static void swap(int[] arr,int j, int i)
	{	
			int z =arr[i];
			arr[i]=arr[j];
			arr[j]=z;
			
	}
	private static int partitionArray(int[] arr, int first, int last)
	{
		int pivot = arr[first];
		int pp = first;//pivotposition 
		first++;
		while(first <= last)//scan from the first..going rightward
		{
			while((first <= last)&& (arr[first]<pivot))
			{
				first++;
			}
			while((first <= last)&&(arr[last]>pivot))
			{	last--;
			
			}
			if(first>last)
			{//swap(arr,pp,last);we need to move our pivot to the rgiht location
				swap(arr,pp,last);
			}
			else 
			{
				swap(arr,first,last);
			}
		}
		return last;
	}
	public static int findKsmall(int k, int[] arr,int first,int last)
	{
		int pivot = partitionArray(arr,first,last);
		if(pivot == (k-1))
		{
			return( arr[k-1]);//found it
		}
		else if((k-1) < pivot)
		{
			return findKsmall(k,arr,first,pivot-1);
		}
		else 
		{
			return findKsmall(k,arr,first-1,last);
		}
	}
}
	
	//Math.max(x,y) does a comparison to get the max of two numbers
	//Math.min(x,Y) does the opposite
		/**public static void writeBackIteraExamp(String s)
		{
			for(int i = s.length()-1;i>=0;i--)
			{
				System.out.println(s.charAt(i));
			}
		}*/
		
	

