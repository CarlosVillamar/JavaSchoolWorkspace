package ExceptionDemo;

public class DividedByZero extends Exception{
	
	public DividedByZero()
	{
		super("Dividing by Zero");
	}
	public DividedByZero(String message)
	{
		super(message);
		
	}

}
