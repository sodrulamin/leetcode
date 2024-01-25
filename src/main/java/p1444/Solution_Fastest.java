package p1444;

public class Solution_Fastest {
    public int ways(String[] pizza, int k) {
        int rows = pizza.length;
        int cols = pizza[0].length();
        
        long[][][] dp = new long[k + 1][rows][cols];
        int[][] preSum = new int[rows + 1][cols + 1];
        
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                preSum[i][j] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i + 1][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
                dp[1][i][j] = (preSum[i][j] > 0 ? 1 : 0);
            }
        }
        
        for (int pieces = 2; pieces <= k; pieces++) {
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    long ways = 0;
                    
                    for (int nr = row + 1; nr < rows; nr++) {
                        if (preSum[row][col] - preSum[nr][col] > 0) { // there is at least one apple in the top piece
                            ways += dp[pieces - 1][nr][col];
                        }
                    }
                    
                    for (int nc = col + 1; nc < cols; nc++) {
                        if (preSum[row][col] - preSum[row][nc] > 0) { // there is at least one apple in the left piece
                            ways += dp[pieces - 1][row][nc];
                        }
                    }
                    
                    dp[pieces][row][col] = ways;
                }
            }
        }
        return (int)(dp[k][0][0] % 1000000007L);
    }
}
