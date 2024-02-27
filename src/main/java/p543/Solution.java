package p543;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 27/02/2024
 */
public class Solution {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        traverseTree(root);
        return max;
    }

    private int traverseTree (TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = traverseTree(node.left);
        int right = traverseTree(node.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}
