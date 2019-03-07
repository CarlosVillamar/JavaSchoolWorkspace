package ADT_lists;

public interface SortedList {

	public boolean isEmptySorted();
	public int sizeSorted();
	
	public void addSorted(java.lang.Comparable item) throws 	ListOutofBoundsException;
	
	public void removeSorted(Object item) throws 	ListOutofBoundsException;
	
	public void removeAll();
	
	public Object getSorted(int index)throws 	ListOutofBoundsException;
	
	public int locate(Object item) throws 	ListOutofBoundsException;
}


