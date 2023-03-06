package p997;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] judge = new int[n + 1];
        Arrays.fill(judge, 0);

        for (int[] ints : trust) {
            judge[ints[0]]--;
            judge[ints[1]]++;
        }

        for(int i = 1; i <= n; i++){
            if(judge[i] == n - 1)
                return i;
        }

        return -1;
    }
}
