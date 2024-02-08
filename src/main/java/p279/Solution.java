package p279;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 08/02/2024
 */
public class Solution {

    private static final int[] dp = new int[10001];
    public int numSquares(int n) {
        for (int i = 1; i <= n; i++) {
            if(dp[i] != 0)
                continue;
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new Solution().numSquares(12);
    }
}
