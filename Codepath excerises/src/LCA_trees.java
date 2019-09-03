import java.util.*;

public class LCA_trees {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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

    private static TreeNode readNode(TreeNode root, Scanner in) {
        int val = in.nextInt();
        return findNode(root, val);
    }

    private static TreeNode findNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode left = findNode(root.left, val);
        TreeNode right = findNode(root.right, val);
        return (left != null) ? left : right;
    }

/**
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    /* Write your code here */

    if(root == null) return root;
    if(root == p ||root ==q) return root;


    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if(left ==null) return right;
    else if (right== null) return left;

    return root;


}

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        TreeNode root = readBinaryTree(in);
        TreeNode p = readNode(root, in);
        TreeNode q = readNode(root, in);

        TreeNode lowestCommonAncestor = lowestCommonAncestor(root, p, q);

        System.out.println(lowestCommonAncestor.val);
    }
}
