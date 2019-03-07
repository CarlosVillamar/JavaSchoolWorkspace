package queues;

public class QueueException extends RuntimeException{
	public QueueException(){
		super("Queue Exception ");
	}

	public QueueException(String message ){
		super("Queue Exception "+ message);
	}

}
