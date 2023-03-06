package p36;

import java.util.Arrays;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int [][] columnWiseCount = new int[9][9];
        int [] rowWiseCount = new int[9];
        int [][][] groupWiseCount = new int[3][3][9];
        
        for(int i = 0; i < 9; i++) {
            Arrays.fill(rowWiseCount, 0);
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    continue;
                int d = board[i][j] - '1';
                if(++columnWiseCount[j][d] > 1)
                    return false;
                
                if(++rowWiseCount[d] > 1)
                    return false;
                
                if(++groupWiseCount[i / 3][j / 3][d] > 1)
                    return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
//        char [][] grid = {{'8','3','.','.','7','.','.','.','.'}
//                ,{'6','.','.','1','9','5','.','.','.'}
//                ,{'.','9','8','.','.','.','.','6','.'}
//                ,{'8','.','.','.','6','.','.','.','3'}
//                ,{'4','.','.','8','.','3','.','.','1'}
//                ,{'7','.','.','.','2','.','.','.','6'}
//                ,{'.','6','.','.','.','.','2','8','.'}
//                ,{'.','.','.','4','1','9','.','.','5'}
//                ,{'.','.','.','.','8','.','.','7','9'}};
        char [][] grid = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
    
        System.out.println(new Solution().isValidSudoku(grid));
    }
}
