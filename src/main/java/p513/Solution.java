package p513;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 28/02/2024
 */
public class Solution {
    private int result;
    private int maxHeight;

    public int findBottomLeftValue(TreeNode root) {
        result = root.val;
        maxHeight = Integer.MIN_VALUE;

        traverse(root, 0);

        return result;
    }

    private void traverse(TreeNode node, int currentHeight) {
        if (node == null)
            return;

        if(currentHeight > maxHeight) {
            maxHeight = currentHeight;
            result = node.val;
        }
        currentHeight++;

        traverse(node.left, currentHeight);
        traverse(node.right, currentHeight);
    }
}
