package tables;

import treeRefBased.BinarySearchTree;
import treeRefBased.KeyedItem;
import treeRefBased.TreeException;

public class TableBSTBased <T extends KeyedItem<KT>, KT extends Comparable<? super KT>>
implements TableInterface<T,KT>{
	protected BinarySearchTree bst;  //storing our records
	protected int size;//number of records in the table
	
	
	public TableBSTBased(){
		bst = new BinarySearchTree();
		size = 0;
	}
	protected void setSize(int newSize){
		size = newSize;
	}
	
	@Override
	public boolean tableIsEmpty() {
		return (size == 0);
	}

	@Override
	public int tableLength() {
		return size;
	}

	
	@Override
	public boolean tableDelete(Comparable searchKey) {
		try{
		bst.delete(searchKey);
		}
		catch(TreeException treeE){
			return false; //return false if not
		}
		size--;
		return true;//was successfully deleted
	}

	@Override
	public T tableRetrieve(Comparable searchKey) {
		return (T) bst.retrieve(searchKey);
	}
	@Override
	public void tableInsert(T newItem) throws TableException {
		if(bst.retrieve(newItem.getKey())  ==null){
			bst.insert(newItem);
			size++;
		}
	}

}
