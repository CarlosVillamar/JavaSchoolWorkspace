package sortingSearching;

public class SortingSearching {
	
	//linear Search | sequential Search
	/**
	 * Precondition: unsorted or sorted array... doesn't matter
	 * will visit every index until match is found
	 * @param arr
	 * @param match
	 * @return index, or -1 if not found
	 * Worst Case Runs k = O(n)   
	 */
	public static <T extends Comparable<? super T>>int sequentialSearch(T [] arr, T match){
		for(int i=0; i<arr.length; i++){
			if(match.equals(arr[i])){
				return i;
			}
		}
		return -1;
	}
	
	//binary Search 
	/**
	 * Precondition: sorted array
	 * @param arr
	 * @param match
	 * @param start index
	 * @param end index
	 * @return index, or -1 if not found
	 * Worst Case Runs k = O(logn) base2
	 */
	public static <T extends Comparable<? super T>>int binarySearch(T [] arr, T match, int start, int end){
		if(start > end){
			return -1;//start passed end.. value not found
		}
		else{
			int mp = (start+end)/2; //midpoint
			if(match.equals(arr[mp])){
				return mp;
			}
			else if(match.compareTo(arr[mp]) < 0){//match is less than val at mp
				return binarySearch(arr, match, start, mp-1); //shift focus to left of mp by changing end
			}
			else{//match is greater than val at mp
				return binarySearch(arr, match,mp+1, end);//shift focus to right of mp by changing start
			}
		}
		
	}
	/**
	 * 
	 * @param i
	 * @param j
	 * @param anArray
	 */
	private static <T extends Comparable<? super T>> void interchange(int i, int j, T[] anArray){
		T temp = anArray[j];
		anArray[j] = anArray[i];
		anArray[i] = temp;
	}
	
	
	/**
	 * BUBBLE SORT
	 * @param arr
	 *  Worst Case Runs k = O(n^2) base2 .... but this runs slightly slower than selection sort
	 */
	public static <T extends Comparable<? super T>> void bubbleSort(T [] arr){
		boolean notSorted = true;
		while(notSorted){
			notSorted=false;//inside the nested for loop we'll determine if we need to pass again
			for(int i=0; i<arr.length-1; i++){
				int j=i+1;
				if(arr[i].compareTo(arr[j]) > 0){
					interchange(i, j, arr);
					notSorted=true;
				}
			}
		}
	}
	
	private static <T extends Comparable<? super T>> int getIndexOfMin(int start, T [] anArr){
		T min = anArr[start]; // min
		int indexOfMin = start;
		for(int index = start+1; index<anArr.length; index++){
			if(anArr[index].compareTo(min) < 0){ //found a smaller min
				min = anArr[index];
				indexOfMin = index;
			}
		}
		return indexOfMin;
	}
	//selection sort
	/**
	 * uses helper getIndexOfMin
	 * @param arr
	 * Worst Case Runs k = O(n^2) base2  ... slightly faster than bubble sort
	 */
	public static <T extends Comparable<? super T>> void selectionSort(T [] arr){
		for(int index=0; index<arr.length-1; index++){
			int indexOfNextSmallest = getIndexOfMin(index, arr);
			interchange(index, indexOfNextSmallest, arr);
		}
	}
	/**
	 * helper method used by mergesort
	 * @param anArr
	 * @param firstH
	 * @param lastH
	 */
	private static <T extends Comparable<? super T>> void divide(T[] anArr, T[]firstH, T[]lastH){
		for(int i=0; i<firstH.length; i++){
			firstH[i] =anArr[i];
		}
		for(int i=0; i<lastH.length; i++){
			lastH[i] = anArr[firstH.length+i];
		}
	}
	/**
	 * helper method used by mergesort
	 * @param anArr
	 * @param firstH
	 * @param lastH
	 */
	private static <T extends Comparable<? super T>> void merge(T[] anArr, T[]firstH, T[]lastH){
		int indexFH =0;
		int indexLH =0;
		int indexBigArr =0;
		while((indexFH < firstH.length) && (indexLH < lastH.length)){//left or right when there are values to compare
			if(firstH[indexFH].compareTo(lastH[indexLH]) < 0){
				anArr[indexBigArr] = firstH[indexFH];
				indexFH++;
				}
			else{
				anArr[indexBigArr] = lastH[indexLH];
				indexLH++;
			}
			indexBigArr++; 
		}
		while(indexFH <firstH.length){
			anArr[indexBigArr] = firstH[indexFH];
			indexFH++;
			indexBigArr++; 
		}
		while(indexLH < lastH.length){
			anArr[indexBigArr] = lastH[indexLH];
			indexLH++;
			indexBigArr++; 
		}
		
	}
	/**
	 * MergeSort  - divide and conquer 
	 * @param arr
	 * uses 2 helper methods : divide, merge
	 * has 2 recursive calls
	 * Worst Case Run time: k = O(nlogn) base2
	 */
	public static <T extends Comparable<? super T>> void mergeSort(T [] arr){
		if(arr.length >=2){
			int halfLen = arr.length /2;
			T[] fHalf = (T[]) new Comparable<?>[halfLen];
			T[] lHalf = (T[]) new Comparable<?>[arr.length - halfLen];
			divide(arr, fHalf, lHalf); //split larger array into 2 smaller
			mergeSort(fHalf);//recursive call
			mergeSort(lHalf);//recursive call
			merge(arr, fHalf, lHalf); //compare and merge back together
		}
	}
	
	
	
	//insertion sort O(n^2)
	public static <T extends Comparable<? super T>> void insertionSort(T [] arr){
		for(int j=1; j<arr.length; j++){
			int loc = j;//next index
			T nextItem = arr[j]; //next Item stored
			while( (loc>0) &&(arr[loc-1].compareTo(nextItem) > 0)){//curr is greatere so we shift to the right
				arr[loc] = arr[loc-1]; // put curr in the next
				loc--;
			}
			arr[loc]=nextItem;
		}
	}
	
	//quick sort Avg: O(n logn) , Worst O(n^2)
	public static <T extends Comparable<? super T>> void quickSort(T[] arr, int start, int end){
		int i=start;
		int j=end;
		T pivotItem = arr[start];//use kthSmallest to find a really good pivot
		while(i<=j){
			while(arr[i].compareTo(pivotItem) < 0){  // section 1 go to the right
				i++;
			}
			while(arr[j].compareTo(pivotItem) > 0){  // section 2 go to the left
				j--;
			}
			if(i <=j){
				interchange(i, j, arr);
				i++;
				j--;
			}
			if(start < j){
				quickSort(arr, start, j);
			}
			if(i < end){
				quickSort(arr, i, end);
			}
		}
	}
	
	public static <T> void displayArr(T [] arr){
		for(T item: arr){
			System.out.print(item+"\t");
		}
		System.out.println("\n");
	}
	
	
	
	
	
	
	
	//radix sort  Avg&Worst:  O(n) 
	public static void radixSort(String [] arr){
		int n = arr.length;
		int digits = arr[0].length();//assume fixed length
		int R = 256; // ASCII chars possible
		String [] helperArr = new String[n]; 
		for(int d = digits-1; d>=0; d--){
			//sort by the dth character
			int [] count = new int[R+1];
			for(int i =0; i<n; i++){ //cumulative grouping
				count[  arr[i].charAt(d)+1  ] ++;
			}
			for(int r = 0; r < R; r++){// relative grouping
				count[r+1] += count[r];
			}
			
			for(int i=0; i<n; i++){ //move to helper array
				helperArr[count[arr[i].charAt(d)]++] = arr[i];
			}
			for(int i=0; i<n; i++){//move back to correct location in the original array
				arr[i]=helperArr[i];
			}
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
