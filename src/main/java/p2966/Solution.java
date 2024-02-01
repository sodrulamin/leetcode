package p2966;

import java.util.Arrays;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 01/02/2024
 */
class Solution {
    private static final int ARRAY_SIZE = 3;
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int totalArray = n / ARRAY_SIZE;
        int [][] ans = new int[totalArray][ARRAY_SIZE];

        for(int i = 0; i < totalArray; i++) {
            int index = i * ARRAY_SIZE;
            if(satisfy(nums, index, k)) {
                System.arraycopy(nums, index, ans[i], 0, ARRAY_SIZE);
            }
            else
                return new int[][]{};
        }

        return ans;
    }

    private static boolean satisfy (int [] num, int i, int k) {
        return (num[i + ARRAY_SIZE - 1] - num[i]) <= k;
    }

    public static void main(String[] args) {
        int [] nums = {4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11};
        System.out.println(Arrays.deepToString(new Solution().divideArray(nums, 14)));
    }
}