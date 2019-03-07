package ExceptionDemo;

public class MilkEx extends Exception {
	
	public MilkEx()
	{
		super("You need Milk");
	}
	
	public MilkEx(String whatever)
	{
		super(whatever);
		
	}

}
