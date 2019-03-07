package queues;

public class QueueRefBased implements QueueInterface{
	
	private Node lastNode;
	
	public QueueRefBased(){
		lastNode =null;
	}

	@Override
	public boolean isEmpty() {
		return (lastNode == null);
	}

	@Override
	public Object dequeue() throws QueueException {
		if(!isEmpty()){
			Node firstNode = lastNode.next;
			if(firstNode == lastNode){// a single node in the queue
				lastNode = null;
			}
			else{
				lastNode.next = firstNode.next; // point to the second node to dequeue the first
			}
			return firstNode.item;
		}
		else{
			throw new QueueException("exception on dequeue - the queue is empty!!!");
		}
		
	}

	@Override
	public Object peek() throws QueueException {
		if(!isEmpty()){
			/*Node firstNode = lastNode.next;
			return firstNode.item;*/  // same thing.. pick your poison
			return lastNode.next.item;
		}
		else{
			throw new QueueException("exception on peek - the queue is empty!!!");
		}
	}

	@Override
	public void enqueue(Object newItem) throws QueueException {
		Node newNode = new Node( newItem);
		if(isEmpty()){
			newNode.next = newNode;
		}
		else{
			newNode.next = lastNode.next;
			lastNode.next = newNode;
		}
		lastNode = newNode; //a new Node is always at the end of the queue
		
	}

	@Override
	public void dequeueAll() {
		lastNode = null;
	}
	
	
	
	
	

}
