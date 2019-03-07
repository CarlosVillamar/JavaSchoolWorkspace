package Stacks;

public class StackArrBased implements StackInterface
{
	private final int MAX_STACK = 5;//MAX_STACK
	private Object [] items;//Object array
	private int top; //top index
	
	public StackArrBased(){
		items = new Object[MAX_STACK];
		top = 1; //Empty Stack 
	}

	@Override
	public boolean isEmpty() {
		return (top <0);
	}
	public boolean isFull(){
		return (top == MAX_STACK-1); //looks good
	}

	@Override
	public void push(Object item) throws StackException {
		if(!isFull()){
			top++; 
			items[top] = item;
		}else{
			throw new StackException("Cannot push... stack is full");
		}
	}

	@Override
	public Object peek() throws StackException {
		return items[top] ;
	}

	@Override
	public Object pop() throws StackException
	{
	
		Object temp = items[top];
		top--;
		return temp;
		}

	@Override
	public void popAll() {
		items = new Object[MAX_STACK];
		top = -1; //before the beginning of the array
		
	}
	
	
	
	

}
