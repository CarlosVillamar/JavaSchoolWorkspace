package Stacks;

public class StackException extends Exception{

public StackException()
{
	super("STACKEXCPETION");
	
}
public StackException(String message)
{
	super("STACKEXCEPTION" + message);
}
}

