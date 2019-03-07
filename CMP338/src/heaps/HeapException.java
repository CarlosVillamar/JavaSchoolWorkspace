package heaps;

public class HeapException extends Exception {
	
	public HeapException(){
		super("HEAP EXCEPTION");
	}
	
	public HeapException(String message){
		super("HEAP EXCEPTION"+ message);
	}

}
