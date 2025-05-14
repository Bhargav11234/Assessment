import java.util.*;

// sec 3 Find the Diameter of a Binary Tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class Diameter {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // Diameter off this node is left depth + right depth node
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // Return max depth including this node
        return 1 + Math.max(leftDepth, rightDepth);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);

        Diameter tree = new Diameter();
        System.out.println("Diameter is :" + tree.diameterOfBinaryTree(root)); 
    }
}
