package ADT_lists;

public class ListOutofBoundsException extends Exception {
	public ListOutofBoundsException(){
		super("ListOutofBoundsException: OUCH!!!");
		
	}
	public ListOutofBoundsException(String message)
	{
		super("ListOutofBoundsException:" + message);
	}

}
