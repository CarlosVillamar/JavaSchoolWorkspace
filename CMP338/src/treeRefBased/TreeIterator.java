package treeRefBased;

import java.util.LinkedList;

public class TreeIterator<T> implements java.util.Iterator<T>{

	
	private BinaryTreeRefBased<T> binTree;
	private TreeNode<T> currNode;
	private LinkedList <TreeNode<T>> queue; //JCF linked list
	
	public TreeIterator(BinaryTreeRefBased<T> bTree){
		binTree = bTree;
		currNode = null;
		queue = new LinkedList<TreeNode<T>>();
	}
	
	
	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	@Override
	public T next() throws java.util.NoSuchElementException{
		currNode = queue.remove();
		return currNode.item;
	}

	@Override
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	//preorder
	/*
	 * preorder visits the root node
	 * then it visits the left child
	 * then each left child down to the leaf
	 * the up to h-1 of the current node and goes to the right child...
	 * and descends to each left child of that subtree
	 */
	private void preorder(TreeNode<T> treeNode){
		if(treeNode !=null){
			queue.add(treeNode);
			preorder(treeNode.leftChild);
			preorder(treeNode.rightChild);
		}
	}
	
	//inorder
	/*
	 * visits the leftmost leaf first
	 * then the parent of that node
	 * then the leftmost leaf of that subtree
	 * then the h-1 node of that leaf
	 * then repeat on the right subtree
	 */
	private void inorder(TreeNode<T> treeNode){
		if(treeNode !=null){
			inorder(treeNode.leftChild);
			queue.add(treeNode);
			inorder(treeNode.rightChild);
		}
	}
	
	//postorder
	/*
	 * postorder visits the leftmost leaf first
	 * then the next leaf of the same subtree if there is one.. otherwise
	 * visits all the leaves of the parent node from left to right
	 * after both subtrees/leaves are visited then the root of that subtree
	 */private void postorder(TreeNode<T> treeNode){
			if(treeNode !=null){
				postorder(treeNode.leftChild);
				postorder(treeNode.rightChild);
				queue.add(treeNode);
			}
	 }
			
	public void setPreOrder(){
		queue.clear();
		preorder(binTree.root);
	}
	public void setInOrder(){
		queue.clear();
		inorder(binTree.root);
	}
	public void setPostOrder(){
		queue.clear();
		postorder(binTree.root);
	}
	

}
