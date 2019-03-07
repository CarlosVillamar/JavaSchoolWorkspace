package generics;

public class ListOutOfBoundsException extends Exception {

		public ListOutOfBoundsException(){
			super("ListOutOfBoundsException: OUCH!!!!");
			
		}
		
		public ListOutOfBoundsException(String message){
			super("ListOutOfBoundsException:" + message);
		}
		
		
	}
