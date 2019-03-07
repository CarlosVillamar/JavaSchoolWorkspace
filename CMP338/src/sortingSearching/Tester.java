package sortingSearching;

public class Tester {

	//public static String [] vals = {"zebra","squirrel","monkey","elephant","dog","cat","antelope"};
	//public static String [] vals = {"cat","dig","fan","dog","fun","con","fin","can","dad","fit","foe","dot","elf","exe"};
	//public static Integer [] vals = {36,9,24,54,11,8,100, 15};
	//public static Double [] vals = {36.1,9.0,24.4,54.4,11.6,8.2,100.1, 15.2};
	
	//sorted arrays
	//public static String [] vals = {"antelope","cat", "dog", "elephant","monkey","squirrel","zebra"};
	public static Integer [] vals = {8, 9, 11, 15, 24, 36, 54, 100};
	//public static Double [] vals = {8.2, 9.0, 11.6, 15.2, 24.4, 36.1, 54.4, 100.1};
		
	public static void main(String[] args) {
		/*
		//SEARCHING
		//String val = "zoo";
		//int val = 11;
		//double val = 8.2;
		//int loc = SortingSearching.sequentialSearch(vals, val);//SEQUENTIAL SEARCH
		int loc = SortingSearching.binarySearch(vals, val, 0, (vals.length-1));//BINARY SEARCH
		System.out.println("location of: "+val+" is:"+loc);
		//System.out.println("Number of Steps "+SortingSearching.getNumSteps());
		*/
		
		//SORTING
		System.out.println("before sorting");
		SortingSearching.displayArr(vals);
		//SortingSearching.selectionSort(vals, vals.length);//SELECTION SORT
		SortingSearching.bubbleSort(vals);	//BUBBLE SORT
		//SortingSearching.insertionSort(vals);	//INSERTION SORT
		//SortingSearching.mergeSort(vals);		//MERGE SORT
		//SortingSearching.quickSort(vals, 0, vals.length-1);
		//SortingSearching.radixSort(vals);
		System.out.println("\n\nafter sorting");
		SortingSearching.displayArr(vals);
		//System.out.println("Number of Steps "+SortingSearching.getNumSteps());
		
	}


}
