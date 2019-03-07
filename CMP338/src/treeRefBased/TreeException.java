package treeRefBased;

public class TreeException extends RuntimeException {
	
	public TreeException(){
		super("Tree Exception: ");
	}
	
	public TreeException(String message){
		super("Tree Exception: "+ message);
	}

}
