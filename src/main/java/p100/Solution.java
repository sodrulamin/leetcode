package p100;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 26/02/2024
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return false;

        if(p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
