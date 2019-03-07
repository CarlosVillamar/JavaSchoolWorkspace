package queues;

public class Tester {

	public static void main(String[] args) {
		QueueRefBased qR = new QueueRefBased();
		for(int i=0; i<10; i++){
			qR.enqueue( (i+10)*2 );
			System.out.println("Front of Queue "+ qR.peek());
		}
		
		System.out.println("\n\n");
		
		for(int i=0; i<10; i++){
			System.out.println("Front of Queue after "+i+" dequeues" +qR.peek());
			qR.dequeue(); //removing....
		}
			
		if(qR.isEmpty()){
			System.out.println("DKSLFJL:SDKFJ:SDFJ:LSFD");
		}
		

	}

}
