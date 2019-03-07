package heaps;

import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arrL = new ArrayList<>();
		try {
			arrL.add("hat");
			arrL.add("rat");
			arrL.add("zoo");
			arrL.add("ant");
			arrL.add("arm");
			arrL.add("cat");
			arrL.add("dog");
			arrL.add("hat");
			arrL.add("bat");
			arrL.add("boo");
			arrL.add("bug");
			arrL.add("bull");
			arrL.add("car");
			arrL.add("cat");
			arrL.add("dog");
			
			//Heap<String> heap = new Heap<>(arrL);
			System.out.println("\n\ndisplay array");
			for(int i=0; i<arrL.size(); i++){
				System.out.println("index: "+i+ arrL.get(i));
			}
			
			Heap.heapSort(arrL);
			System.out.println("\n\ndisplay array");
			for(int i=0; i<arrL.size(); i++){
				System.out.println("index: "+i+ arrL.get(i));
			}
		}catch(ClassCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
