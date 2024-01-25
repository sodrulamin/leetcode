package p1444;

import java.util.Arrays;

/**
 * <a href="https://www.youtube.com/watch?v=4XxbmV6Ikz8">...</a>
 */
public class Solution_Recursion {
    private static final long MOD = (long) (1e9 + 7);
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int [][] appleCount = new int[m + 1][n + 1];
    
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                appleCount[i][j] = appleCount[i + 1][j] + appleCount[i][j + 1] - appleCount[i + 1][j + 1];
                if(pizza[i].charAt(j) == 'A')
                    appleCount[i][j]++;
            }
        }
    
        long [][][] cutCount = new long[m][n][k + 1];
        
        for(long [][] a: cutCount)
            for (long [] b: a)
                Arrays.fill(b, -1);
        
        return (int) getCutCount(appleCount, cutCount, 0, 0, m, n, k);
    }
    
    private long getCutCount(int [][] appleCount, long [][][] cutCount, int row, int col, int m, int n, int k) {
        if(cutCount[row][col][k] != -1)
            return cutCount[row][col][k];
        
        if(k == 1) {
            if(appleCount[row][col] > 0)
                cutCount[row][col][k] = 1;
            else
                cutCount[row][col][k] = 0;
            
            return cutCount[row][col][k];
        }
        
        long result = 0;
        
        for(int i = row + 1; i < m; i++) {
            if(appleCount[i][col] == 0)
                break;
            
            if(appleCount[row][col] > appleCount[i][col])
                result += getCutCount(appleCount, cutCount, i, col, m, n, k - 1);
        }
        
        for(int j = col + 1; j < n; j++) {
            if(appleCount[row][j] == 0)
                break;
            
            if(appleCount[row][col] > appleCount[row][j])
                result += getCutCount(appleCount, cutCount, row, j, m, n, k - 1);
        }
        
        cutCount[row][col][k] = result % MOD;
        return cutCount[row][col][k];
    }
    
    public static void main(String[] args) {
        String [] pizza = {"..A.A.AAA...AAAAAA.AA..A..A.A......A.AAA.AAAAAA.AA","A.AA.A.....AA..AA.AA.A....AAA.A........AAAAA.A.AA.","A..AA.AAA..AAAAAAAA..AA...A..A...A..AAA...AAAA..AA","....A.A.AA.AA.AA...A.AA.AAA...A....AA.......A..AA.","AAA....AA.A.A.AAA...A..A....A..AAAA...A.A.A.AAAA..","....AA..A.AA..A.A...A.A..AAAA..AAAA.A.AA..AAA...AA","A..A.AA.AA.A.A.AA..A.A..A.A.AAA....AAAAA.A.AA..A.A",".AA.A...AAAAA.A..A....A...A.AAAA.AA..A.AA.AAAA.AA.","A.AA.AAAA.....AA..AAA..AAAAAAA...AA.A..A.AAAAA.A..","A.A...A.A...A..A...A.AAAA.A..A....A..AA.AAA.AA.AA.",".A.A.A....AAA..AAA...A.AA..AAAAAAA.....AA....A....","..AAAAAA..A..A...AA.A..A.AA......A.AA....A.A.AAAA.","...A.AA.AAA.AA....A..AAAA...A..AAA.AAAA.A.....AA.A","A.AAAAA..A...AAAAAAAA.AAA.....A.AAA.AA.A..A.A.A...","A.A.AA...A.A.AA...A.AA.AA....AA...AA.A..A.AA....AA","AA.A..A.AA..AAAAA...A..AAAAA.AA..AA.AA.A..AAAAA..A","...AA....AAAA.A...AA....AAAAA.A.AAAA.A.AA..AA..AAA","..AAAA..AA..A.AA.A.A.AA...A...AAAAAAA..A.AAA..AA.A","AA....AA....AA.A......AAA...A...A.AA.A.AA.A.A.AA.A","A.AAAA..AA..A..AAA.AAA.A....AAA.....A..A.AA.A.A...","..AA...AAAAA.A.A......AA...A..AAA.AA..A.A.A.AA..A.",".......AA..AA.AAA.A....A...A.AA..A.A..AAAAAAA.AA.A",".A.AAA.AA..A.A.A.A.A.AA...AAAA.A.A.AA..A...A.AAA..","A..AAAAA.A..A..A.A..AA..A...AAA.AA.A.A.AAA..A.AA..","A.AAA.A.AAAAA....AA..A.AAA.A..AA...AA..A.A.A.AA.AA",".A..AAAA.A.A.A.A.......AAAA.AA...AA..AAA..A...A.AA","A.A.A.A..A...AA..A.AAA..AAAAA.AA.A.A.A..AA.A.A....","A..A..A.A.AA.A....A...A......A.AA.AAA..A.AA...AA..",".....A..A...A.A...A..A.AA.A...AA..AAA...AA..A.AAA.","A...AA..A..AA.A.A.AAA..AA..AAA...AAA..AAA.AAAAA...","AA...AAA.AAA...AAAA..A...A..A...AA...A..AA.A...A..","A.AA..AAAA.AA.AAA.A.AA.A..AAAAA.A...A.A...A.AA....","A.......AA....AA..AAA.AAAAAAA.A.AA..A.A.AA....AA..",".A.A...AA..AA...AA.AAAA.....A..A..A.AA.A.AA...A.AA","..AA.AA.AA..A...AA.AA.AAAAAA.....A.AA..AA......A..","AAA..AA...A....A....AA.AA.AA.A.A.A..AA.AA..AAA.AAA","..AAA.AAA.A.AA.....AAA.A.AA.AAAAA..AA..AA.........",".AA..A......A.A.AAA.AAAA...A.AAAA...AAA.AAAA.....A","AAAAAAA.AA..A....AAAA.A..AA.A....AA.A...A.A....A..",".A.A.AA..A.AA.....A.A...A.A..A...AAA..A..AA..A.AAA","AAAA....A...A.AA..AAA..A.AAA..AA.........AA.AAA.A.","......AAAA..A.AAA.A..AAA...AAAAA...A.AA..A.A.AA.A.","AA......A.AAAAAAAA..A.AAA...A.A....A.AAA.AA.A.AAA.",".A.A....A.AAA..A..AA........A.AAAA.AAA.AA....A..AA",".AA.A...AA.AAA.A....A.A...A........A.AAA......A...","..AAA....A.A...A.AA..AAA.AAAAA....AAAAA..AA.AAAA..","..A.AAA.AA..A.AA.A...A.AA....AAA.A.....AAA...A...A",".AA.AA...A....A.AA.A..A..AAA.A.A.AA.......A.A...A.","...A...A.AA.A..AAAAA...AA..A.A..AAA.AA...AA...A.A.","..AAA..A.A..A..A..AA..AA...A..AA.AAAAA.A....A..A.A"};
        System.out.println(new Solution_Recursion().ways(pizza, 8));
    }
}
