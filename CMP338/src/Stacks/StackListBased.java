package Stacks;

import ADT_lists.ListOutofBoundsException;
import ADT_lists.ListRefBased;

public class StackListBased implements StackInterface
{

	private ListRefBased list;
	
	public StackListBased()
	{
		list = new ListRefBased();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	
	@Override
	public void push(Object item) throws StackException
	{	try
		{
			 list.add(0, item);
		}
		catch(ListOutofBoundsException e)
		{
			throw new StackException("could not puch onto stack");
		}
	}
	
	@Override
	public Object peek() throws StackException 
	{
		try
		{
			return list.get(0);
		}
		catch(ListOutofBoundsException e)
		{
			throw new StackException("could not peek.. into stack");
		}
	}



	@Override
	public Object pop() throws StackException {
		// TODO Auto-generated method stub
		try
		{
			Object temp = list.get(0);
		
		list.remove(0);
		return temp;
		}
		catch(ListOutofBoundsException e)
		{
			throw new StackException("could not pop from stack");
		}
	
		
	}

	@Override
	public void popAll() {
		// TODO Auto-generated method stub
		list.removeAll();
	} 
	 
	

}
