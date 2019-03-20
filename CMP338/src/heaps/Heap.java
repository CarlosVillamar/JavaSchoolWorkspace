package heaps;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> {
	
	protected ArrayList<T> items;
	private Comparator<? super T> comparator;
	
	public Heap(){
		items = new ArrayList<T>();
	}
	
	public Heap(Comparator <? super T> comparator){
		items = new ArrayList<T>();
		this.comparator = comparator;
	}
	
	public Heap(ArrayList<T> arr){
	//already have a messy array that we want to sort into a heap
		items = arr;
		this.heapifyUp();
	}
	
	private void heapifyUp() {
		for(int i=items.size()-1; i>=0; i--){
			//System.out.println("\tCALL FROM FOR LOOP "+i+"STEPS: "+steps);
			heapRebuild(i, items.size()-1);
		}
		
	}

	
	public boolean heapIsEmpty(){
		return items.size() == 0;
	}

	public void heapInsert(T item) throws HeapException{
		if(!items.add(item)){//throws an Exception... 
			throw new HeapException("HEAP INSERT Failed");
		}
		else{
			int loc = items.size()-1;//num of items -1
			int parent = ( loc -1) / 2; //remember this is using integer division
			while( (parent >=0)  && ( compareItems(items.get(loc),  items.get(parent) )  > 0) ){
				swap(loc, parent, items);
				loc = parent;//set loc to parent index to compare up
				parent = (loc -1)/2;//use the new value of loc to find the parent
			}
		}
	}
	public T heapDelete(){//return the value or return null if the heap isEmpty
		T rootItem = null;
		int rootIndex = 0;
		int loc;
		if(!heapIsEmpty()){
			rootItem = items.get(rootIndex);//storing the root in a variable to return it at the end
			loc = items.size()-1;
			items.set(rootIndex, items.get(loc));//set the root of the heap to whatever was in the last index
			items.remove(loc);
			heapRebuild(rootIndex);
		}
		return rootItem;
	}
	
	protected void heapRebuild(int root) {//beware page 676 has a couple bugs
		int child = (2*root)+1;//index of left child
		if(child < items.size()){
			int rightChild = child+1;//right child index
			if( (rightChild < items.size())  && ( compareItems(items.get(rightChild), items.get(child)) >0 )   ){
				child = rightChild;//make sure we are using the index of the larger child
			}
			if( compareItems(items.get(root), items.get(child)) < 0 ){
				swap(root, child, items);
				heapRebuild(child);//recursive call to compare child against its larger child
			}
		}
	}
	
	protected void heapRebuild(int root, int lastIndex) {//beware page 676 has a couple bugs
		int child = (2*root)+1;//index of left child
		if(child <= lastIndex){
			int rightChild = child+1;//right child index
			if( (rightChild <=lastIndex)  && ( compareItems(items.get(rightChild), items.get(child)) >0 )   ){
				child = rightChild;//make sure we are using the index of the larger child
			}
			if( compareItems(items.get(root), items.get(child)) < 0 ){
				swap(root, child, items);
				heapRebuild(child);//recursive call to compare child agains its larger child
			}
		}
	}
	
	//O(nlogn)
		public static <T extends Comparable<? super T>> void heapSort(ArrayList<T> arr){//algorithm page 680
			//build initial heap
			//for(int i=(arr.size()/2); i>=0; i--){//do not call heapRebuild on level h to be more efficient
			for(int i=arr.size()-1; i>=0; i--){
				heapRebuild(arr, i, arr.size()-1);
			}
			System.out.println("\n\nHAVE A HEAP... will sort further now");
			//set last to be able to decrement it
			int last = arr.size()-1;
			for(int i=0; i<arr.size(); i++){
				swapStat(0,last,arr);
				last--;
				heapRebuild(arr,0,last);
			}
			
		}
		protected static <T extends Comparable<? super T>> void heapRebuild(ArrayList<T> arr, int root, int last){ 
			//BEWARE!!! page 676 has bugs
			int child = (2*root)+1; //index of left child
			if(child <=last){
				int rightChild = (child + 1);//index of right child
				if( (rightChild <=last) && (arr.get(rightChild).compareTo(arr.get(child)) > 0) ){
					//find larger of the 2 children set index of larger child
					child = rightChild; 
				}
				if(arr.get(root).compareTo(arr.get(child)) < 0){//compare parent against larger child
					swapStat(root, child,  arr);//swap root with child if child is greater than parent
					heapRebuild(arr, child, last); //recursive call to make subtree into heap

				}
			}
		}
	private static <T extends Comparable<? super T>> void swapStat(int i, int j, ArrayList<T>arr){	
		T temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	
	private void swap(int i, int j, ArrayList<T> arr) {
		T temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
	private int compareItems(T item1, T item2) {
		if(comparator == null){
			return (( Comparable<T>) item1).compareTo(item2); // -1 , 0 , 1
		}
		else{
			return comparator.compare(item1, item2);
		}
	}
	
	
	
	
	
}
