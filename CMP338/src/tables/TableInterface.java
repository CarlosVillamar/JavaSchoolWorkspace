package tables;

import treeRefBased.KeyedItem;

public interface TableInterface<T extends KeyedItem<KT>, KT extends Comparable<? super KT>>{

	public boolean tableIsEmpty();
	public int tableLength();
	public void tableInsert(T newItem)throws TableException;//throw Exception fi it bombed
	public boolean tableDelete(KT searchKey);//true if deleted false if not
	public T tableRetrieve(KT searchKey);//returns item or null
	
	
	
	
	
	
	
	
}
