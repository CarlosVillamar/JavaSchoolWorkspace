package arrayPlay;

public class SearchingArray {


	private static double[] temperature = {97.0, 101, 85, 15,36,71.5, 56};
	private static String[] names = {"Me", "You", "He", "She", "Other"};
	
	private int[] someNumArr = new int [8];
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("the avg is " +getAverageOfNumbersInArray(temperature));
		System.out.println("the avg is " +getAverageOfTemperatures());
		
		/**System.out.println("The location is "+ getLocationOfMatch(15));//mid val test
		System.out.println("The location is "+ getLocationOfMatch(200));//no val test
		System.out.println("The location is "+ getLocationOfMatch(97));//first index test
		System.out.println("The location is "+ getLocationOfMatch(56));//last index test
	*/
	}
	
	
	public static double getAverageOfTemperatures()
	{
		double sum=0;
		double average=0;
		for(int i=0; i<temperature.length; i++)
		{
			sum += temperature[i];
		}
		average = sum / (temperature.length);
		/*
		 * Step 1: add all values
		 * Step 2: Divide the result from step1 by the total number of values (arr.length)
		 * Step 3: return the average
		 * */
		
		
		
		return average;
	}	
	public static double getAverageOfNumbersInArray(double [] arr){
		double sum=0;
		double average=0;
		
		for(int i=0; i<arr.length; i++){
			sum += arr[i];
		}
		average = sum / (arr.length);
		/*
		 * Step 1: add all values
		 * Step 2: Divide the result from step1 by the total number of values (arr.length)
		 * Step 3: return the average
		 * */
		
		return average;
	}
	
	public static int getLocationOfMatch(double x)
	{
		System.out.println("You are looking for "+x);
		int location = -1; //-1 does not exist as an index in any array
		int i=0;//first index of array
		while (x!=temperature[i])
		{
			if(i == (temperature.length-1))
			{
				return location;
			}
			i++;
		}
		location = i;
		return location;
	}
	
	
	public static int getLocationOfMatch(String x)
	{
		System.out.println("You are looking for "+x);
		int location = -1; //-1 does not exist as an index in any array
		int i=0;//first index of array
		while (!(x.equalsIgnoreCase(names[i])))
		{
			if(i == (names.length-1))
			{
				return location;
			}
			i++;
		}
		location = i;
		return location;
	}
	
	public static int getLocationOfMatch(double x, double[]arr)
	{
		System.out.println("You are looking for "+x);
		int location = -1; //-1 does not exist as an index in any array
		int i=0;//first index of array
		while (x!=arr[i])
		{
			if(i == (arr.length-1))
			{
				return location;
			}
			i++;
		}
		location = i;
		return location;
	}
	public static int[] doublethesize(int[]arr)
	{
		int [] bigArr = new int [2 * arr.length];
		for(int i=0; i < arr.length; i ++)
		{
			bigArr[i] = arr[i];
		}
		return bigArr;
	}
	
	public static void printContentsOFarr(int[]arr)
	{
		for(int i=0; i < arr.length; i ++)
		{
			System.out.println("value at" +i+ "is" + arr[i]);
		}
	}
}


