package generics;

public interface SortedListInterface<T extends Comparable<? super T>  > extends BasicADTInterface<T>{
	
	public void addSorted(T item) throws ListOutOfBoundsException;
	public void removeSorted(T item) throws ListOutOfBoundsException;
	public int locate(T item) throws ListOutOfBoundsException;

}
