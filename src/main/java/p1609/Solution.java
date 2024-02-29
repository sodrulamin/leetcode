package p1609;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 29/02/2024
 */
public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean evenIndex = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int previousNumber = evenIndex ? Integer.MIN_VALUE: Integer.MAX_VALUE;

            while (size > 0) {
                size--;
                TreeNode node = queue.poll();
                if(node == null)
                    continue;

                if(evenIndex) {
                    if(node.val % 2 == 0 || node.val <= previousNumber)
                        return false;
                }
                else {
                    if(node.val % 2 == 1 || node.val >= previousNumber)
                        return false;
                }
                previousNumber = node.val;

                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);

            }
            evenIndex = !evenIndex;
        }

        return true;
    }
}
