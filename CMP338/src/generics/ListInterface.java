package generics;

public interface ListInterface<T> extends BasicADTInterface<T> {
	public void add(int index, T item) throws ListOutOfBoundsException;
	public void remove(int index)throws ListOutOfBoundsException;
	public T get(int index)throws ListOutOfBoundsException;
	

}
