import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class invertBTree {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static TreeNode readBinaryTree(Scanner in) {
		int numNodes = in.nextInt();
		if (numNodes == 0) {
			return null;
		}

		ArrayList<TreeNode> nodes = new ArrayList<>();
		int currentParentIndex = 0;

		TreeNode root = new TreeNode(in.nextInt());
		nodes.add(root);

		for (int i = 1; i < numNodes; i += 2) {
			int leftData = in.nextInt();
			if (leftData != -1) {
				TreeNode left = new TreeNode(leftData);
				nodes.add(left);
				nodes.get(currentParentIndex).left = left;
			}

			int rightData = in.nextInt();
			if (rightData != -1) {
				TreeNode right = new TreeNode(rightData);
				nodes.add(right);
				nodes.get(currentParentIndex).right = right;
			}

			currentParentIndex += 1;
		}

		return root;
	}

	private static String description(TreeNode root) {
		if (root == null) {
			return " ";
		}

		StringBuilder output = new StringBuilder();
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();

		output.append(root.val);
		queue.add(root);
		int cursor = 0;

		while (cursor < queue.size()) {
			TreeNode node = queue.get(cursor++);

			if (node.left != null) {
				output.append(" " + node.left.val);
				queue.add(node.left);
			}

			if (node.right != null) {
				output.append(" " + node.right.val);
				queue.add(node.right);
			}
		}

		return output.toString();
	}

	/**
	 * public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
	 * x) { val = x; } }
	 */

	static TreeNode invertBinaryTree(TreeNode root) {
		/* Write your code here */

		// taken the root and swap its children
		if (root == null)
			return root;

		swap(root);

		invertBinaryTree(root.left);
		invertBinaryTree(root.right);

		return root;
	}

	public static void swap(TreeNode root) {

		TreeNode temp = root.left;

		root.left = root.right;
		root.right = temp;
	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		TreeNode root = readBinaryTree(in);

		TreeNode invertedTree = invertBinaryTree(root);

		System.out.println(description(invertedTree));
	}
}
