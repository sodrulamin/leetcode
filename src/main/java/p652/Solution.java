package p652;

import data.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> resultSet = new ArrayList<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        
        traverse(root, resultSet, countMap);
        
        return resultSet;
    }
    
    private String traverse(TreeNode node, List<TreeNode> resultSet, HashMap<String, Integer> countMap) {
        if (node == null)
            return "";
        
        String structure = "[" + traverse(node.left, resultSet, countMap) + "->" + node.val + "<-" + traverse(node.right,
                resultSet, countMap) + "]";
        
        
        Integer count = countMap.get(structure);
        
        if (count == null)
            count = 0;
        if (count == 1) {
            resultSet.add(node);
        }
        
        countMap.put(structure, count + 1);
        
        return structure;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0,
                new TreeNode(0, new TreeNode(0), null),
                new TreeNode(0, null, new TreeNode(0, null, new TreeNode(0))));
    
        System.out.println(new Solution().findDuplicateSubtrees(root));
    }
}
