package p1219;

public class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, traverse(grid, i, j, 0));
            }
        }

        return max;
    }

    private int traverse(int [][] grid, int row, int col, int gold) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return gold;

        int value = grid[row][col];
        if(value == 0)
            return gold;

        grid[row][col] = 0;

        gold += value;

        //visit left
        int maxGold = traverse(grid, row, col - 1, gold);

        //visit right
        maxGold = Math.max(maxGold, traverse(grid, row, col + 1, gold));

        //visit up
        maxGold = Math.max(maxGold, traverse(grid, row - 1, col, gold));

        //visit down
        maxGold = Math.max(maxGold, traverse(grid, row + 1, col, gold));

        grid[row][col] = value;

        return maxGold;
    }
}