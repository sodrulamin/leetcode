package p1043;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 03/02/2024
 */
public class Solution {
    private int [][] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length][arr.length];
        for(int [] a: dp)
            Arrays.fill(a, -1);

        return getSum(arr, 0, arr.length - 1, k);
    }

    private int getSum(int [] arr, int start, int end, int k){
        //only one element in the partition
        if(start == end)
            return arr[start];

        //already calculated once.
        if(dp[start][end] != -1)
            return dp[start][end];

        int ans = -1;

        //found one possible partition.
        if(end - start < k) {
            int max = -1;
            for(int i = start; i <= end; i++)
                max = Math.max(arr[i], max);

            ans = max * (end - start + 1);
        }

        //now calculated other partitions as well.
        for(int i = 0; i < k; i++){
            if(start + i == end)
                break;
            ans = Math.max(ans, getSum(arr, start, start + i, k) + getSum(arr, start + i + 1, end, k));
        }

        dp[start][end] = ans;

        return ans;
    }

    public static void main(String[] args) {
        int [] array = {1,4,1,5,7,3,6,1,9,9,3};
        System.out.println(new Solution().maxSumAfterPartitioning(array, 4));
    }
}
