package p2373;

public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int m = n - 2;

        int [][] result = new int[m][m];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                result[i][j] = getMax(grid, i + 1, j + 1);
            }
        }

        return result;
    }

    private int getMax(int [][] grid, int midRow, int midCol) {
        //get max value from top row
        int max = Math.max(grid[midRow - 1][midCol - 1],
                Math.max(grid[midRow - 1][midCol], grid[midRow - 1][midCol + 1]));

        //get max value from middle row
        max = Math.max(max,
                Math.max(grid[midRow][midCol - 1],
                        Math.max(grid[midRow][midCol], grid[midRow][midCol + 1])));

        //get max value from last row
        max = Math.max(max,
                Math.max(grid[midRow + 1][midCol - 1],
                        Math.max(grid[midRow + 1][midCol], grid[midRow + 1][midCol + 1])));
        return max;
    }
}
