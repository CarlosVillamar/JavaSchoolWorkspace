package queues;
import ADT_lists.ListOutofBoundsException;
import ADT_lists.ListRefBased;;

public class QueueListBased implements QueueInterface{
	private ADT_lists.ListRefBased  theList ;
	
	public QueueListBased(){
		theList = new ListRefBased();
	}
	
	@Override
	public boolean isEmpty() {
		return theList.isEmpty();
	}

	@Override
	public Object dequeue() throws QueueException {
		if(!isEmpty()){
			try {
				Object tempFront = theList.get(0);
				theList.remove(0);
				return tempFront;
				
			} catch (ListOutofBoundsException e) {
				// TODO Auto-generated catch block
				throw new QueueException("queue exception on dequeue " + e.getMessage());
			}
		}
		else{
			throw new QueueException("queue exception on dequeue - queue is EMPTY!!!");
		}
	}

	@Override
	public void enqueue(Object newItem) throws QueueException {
		try {
			theList.add(theList.size(), newItem);
		} catch (ListOutofBoundsException e) {
			throw new QueueException("queue exception on enqueue " + e.getMessage());
		}
		
	}

	@Override
	public Object peek() throws QueueException {
		if(!isEmpty()){
			try {
				return theList.get(0);	
			} catch (ListOutofBoundsException e) {
				// TODO Auto-generated catch block
				throw new QueueException("queue exception on dequeue " + e.getMessage());
			}
		}
		else{
			throw new QueueException("queue exception on dequeue - queue is EMPTY!!!");
		}
	}

	@Override
	public void dequeueAll() {
		theList.removeAll();
	}

}
