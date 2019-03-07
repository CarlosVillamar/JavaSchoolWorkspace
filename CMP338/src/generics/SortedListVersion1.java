package generics;

public class SortedListVersion1<T extends Comparable<? super T>> 
extends ListRefBased<T> implements SortedListInterface<T>{

	public SortedListVersion1(){
		super();
	}
	
	@Override
	public void addSorted(T item) throws ListOutOfBoundsException {
		int pos = locate(item);
		super.add(pos, item);
	}

	@Override
	public void removeSorted(T item) throws ListOutOfBoundsException {
		int pos = locate(item);
		if( (item.compareTo(get(pos)) ==0)){
			super.remove(pos);
		}
		else{
			throw new ListOutOfBoundsException("Remove sorted FAILED");
		}
		
	}

	@Override
	public int locate(T item) throws ListOutOfBoundsException {
		int index =0;
		while( (index < size()) && (item.compareTo(get(index))>0   )){
			index++;
		}
		return index; //return position of item
	}

}
