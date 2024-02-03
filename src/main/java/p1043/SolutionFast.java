package p1043;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 03/02/2024
 */
public class SolutionFast {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int [] dp = new int[arr.length + 1];
        for(int index = arr.length - 1; index >= 0; index--){
            int max = Integer.MIN_VALUE;
            int ans = Integer.MIN_VALUE;
            int len = 0;
            for(int i = index; i < index + k && i < arr.length; i++){
                len++;
                max = Math.max(max, arr[i]);
                ans = Math.max(ans, len * max + dp[i + 1]);
            }
            dp[index] =  ans;
        }
        return dp[0];
    }
}
