package treeRefBased;

public class Tester {
	//go see page 589 
			// build the tree on page 575... the below tree is not it
			/* build the tree in figure 11-10 on page 575
			 * 				  -60-
			 * 				/		\
			 * 			-20-	   	-70-
			 * 			/	\
			 * 		 -10    -40-
			 * 				/	\
			 * 			 -30-   -50-				
			 * 
			 */

	public static void main(String[] args) {

		BinaryTree<Integer> treeA = new BinaryTree<Integer>();
		treeA.setRootItem(40);
		treeA.attachLeft(30);
		treeA.attachRight(50);
		
		BinaryTree<Integer> treeB = new BinaryTree<Integer>();
		treeB.setRootItem(20);
		treeB.attachLeft(10);
		treeB.attachRightSubTree(treeA);
		
		BinaryTree<Integer> treeMain = new BinaryTree<Integer>(60);
		treeMain.attachLeftSubTree(treeB);
		treeMain.attachRight(70);
		
		
		System.out.println("I LIKE TREES THEY ARE MULTICOLOR NOW");
		TreeIterator<Integer> bIter = new TreeIterator<Integer>(treeMain);
		//bIter.setInOrder();
		//bIter.setPreOrder();
		//bIter.setPostOrder();
		while(bIter.hasNext()){
			System.out.print(bIter.next()+"\t");
		}

	}

}
