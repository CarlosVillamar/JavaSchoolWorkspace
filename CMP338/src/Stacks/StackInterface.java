package Stacks;

public interface StackInterface {
	public boolean isEmpty();
	public void push(Object item) throws StackException;
	public Object peek() throws StackException;
	public Object pop() throws StackException;
	public void popAll();
	
	

}
