package generics.iterators;

import java.util.NoSuchElementException;

import generics.ListOutOfBoundsException;
import generics.ListRefBased;

public class Tester {

	public static void main(String[] args) {
		String [] words = {"monkey","dog","zebra","squirrel","cat"};
		ListRefBased<String> rList = new ListRefBased<>();
		MyListIterator<String> iList = new MyListIterator<>(rList);
		
		//populate

		System.out.println("\n\nPOPULATE");
		for(int i=0; i<words.length; i++){
			
				iList.add(words[i]);
				System.out.println("added "+words[i]);
			
		}

		iList.display();
		iList.displayReverse();

		/*
		//display reverse
		System.out.println("\n\nDISPLAY REVERSE");
		try{
			while(iList.hasPrevious()){
				System.out.println(iList.previous());
			}
		}catch(NoSuchElementException nse){
			nse.printStackTrace();
		}
		//display
		System.out.println("\n\nDISPLAY");
		try{
			while(iList.hasNext()){
				System.out.println(iList.next());
			}
		}catch(NoSuchElementException nse){
			nse.printStackTrace();
		}*/

	}

}
