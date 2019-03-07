package ADT_lists;

public class tester {
public static void main(String[] args)
{
		
		//notice that regardless of the data structure used, they both work the same way
		
		ListRefBased foodList = new ListRefBased(); //linked list implementation
		//ArrayBasedList foodList = new ArrayBasedList(); //array based implementation
		try {
			foodList.add(0, "watermelon");
			foodList.add(1, "cantaloupe");
			foodList.add(2, "apricots");
			foodList.add(3, "grapes");
			foodList.add(4, "peaches");
			foodList.add(2, "oranges");
			foodList.add(1, "kiwi");
			foodList.add(0, "tangerines");
			System.out.println("Will Display list now: Expected Content:\n"
					+ "tangerines watermelon kiwi cantaloupe oranges apricots grapes peaches\n");
			foodList.displayList();
			foodList.remove(3);//remove cantaloupe
			foodList.remove(0);//remove tangerines
			foodList.remove(5);//remove peaches
			System.out.println("Will Display list now: Expected Content:\n"
					+ "watermelon kiwi oranges apricots grapes\n");
			foodList.displayList();
			
		} catch (ListOutofBoundsException e) {
			e.printStackTrace();
		}
		

	}

}

