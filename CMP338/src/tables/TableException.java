package tables;

public class TableException extends Exception {

	public TableException(){
		super("Table Exception: ");
	}
	public TableException(String message){
		super("Table Exception: " + message);
		
	}
}
