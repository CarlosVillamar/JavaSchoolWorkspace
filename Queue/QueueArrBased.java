package queues;

public class QueueArrBased implements QueueInterface{
	
	
	private final int MAX_QUEUE = 5;
	private int front;
	private int back;
	private int count;
	private Object [] items;
	
	public QueueArrBased(){
		items = new Object[MAX_QUEUE];
		front =0;
		back = MAX_QUEUE-1;
		count =0;
	}

	@Override
	public boolean isEmpty() {
		return (count == 0);
	}
	public boolean isFull(){
		return (count == MAX_QUEUE);
	}
	@Override
	public Object dequeue() throws QueueException {
		if(!isEmpty()){
			Object tempFront = items[front];
			front = (front + 1) % MAX_QUEUE;//circular implementation
			count--;
			return tempFront;
		}
		else{
			throw new QueueException("queue is empty - exception on dequeue");
		}
	}

	@Override
	public void enqueue(Object newItem) throws QueueException {
		if(!isFull()){
			back = (back+1) % MAX_QUEUE;//circular implementation
			items[back]=newItem;
			count++;
		}else{
			throw new QueueException("queue is FULL - exception on enqueue");
		}
		
	}

	@Override
	public Object peek() throws QueueException {
		if(!isEmpty()){
			return items[front];
		}else{
			throw new QueueException("queue is empty - exception on peek");
		}
	}

	@Override
	public void dequeueAll() {
		items = new Object[MAX_QUEUE];
		front =0;
		count =0;
		back = MAX_QUEUE-1;
	}
	
	
	

}
