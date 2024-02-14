package p2149;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 14/02/2024
 */
public class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] ans = new int[nums.length];
        int a = 0, b = 1;

        for (int num : nums) {
            if (num > 0) {
                ans[a] = num;
                a += 2;
            } else {
                ans[b] = num;
                b += 2;
            }
        }

        return ans;
    }
}
