package ADT_lists;

public class node {
	Object item;
	node next;
	
	node(Object newItem)
	{
		item = newItem;
		next = null;//by default the nest item is null
	}
	node(Object newItem, node nextNode)
	{
		item = newItem;
		next = nextNode;//now we can point the next item as nextNode

	}

}
