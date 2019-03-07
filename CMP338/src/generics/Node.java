package generics;


public class Node<T> {
	
	T item;
	Node<T> next;
	
	Node(T newItem){
		item = newItem;
		next = null; // by default the next item is null
	}
	
	Node(T newItem, Node<T> nextNode){
		item = newItem;
		next = nextNode; // now we can point to the next node
	}
}

