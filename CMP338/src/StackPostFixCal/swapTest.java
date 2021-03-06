package StackPostFixCal;

import ADT_lists.ListOutofBoundsException;
import ADT_lists.ListRefBased;

public class swapTest {
	public static void main(String[] args) throws ListOutofBoundsException
	{
		ListRefBased alist = new ListRefBased();
		alist.add(0, "watermelon");
		alist.add(1, "cantaloupe");
		alist.add(2, "apricots");
		alist.add(3, "grapes");
		alist.add(4, "peaches");
		System.out.println("Display current list\n");
		alist.displayList();
		swap(alist,1,4);
		System.out.println("\nDisplay list post swap\n");
		alist.displayList();
		
		alist.add(0, "watermelon");
		alist.add(0, "cantaloupe");
		alist.add(0, "apricots");
		alist.add(0, "grapes");
		alist.add(0, "peaches");
		System.out.println("\nDisplay list post swap\n");
		alist.displayList();
		alist.get(0);
		alist.remove(0);
		alist.add(0,"oranges");
		///how do I remove all of the values at index 0
		System.out.println("\nDisplay list post swap\n");
		alist.displayList();
	}
	
	public static void swap(ListRefBased alist, int i, int j) throws ListOutofBoundsException
	{
		Object ithItem = alist.get(i);
		Object jthItem = alist.get(j);
		
		alist.remove(i);
		alist.add(i,jthItem);
		
		alist.remove(j);
		alist.add(j,ithItem);
		
	}

}
