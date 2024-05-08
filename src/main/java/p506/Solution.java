package p506;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Map<Integer, Integer> map = new HashMap<>(n);

        for(int i = 0; i < n; i++) {
            map.put(score[i], i);
        }

        String [] result = new String[n];

        Arrays.sort(score);
        for(int i = 0; i < n - 3; i++) {
            result[map.get(score[i])] = String.valueOf(n - i);
        }

        if(n > 2)
            result[map.get(score[n - 3])] = "Bronze Medal";
        if(n > 1)
            result[map.get(score[n - 2])] = "Silver Medal";
        result[map.get(score[n - 1])] = "Gold Medal";

        return result;
    }
}
