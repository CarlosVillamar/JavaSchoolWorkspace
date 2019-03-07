package treeRefBased;

public class BinaryTree<T> extends BinaryTreeRefBased<T>{

	
	public BinaryTree(){
		super();
	}
	
	public BinaryTree(T rootItem){
		super(rootItem);
	}
	
	public BinaryTree(T rootItem, BinaryTree<T> leftTree, BinaryTree<T> rightTree ){
		root = new TreeNode<T>(rootItem, null, null);
		attachLeftSubTree(leftTree);
		attachRightSubTree(rightTree);
		
		
	}
	private BinaryTree(TreeNode<T> rootNode){
		root = rootNode;
	}
	
	protected void attachRightSubTree(BinaryTree<T> rightTree){
		if(isEmpty()){
			throw new TreeException("EMPTY TREE cannot attach right subtree");
		}
		else if(root.rightChild != null){
			throw new TreeException("RIGHT SUBTREE EXISTS cannot attach right subtree");
		}
		else{
			root.rightChild = rightTree.root;
			rightTree.makeEmpty();
		}
		
	}

	protected void attachLeftSubTree(BinaryTree<T> leftTree) {
		if(isEmpty()){
			throw new TreeException("EMPTY TREE cannot attach left subtree");
		}
		else if(root.leftChild != null){
			throw new TreeException("LEFT SUBTREE EXISTS cannot attach left subtree");
		}
		else{
			root.leftChild = leftTree.root;
			leftTree.makeEmpty();
		}
		
	}

	
	@Override
	public void setRootItem(T item) throws UnsupportedOperationException {
		if(root!=null){
			root.item = item;
		}
		else{
			root = new TreeNode<T>(item, null, null);
		}
	}

	public void attachLeft(T item){
		if( (!isEmpty()) &&  (root.leftChild ==null)){
			root.leftChild = new TreeNode<T>(item, null,null);
		}
	}
	public void attachRight(T item){
		if( (!isEmpty()) &&  (root.rightChild ==null)){
			root.rightChild = new TreeNode<T>(item, null,null);
		}
	}
	
	public BinaryTree<T> detachLeftSubTree() throws TreeException{
		if(isEmpty()){
			throw new TreeException("EMPTY TREE - cannot detach left subtree");
		}
		else{
			BinaryTree<T> leftTree;
			leftTree = new BinaryTree<T>(root.leftChild);
			root.leftChild = null;
			return leftTree;
		}
	}
	public BinaryTree<T> detachRightSubTree() throws TreeException{
		if(isEmpty()){
			throw new TreeException("EMPTY TREE - cannot detach right subtree");
		}
		else{
			BinaryTree<T> rightTree;
			rightTree = new BinaryTree<T>(root.rightChild);
			root.rightChild = null;
			return rightTree;
		}
	}
	
	
	
	

	
	
	
	
	
	
	
}
