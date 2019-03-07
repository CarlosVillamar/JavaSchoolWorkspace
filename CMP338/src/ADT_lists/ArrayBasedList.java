package ADT_lists;

public class ArrayBasedList implements Lists
{ private static final int MAX_LIST = 50;
	private Object items [];//array empty
	private int numItems;
	
	public ArrayBasedList()
	{
		items = new Object[MAX_LIST];
		numItems = 0;
	}

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

	@Override
	public void add(int index, Object item) throws ListOutofBoundsException {
		// TODO Auto-generated method stub
		if(numItems > MAX_LIST)
		{
			throw new ListOutofBoundsException("OOPS! cannot add another");
		}
		if((index>=0)&&(index<=numItems))
		{
			for(int pos = numItems; pos>=index; pos--)
			{
				items[pos+1] = items[pos];
				
			}
			items[index] = item;
			numItems++;
		}
			else
			{
				throw new ListOutofBoundsException("UHOH");
			}
				
		}
	

	@Override
	public void remove(int index) throws ListOutofBoundsException {
		// TODO Auto-generated method stub
		if((index >=0)&&(index<numItems))
		{
			for(int pos = index+1; pos<=size(); pos++)
			{
				items[pos-1] = items[pos];//shift all items to the left to delter the curr item
			}
			numItems--;
		}
		else
		{
			throw new ListOutofBoundsException("opps! on remove method:");
		}
	}

	@Override
	public Object get(int index) throws ListOutofBoundsException {
		// TODO Auto-generated method stub
		if(index>=0 && index<numItems)
		{
			return items[index];
		}
		else
		{
			throw new ListOutofBoundsException("opps! on get method:");
		}
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		items = new Object[MAX_LIST];
	}
	public void displayList(){
		//use the private helper method writeBackwards
		System.out.println("\ndisplaying list:");
		for(int i=0; i<numItems; i++){
			System.out.println(items[i]);
		}
	}
	

	
	

}
