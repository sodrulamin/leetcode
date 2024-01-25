package p64;

import java.util.Arrays;

public class Solution {
    int [][] minDistance;
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        minDistance = new int[m][n];
        for(int [] a: minDistance) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        minDistance[m - 1][n - 1] = grid[m - 1][n - 1];
        visitTo(grid, 0, 0);
        return minDistance[0][0];
    }
    
    private int visitTo(int [][] grid, int i, int j) {
        if(minDistance[i][j] != Integer.MAX_VALUE)
            return minDistance[i][j];
        
        if(i < grid.length - 1)
            minDistance[i][j] = Math.min(minDistance[i][j], grid[i][j] + visitTo(grid, i + 1, j));
        
        if(j < grid[0].length - 1)
            minDistance[i][j] = Math.min(minDistance[i][j], grid[i][j] + visitTo(grid, i, j + 1));
        
        return minDistance[i][j];
    }
    
    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
    
        System.out.println(new Solution().minPathSum(grid));
    }
}
