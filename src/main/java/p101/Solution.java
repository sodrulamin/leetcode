package p101;

import data.TreeNode;

public class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        
        return isEqual(root.left, root.right);
    }
    
    /**
     * Check if both subtrees are equal or not.
     * @param left Left side node.
     * @param right Right side node.
     * @return true, if both nodes are equal along with all of its child, otherwise, return false.
     */
    private boolean isEqual(TreeNode left, TreeNode right) {
        //if left node is null, right node must be null, otherwise, we return false.
        if(left == null)
            return right == null;
        
        //at this step left node is not null, so if right node is null, we must return false.
        if(right == null)
            return false;
        
        //at first, we check the value of the given two nodes, if they doesn't match we must return false.
        if(left.val != right.val)
            return false;
        
        //then we symmetrically forward both nodes and check equality again.
        return isEqual(left.left, right.right) && isEqual(left.right, right.left);
    }
}
