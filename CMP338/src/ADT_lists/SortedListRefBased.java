package ADT_lists;

	public class SortedListRefBased implements SortedList
	{
		private node head;
		private int numItems;
		
		public SortedListRefBased()
		{
			numItems=0;
			head = null;
		}
		
		@Override
		public boolean isEmptySorted()
		{
			return (numItems == 0);
		}

		@Override
		public int sizeSorted()
		{
			// TODO Auto-generated method stub
			return numItems;
		}

		private static node insertRecursive(node headNode, java.lang.Comparable newItem)
		{
			if((headNode == null) || (newItem.compareTo(headNode.item) < 1)){//empty list
				node newNode = new node(newItem);
				newNode.next = headNode;
				headNode = newNode;
			}
			else{
					node nextNode = insertRecursive(headNode.next, newItem);//recursive call passing in next Node
					headNode.next = nextNode;
				
			}
			return headNode;
		}
		@Override
		public void addSorted(java.lang.Comparable newItem) throws ListOutofBoundsException
		{
			head = insertRecursive(head, newItem);
			numItems++;
			
			
		}

		@Override
		public void removeSorted(Object item) throws ListOutofBoundsException
		{
			System.out.print("want to remove " + item);
			if( (head!=null) && (head.item == item)){
				head = head.next;
			}
			else{
				node prev = null;
				node curr = head;
				while((curr !=null)&&(!(item.equals(curr.item)))){      //(item != curr.item)){
						prev = curr;
						curr = curr.next;
				}
				//if(curr!=null){//use if you want to avoid exception when item is not in the list
				//	System.out.println("found "+curr.item);
					prev.next = curr.next;
				//}
				//else{System.out.println(" IS NOT IN THE LIST");}
				
			}
			numItems--;
		}

		@Override
		public void removeAll() 
		{
			head = null;
			numItems=0;
			
		}

		@Override
		public Object getSorted(int index) throws ListOutofBoundsException 
		{
			if(index<sizeSorted()){
				node curr = head;
				for(int i=0; i < index; i++){
					curr = curr.next;
				}
				return curr.item;
			}
			else{
				return -1;
			}
		}

		@Override
		public int locate(Object item) throws ListOutofBoundsException 
		{
			node curr = head;
			for(int i=0; i<sizeSorted(); i++){
				if( (curr !=null) && (!(curr.item.equals(item))) ){
					curr = curr.next;
				}
				else{
					return i;
				}
			}
			return -1;
		}
		
		public void displayList()
		{
			System.out.println("\n\nWill display list now ");
			//Node curr =head; //example using while loop
			//while(curr !=null){//example using while loop
			for(node curr = head;curr!=null; curr = curr.next){//could be written using a for loop also
				System.out.println(curr.item.toString());
				//curr = curr.next;//example using while loop
			}
		}

}


