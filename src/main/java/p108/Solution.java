package p108;

import data.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> positionMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            positionMap.put(inorder[i], i);
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1,
                positionMap);
    }
    
    private TreeNode buildTree(int [] inorder, int inStart, int inEnd, int [] postorder, int postStart, int postEnd,
                               Map<Integer, Integer> positionMap) {
        if(inStart > inEnd)
            return null;
        if(inStart == inEnd)
            return new TreeNode(inorder[inStart]);
        
        TreeNode node = new TreeNode(postorder[postEnd]);
        int index = positionMap.get(node.val);
        
        int leftLength = index - inStart;
        
        node.left = buildTree(inorder, inStart, index - 1, postorder, postStart, postStart + leftLength - 1, positionMap);
        node.right = buildTree(inorder, index + 1, inEnd, postorder, postStart + leftLength, postEnd - 1, positionMap);
        
        return node;
    }
    
    public static void main(String[] args) {
        int [] inorder = {3,2,1};
        int [] postOrder = {3,2,1};
        new Solution().buildTree(inorder, postOrder);
    }
}
