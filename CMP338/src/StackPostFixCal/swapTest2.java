package StackPostFixCal;
import ADT_lists.ArrayBasedList;
import ADT_lists.ListOutofBoundsException;
import ADT_lists.ListRefBased;
import StackPostFixCal.swapTest;

public class swapTest2 {
	 
	public static void main(String[] args) throws ListOutofBoundsException 
	{	//how to demonstrate a stack in t
		
		ArrayBasedList arrList = new ArrayBasedList();
		arrList.add(0,"football");
		arrList.add(1,"basketball");
		arrList.add(2,"soccer");
		System.out.println("\nThe list looks like this");
		arrList.displayList();
		//Creates a list and adds elements to the list in different indexes 
		
		arrList.add(0,"football");
		arrList.add(0,"basketball");
		arrList.add(0,"soccer");
		System.out.println("The list looks like this");
		arrList.displayList();
		//adds to the list stack in the same spot 
		
		arrList.removeAll();
		arrList.add(0,"cricket");
		swap(arrList,0,2);
		arrList.displayList();
		//pops all items off the stack and adds and element to the first index
		//then we will swap indexes, the element will move from 0 to 2
		
	}
	public static void swap(ArrayBasedList alist, int i, int j) throws ListOutofBoundsException
	{	//this method will swap elements 
		Object ithItem = alist.get(i);
		Object jthItem = alist.get(j);
		
		alist.remove(i);
		alist.add(i,jthItem);
		
		alist.remove(j);
		alist.add(j,ithItem);
	}
}
