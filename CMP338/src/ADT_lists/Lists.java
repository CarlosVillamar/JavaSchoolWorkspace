package ADT_lists;

public interface Lists {
	
	public boolean isEmpty();
	public int size();
	public void add(int index, Object item) throws ListOutofBoundsException;
	public void remove(int index)throws ListOutofBoundsException;
	public Object get(int index)throws ListOutofBoundsException;
	public void removeAll();
	

}
