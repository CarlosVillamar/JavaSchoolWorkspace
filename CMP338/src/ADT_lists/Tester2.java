package ADT_lists;

public class Tester2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//notice that regardless of the data structure used, they all work the same way
		//sorted List always maintains items in order
		
		
		//int [] nums = {55,38,29,5,76,12,17};
		String [] words = {"zebra","monkey","dog","squirrel","cat"};
		
		//arraybased
		//ArrayBasedList aList = new ArrayBasedList();

		//refbased
		//ListRefBased rList = new ListRefBased();
		
		//sortedRefBased
		SortedListRefBased sList = new SortedListRefBased();
		
		
		//populate  lists... regardless of implementation
		for(int i=0; i< words.length; i++){
			try {
				System.out.println("adding\t" + words[i]);
				//aList.add(i, words[i]);
				//rList.add(i, words[i]);
				sList.addSorted(words[i]);
			} catch (ListOutofBoundsException e) {
				e.printStackTrace();
			}
		}

		/**System.out.println("\n\nshow aList");
		aList.displayList();
		System.out.println("\n\nshow rList");
		rList.displayList();**/
		System.out.println("\n\nshow sList");
		sList.displayList();
		System.out.println("\n\n");
		
		try {
			//aList.add(2, "antelope");
			//rList.add(2, "antelope");
			sList.addSorted("antelope");
			//aList.add(4, "cow");
			//rList.add(4, "cow");
			sList.addSorted("cow");
			//aList.add(1, "giraffe");
			//rList.add(1, "giraffe");
			sList.addSorted("giraffe");


			/**System.out.println("\n\nshow aList");
			aList.displayList();
			System.out.println("\n\nshow rList");
			rList.displayList();**/
			System.out.println("\n\nshow sList");
			sList.displayList();
			
			//System.out.println("\nGETTING---"+ rList.get(4)+"\n");
			
			System.out.println("Will remove \'dog\' from the list now:");
			/**aList.remove(4);
			rList.remove(4);**/
			sList.removeSorted("dog");
			/**System.out.println("\n\nshow aList");
			aList.displayList();
			System.out.println("\n\nshow rList");
			rList.displayList();**/
			System.out.println("\n\nshow sList");
			sList.displayList();

			System.out.println("\n\nWill remove \'zebra\' from the list now:");
			/**aList.remove(0);
			rList.remove(0);**/
			sList.removeSorted("zebra");
			/**System.out.println("\n\nshow aList");
			/aList.displayList();
			System.out.println("\n\nshow rList");
			rList.displayList();**/
			System.out.println("\n\nshow sList");
			sList.displayList();
			
		} catch (ListOutofBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		
	}

}
