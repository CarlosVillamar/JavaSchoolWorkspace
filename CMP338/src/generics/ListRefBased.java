package generics;

public class ListRefBased<T> implements ListInterface<T>{
	
	private Node<T> head;
	private int numItems;
	
	public ListRefBased(){
		head=null;
		numItems =0;
	}
	@Override
	public int size() {
		return numItems;
	}
	@Override
	public boolean isEmpty() {
		return (numItems == 0);
	}
	@Override
	public void removeAll() {
		head = null; //pointing to null makes the list cease to exist
		numItems = 0;
	}
	@Override
	public void add(int index, T item) throws ListOutOfBoundsException {
		if(( index >=0) && (index <= numItems)){
			if(index==0){
				Node<T> newNode = new Node<T>(item, head);
				head = newNode; //head refers to the newNode inserted at the beginning of the list
			}
			else{
				Node<T> prev = find(index -1); //get the previous node so we can use its "next" to link to the nodes
				Node<T> newNode = new Node<T>(item, prev.next);//make new node point to previous's next
				prev.next = newNode; // make prev point to the new Node
			}
			numItems++;
		}
		else{
			throw new ListOutOfBoundsException("Out of bounds on add method");
		}
		
	}
	private Node<T> find(int index) {
		Node<T> curr = head;
		for(int step=0; step<index; step++){
			curr = curr.next;
		}
		return curr;
	}
	@Override
	public void remove(int index) throws ListOutOfBoundsException {
		if(( index >=0) && (index < numItems)){
			if(index ==0){
				head = head.next;
			}
			else{
				Node<T> prev = find(index-1); // find the previous node to learn the "next"
				Node<T> curr = prev.next; // now find the curr via prev.next
				prev.next = curr.next; // prev next next (skip current)
			}
			numItems--;
		}
		else{
			throw new ListOutOfBoundsException("OOPS on remove");
		}
		
	}
	@Override
	public T get(int index) throws ListOutOfBoundsException {
		if( (index >=0) && (index < numItems)){
			Node<T> curr = find(index);
			T dataItem = curr.item;
			return dataItem;
		}
		else{
			throw new ListOutOfBoundsException("OOPS coould not get it..mosquito got it");
		}
	}
	
	public void displayList(){
		//could use recursive helper method
		writeList(head); //use helper and pass in head
	}
	
	public void displayListBackwards(){
		//using iteration would be overly complicated since there is no reference to previous
		//use recursive helper method instead
		writeListBackwards(head); //use helper method and pass in head
	}
	//expects head as input
	private static void writeList(Node<?> nextNode){
		if(nextNode != null){
			System.out.println(nextNode.item);
			writeList(nextNode.next); //recursive call
		}
	}
	private static void writeListBackwards(Node<?> nextNode){
		if(nextNode != null){
			writeListBackwards(nextNode.next); //recursive call
			System.out.println(nextNode.item);
		}
	}

}
