package p1143;

import java.util.Arrays;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 25/01/2024
 */
class Solution {
    private int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length() + 1][text2.length() + 1];
        for(int [] arr: dp) {
            Arrays.fill(arr, -1);
        }
        return lcs(text1, text2, 0, 0);
    }

    private int lcs(String text1, String text2, int i, int j) {
        if(i == text1.length() || j == text2.length()) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)) {
            return 1 + lcs(text1, text2, i + 1, j + 1);
        }

        dp[i][j] = Math.max(lcs(text1, text2, i + 1, j), lcs(text1, text2, i, j + 1));
        return dp[i][j];
    }
}