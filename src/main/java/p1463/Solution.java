package p1463;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 11/02/2024
 */
public class Solution {
    Integer[][][] memo;

    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        memo = new Integer[rows + 1][cols + 1][cols + 1];
        return helper(grid, 0, 0, cols - 1);
    }

    public int helper(int[][] grid, int currRow, int robotACol, int robotBCol) {

        if (robotACol < 0 || robotBCol < 0 || robotACol >= grid[0].length || robotBCol >= grid[0].length) {
            return 0;
        }

        if (currRow == grid.length) {
            return 0;
        }

        if (memo[currRow][robotACol][robotBCol] != null) {
            return memo[currRow][robotACol][robotBCol];
        }

        int result = 0;
        result += grid[currRow][robotACol];
        result += grid[currRow][robotBCol];

        int max = 0;
        for (int x = robotACol - 1; x <= robotACol + 1; x++) {
            for (int y = robotBCol - 1; y <= robotBCol + 1; y++) {
                if (x < y) { // they should not cross
                    max = Math.max(max, helper(grid, currRow + 1, x, y));
                }
            }
        }

        result += max;
        return memo[currRow][robotACol][robotBCol] = result;
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};

        System.out.println(new Solution().cherryPickup(grid));
    }
}
