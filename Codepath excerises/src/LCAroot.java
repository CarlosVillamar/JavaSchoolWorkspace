/*
LCA
p, q
p and q can be the LCA
p and q are always in the tree and unique

test cases :
1 . p/q was the LCA
2. 
  1
  / \
  p q

*/

class Node {
	int val;
	Node left;
	Node right;

	Node(int x) {
		val = x;
		left = null;
		right = null;
	}
}

// p = 5, q = 1
/*
 * root = 3 root = 5 return 5 (left) root = 1 return 3 (right) return 3
 * 
 * p = 5, q = 4 root = 3 root = 5 return 5 (left) root = 1 root = 0 return right
 * root = 8 return return left
 * 
 */
class LCAroot {

	/*
	 * 			100 
	 * 			/ \
	 *  	   2 3 
	 *  	 / \ / \ 
	 *    4 5 6 7
	 */
	public static void main(String[] arg) {
		Node root = new Node(100);

		Node left = new Node(2);
		root.left = left;

		Node right = new Node(3);
		root.right = right;

		Node four = new Node(4);
		left.left = four;

		Node five = new Node(5);
		left.right = five;

		Node six = new Node(6);
		right.left = six;

		Node seven = new Node(7);
		right.right = seven;

		Node result = LCA(root, null, seven);
		System.out.println(result.val);
	}

	public static Node LCA(Node root, Node p, Node q) {
		if (root == null)
			return root;
		if (root == p || root == q)
			return root;

		Node left = LCA(root.left, p, q);
		Node right = LCA(root.right, p, q);

		if (left == null)
			return right;
		else if (right == null)
			return left;

		return root;
	}
}