package Stacks;

public class StackTester {

	public static void main(String[] args) {
		StackArrBased aStack = new StackArrBased();
		StackRefBased  rStack = new StackRefBased();
		StackListBased lStack = new StackListBased();
		String [] stuff = {"cat", "dog", "mouse", "house", "bat", "rat"};
		try {
			for(int i=0; i<stuff.length; i++){

				//aStack.push(stuff[i]);
				rStack.push(stuff[i]);
				//lStack.push(stuff[i]);
				
			}
			//System.out.println("IS THE STACK FULL?? " + aStack.isFull());
			while(!rStack.isEmpty()){
				System.out.println("val is "+ aStack.pop());
				System.out.println("val is "+ rStack.pop());
				System.out.println("val is "+ lStack.pop());
			}
			
			
		} catch (StackException e) {
			e.printStackTrace();
		}

	}

}
