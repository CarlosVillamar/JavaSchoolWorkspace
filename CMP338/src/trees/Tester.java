package trees;

public class Tester {

	public static void main(String[] args) {

		//go see page 589 // build the tree on page 575... the below tree is not it
		
		BinaryTree<Integer> myTree = new BinaryTree<Integer>(100);
		
		BinaryTree<Integer> anotherTree = new BinaryTree<Integer>(80);
		
		myTree.setRootItem(50);
		myTree.attachLeft(20);
		myTree.attachRight(60);
		
		
		

	}

}
