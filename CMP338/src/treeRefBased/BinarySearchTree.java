package treeRefBased;

public class BinarySearchTree 
<T extends KeyedItem<KT>, KT extends Comparable<? super KT>>
	extends BinaryTreeRefBased {
	
	public BinarySearchTree(){
		
	}
	
	@SuppressWarnings("unchecked")
	public BinarySearchTree(T rootItem){
		super(rootItem);
	}

	@Override
	public void setRootItem(Object item) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	public void insert(T item){
		root = insertItem(root, item);
	}

	public T retrieve(KT searchKey){
		return (T) retrieveItem(root, searchKey);
	}
	public void delete(KT searchKey){
		root = deleteItem(root, searchKey);
	}

	public void delete(T item){
		root = deleteItem(root, item.getKey());
	}
	
	
	protected T retrieveItem(TreeNode<T> root, KT searchKey) {
		// TODO Auto-generated method stub
		T Item = null;
		if(root==null)
		{
			Item = null;
		}
		else{
			T treeItem = root.item;
			if(searchKey.compareTo(treeItem.getKey())== 0)
		{
			Item = root.item;
		}

		else if (searchKey.compareTo(treeItem.getKey())<0)
		{
			Item = retrieveItem(root.leftChild,searchKey);
		}
		else if(searchKey.compareTo(treeItem.getKey())>0)
		{
			Item = retrieveItem(root.rightChild,searchKey);
		}
		}
		return Item;}
		
		/*T item;
		if(node == null){
			item = null;
		}
		else{
			T nodeItem = node.item; // item that got passed in
			if(searchKey.compareTo(nodeItem.getKey())  == 0){
				item = node.item;
			}
			else if(searchKey.compareTo(nodeItem.getKey())  < 0){//go left
				item = retrieveItem(node.leftChild, searchKey);//recursive call
			}
			else{//go right
				item = retrieveItem(node.rightChild, searchKey); //recursive call
			}
		}
		return item;*/
		

	protected TreeNode<T> insertItem(TreeNode<T> tNode, T item) {
		TreeNode<T> newSubTree;
		if(tNode == null){//insert after leaf
			tNode = new TreeNode<T>(item, null, null);
			return tNode;
		}
		T nodeItem = tNode.item;
		if(item.getKey().compareTo(nodeItem.getKey())  < 0){//go left
			newSubTree = insertItem(tNode.leftChild, item); //recursive call
			tNode.leftChild = newSubTree;
			return tNode;
		}
		else{//go right
			newSubTree = insertItem(tNode.rightChild, item);
			tNode.rightChild = newSubTree;
			return tNode;
		}
	}
	protected TreeNode<T> deleteItem(TreeNode<T> tNode, KT searchKey){
		TreeNode<T> newSubTree;
		if(tNode == null){
			throw new TreeException("ITEM NOT FOUND");
		}
		else{
			T nodeItem = tNode.item;
			if(searchKey.compareTo(nodeItem.getKey())  == 0){
				tNode = deleteNode(tNode); // call deleteNode method
			}
			else if(searchKey.compareTo(nodeItem.getKey())  < 0){
				newSubTree = deleteItem(tNode.leftChild, searchKey); //recursive call
				tNode.leftChild = newSubTree;
			}
			else{
				newSubTree = deleteItem(tNode.rightChild, searchKey); //recursive call
				tNode.rightChild = newSubTree;
	
			}
			
		}
		return tNode;
		
		
	}
	protected TreeNode<T> deleteNode(TreeNode<T> node){
		T replacement;
		
		if( (node.leftChild == null) && (node.rightChild ==null)){
			return null;
		}
		else if(node.leftChild == null){//has no left
			return node.rightChild;
		}
		else if(node.rightChild == null){//has no right
			return node.leftChild;
		}
		else{//2 children
			replacement = findLeftMost(node.rightChild);//find inorder next 
			node.item = replacement;
			node.rightChild = deleteLeftMost(node.rightChild);//delete the next guy that was found
			return node;
		}
		
	}
	private TreeNode<T> deleteLeftMost(TreeNode<T> node) {
		if(node.leftChild == null){
			return node.rightChild;//no left child
		}
		else{
			node.leftChild = deleteLeftMost(node.leftChild); //recursive call
			return node;
		}
	}

	private T findLeftMost(TreeNode<T> node) {
		if(node.leftChild == null){
			return node.item; // no left child this node is the leftmost
		}
		else{
			return findLeftMost(node.leftChild); //recursive call
		}
	}
	
}
