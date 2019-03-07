package Stacks;

public class StackRefBased implements StackInterface {
	private node top;
	
	public StackRefBased()
	{
		top = null;
		
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top == null);
	}
	
	@Override
	public void push(Object item) throws StackException {
		// TODO Auto-generated method stub
		top = new node(item,top);//always points to the top
	}
	
	@Override
	public Object peek() throws StackException 
	{
			if(!isEmpty())
			{
				return top.item;
			}
			else 
				throw new StackException("could not peek empty stack");
	}
	@Override
	public Object pop() throws StackException {
		// TODO Auto-generated method stub
		Object temp = top.item;
		top = top.next;
		return temp;
	}
	@Override
	public void popAll()
	{
		top = null;
		
	}

	
	
	

}
