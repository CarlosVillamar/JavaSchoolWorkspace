package heaps;

import java.util.Comparator;

public class PriorityQueue<T> {

	private Heap<T>heap;
	
	public PriorityQueue(){
		heap = new Heap<T>();
	}
	
	public PriorityQueue(Comparator<? super T> comparator){
		heap = new Heap<T>(comparator);
	}
	
	public boolean isPQEmpty(){
		return heap.heapIsEmpty();
	}
	
	public void pqInsert(T item)throws PriorityQueueException{
		try{
			heap.heapInsert(item);
		}
		catch(HeapException he){
			throw new PriorityQueueException("Can NOT insert into Priority Queue...");
		}
	}
	
	public T pqDelete(){
		return heap.heapDelete();
	}
}
