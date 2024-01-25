package p103;

import data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
    
    
        Stack<TreeNode> currentNodes = new Stack<>();
        currentNodes.add(root);
        boolean rightToLeft = false;
        
        while (!currentNodes.isEmpty()) {
            Stack<TreeNode> nextNodes = new Stack<>();
            List<Integer> list = new ArrayList<>();
            
            while (!currentNodes.isEmpty()) {
                TreeNode node = currentNodes.pop();
                list.add(node.val);
                if(rightToLeft){
                    if(node.right != null)
                        nextNodes.add(node.right);
                    if(node.left != null)
                        nextNodes.add(node.left);
                }
                else {
                    if(node.left != null)
                        nextNodes.add(node.left);
                    if(node.right != null)
                        nextNodes.add(node.right);
                }
            }
            
            rightToLeft = !rightToLeft;
            currentNodes = nextNodes;
            result.add(list);
        }
        
        return result;
    }
    
    private static final int NULL = 200;
    public static void main(String[] args) {
        int [] nodes = {3,9, 20, NULL, NULL, 15, 7};
        
        TreeNode root = formTree(nodes, 0);
        System.out.println(new Solution().zigzagLevelOrder(root));
    }
    
    private static TreeNode formTree(int [] array, int index){
        if(index >= array.length || array[index] == NULL)
            return null;
        
        TreeNode node = new TreeNode(array[index]);
        node.left = formTree(array, index * 2 + 1);
        node.right = formTree(array, index * 2 + 2);
        
        return node;
    }
}
