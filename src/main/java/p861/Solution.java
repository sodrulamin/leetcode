package p861;

public class Solution {
    public int matrixScore(int[][] grid) {

        for (int [] row: grid) {
            if (row[0] == 1)
                continue;

            for (int j = 0; j < row.length; j++) {
                row[j] = 1 - row[j];
            }
        }

        for(int j = 1; j < grid[0].length; j++) {
            int zero = 0, one = 0;

            for (int[] row : grid) {
                if (row[j] == 1) {
                    one++;
                } else
                    zero++;
            }

            if(one >= zero) {
                continue;
            }

            for (int[] row : grid) {
                row[j] = 1 - row[j];
            }
        }

        return getSum(grid);
    }

    private int getSum(int[][] grid) {
        int result = 0;
        for (int[] row : grid) {
            int sum = 0;

            for (int i : row) {
                sum = sum * 2 + i;
            }

            result += sum;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};

        System.out.println(new Solution().matrixScore(grid));
    }
}
