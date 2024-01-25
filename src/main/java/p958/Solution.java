package p958;

import data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean treeEnded = false;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size > 0) {
                size--;
                
                TreeNode node = queue.remove();
                if(node.left == null)
                    treeEnded = true;
                else if(treeEnded)
                    return false;
                else
                    queue.add(node.left);
                
                if(node.right == null)
                    treeEnded = true;
                else if(treeEnded)
                    return false;
                else
                    queue.add(node.right);
            }
        }
        
        return true;
    }
}
