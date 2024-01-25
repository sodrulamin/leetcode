package p129;

import data.TreeNode;

public class Solution {
    
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        return getSum(root, 0, 0);
    }
    
    private int getSum(TreeNode node, int total, int currentNum) {
        currentNum = currentNum * 10 + node.val;
        
        if(node.left == null && node.right == null)
            return total + currentNum;
        
        if(node.left != null)
            total = getSum(node.left, total, currentNum);
        
        if(node.right != null)
            total = getSum(node.right, total, currentNum);
        
        return total;
    }
}
