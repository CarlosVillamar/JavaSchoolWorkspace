package queues;

import Stacks.StackException;
import Stacks.StackRefBased;

public class Examples {
	
	public static void main(String [] args){
		System.out.println("noon ... is it a pal? " +isPal("noon"));
		System.out.println("racecar ... is it a pal? " +isPal("racecar"));
		System.out.println("tacocat ... is it a pal? " +isPal("tacocat"));
		System.out.println("empty string ... is it a pal? " +isPal(""));
		System.out.println("a ... is it a pal? " +isPal("a"));
		System.out.println("abab ... is it a pal? " +isPal("abab"));
	}
	public static boolean isPal(String s){
		QueueRefBased queue = new QueueRefBased();
		Stacks.StackRefBased stack = new StackRefBased();

		try {
				for(int i=0; i<s.length(); i++){
						char nextChar = s.charAt(i);
						queue.enqueue(nextChar);
						stack.push(nextChar);
				}		
				while(!queue.isEmpty()){
					char qCh = (char) queue.dequeue();
					char sCh = (char) stack.pop();
					if(qCh != sCh){
						return false;
					}
				}
		} catch (StackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return true;//got through without a mismatch
		
	}

}
