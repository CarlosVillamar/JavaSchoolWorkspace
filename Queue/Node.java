package queues;


public class Node {
	Object item;
	Node next;
	
	Node(Object newItem){
		item = newItem;
		next = null; // by default the next item is null
	}
	
	Node(Object newItem, Node nextNode){
		item = newItem;
		next = nextNode; // now we can point to the next node
	}


}
