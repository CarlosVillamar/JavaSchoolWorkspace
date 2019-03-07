package heaps;

public class PriorityQueueException extends Exception {

	public PriorityQueueException(){
		super("Priority Queue Exception");
	}
	public PriorityQueueException(String message){
		super("Priority Queue Exception"+ message);
	}

}
