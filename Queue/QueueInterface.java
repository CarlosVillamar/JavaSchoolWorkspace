package queues;

public interface QueueInterface {
	
	public boolean isEmpty();
	public Object dequeue() throws QueueException;
	public void enqueue(Object newItem) throws QueueException;
	public Object peek()throws QueueException;
	public void dequeueAll();

}
