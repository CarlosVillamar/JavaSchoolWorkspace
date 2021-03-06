package ADT_lists;

import ADT_lists.node;

public class ListRefBased implements Lists {//also known as linkedlist
	
	private node head;
	private int numItems;
	
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (numItems == 0);
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numItems;
	}
	private node find(int index)
	{	node cuff = head;
		for(int step=0;step<index;step++)
		{
			cuff = cuff.next;
		}
		return cuff;
		
	}
	@Override
	public void add(int index, Object item) throws ListOutofBoundsException {
		// TODO Auto-generated method stub
		if(index>=0 && (index<=numItems))
		{
			if(index==0)
			{
				node newNode = new node(item,head);
				head = newNode;
			}
			else
			{	node prev = find(index-1);//get prevoius node so we can use its next to the line 
				node newNode = new node(item,prev.next);//make a new node point to prevouis next
				prev.next = newNode;// make prev point to the Node;
			}		
				numItems++;
		}
			else
			{
			throw new ListOutofBoundsException("Out of bounds on add method");
			}
		
		}
		
	
	@Override
	public void remove(int index) throws ListOutofBoundsException 
	{
		// TODO Auto-generated method stub
		if(index>=0 && (index<=numItems))
		{
			if(index==0)
			{
				head = head.next;
			}
			else 
			{
				node prev= find(index-1);//find the previous node to learn to learnt the"next"
				node curr = prev.next;//now fint the curr via prev.next
				prev.next = curr.next;//prev next next(skip current
			}
			numItems--;
		}
		else
		{
			throw new ListOutofBoundsException("opps on remove");
		}
	}
	@Override
	public Object get(int index) throws ListOutofBoundsException {
		// TODO Auto-generated method stub
		if(index>=0 && (index<numItems))
		{
			node curr =find(index);
			Object dataItem = curr.item;
			return dataItem;
		}
		else
		{
			throw new ListOutofBoundsException("opps could not get it..mosquito got it");
		}
			
	
	}
	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		head = null;//pointing to null moves the list cease to exist
		numItems = 0;
	}
	
	public void displayListBackwards()
	{	//use theprivate helper method writeBackwards
		writeListBackwards(head);
		
	}
	public void displayList()
	{
		writeList(head);
	}
	private static void writeList(node nextNode)
	{
		if(nextNode != null)
		{	System.out.println(nextNode.item);//
			writeList(nextNode.next);//recursive call
			
		}
	}
	private static void writeListBackwards(node nextNode)
	{
		if(nextNode != null)
		{
			writeListBackwards(nextNode.next);//recursive call
			System.out.println(nextNode.item);//
		}
	}
	
	

}
