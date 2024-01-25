package p37;

import java.util.Arrays;

public class Solution {
    public void solveSudoku(char[][] board) {
        boolean [][] columnWisePresent = new boolean[9][9];
        boolean [][] rowWisePresent = new boolean[9][9];
        boolean [][][] groupWisePresent = new boolean[3][3][9];
    
        //iterate over the board mark all the numbers that are already given in the board.
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    continue;
                int d = board[i][j] - '1';
                columnWisePresent[j][d] = true;
                rowWisePresent[i][d] = true;
                groupWisePresent[i / 3][j / 3][d] = true;
            }
        }
        
        solveSudoku(board, 0, 0, columnWisePresent, rowWisePresent, groupWisePresent);
    }
    
    private boolean solveSudoku(char [][] board, int i, int j, boolean [][] columnWisePresent, boolean [][] rowWisePresent,
                                boolean [][][] groupWisePresent) {
        //if we have reach till the end while filling the board with valid numbers. We must finish here.
        if(i == 8 && j == 9)
            return true;
        
        //if value of j reach to 9, we must go to next row, first column
        if(j == 9)
            return solveSudoku(board, i + 1, 0, columnWisePresent, rowWisePresent, groupWisePresent);
        
        //if this position is already filled with a number we must go to next position.
        if(board[i][j] != '.')
            return solveSudoku(board, i, j + 1, columnWisePresent, rowWisePresent, groupWisePresent);
        
        //pick the next available number and fill current position with it.
        for(int num = 0; num < 9; num++) {
            if(!isPickable(i, j, num, columnWisePresent, rowWisePresent, groupWisePresent))
                continue;
            
            //num is picked for this position. So, update all the array
            groupWisePresent[i / 3][j / 3][num] = true;
            columnWisePresent[j][num] = true;
            rowWisePresent[i][num] = true;
            board[i][j] = (char) ('1' + num);
            
            //now solve next position
            if(solveSudoku(board, i, j, columnWisePresent, rowWisePresent, groupWisePresent))
                return true;
            
            //solve failed with current picked number. We must try next. Before we do that, we must reset all the changes done while picking
            board[i][j] = '.';
            rowWisePresent[i][num] = false;
            columnWisePresent[j][num] = false;
            groupWisePresent[i / 3][j / 3][num] = false;
        }
        return false;
    }
    
    private boolean isPickable(int i, int j, int num, boolean [][] columnWisePresent, boolean [][] rowWisePresent,
                               boolean [][][] groupWisePresent){
        return !groupWisePresent[i / 3][j / 3][num] && !columnWisePresent[j][num] && !rowWisePresent[i][num];
    }
}
