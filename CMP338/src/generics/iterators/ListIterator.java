package generics.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface ListIterator<E> extends Iterator<E> {
	
	//chapter 9 page 490
	<T> void add(T o); // inserts between prev and next
	void remove() throws UnsupportedOperationException, IllegalStateException;//removes element returned by next() or previous()
	<T> void set(T o) throws UnsupportedOperationException, IllegalStateException;//replaces element returned by next() or previous()
	boolean hasNext();//true if there is another element afterward
	boolean hasPrevious();//true if there is another element before
	E next() throws NoSuchElementException;//return the next element or throw exception
	int nextIndex();//returns next index
	E previous() throws NoSuchElementException;//return the previous element or throw exception
	int previousIndex();//returns previous index
	
	
	
}
