package p2187;

import java.util.Arrays;

public class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        if(time.length == 1)
            return (long) time[0] * totalTrips;
    
        Arrays.sort(time);
        
        long l = 0, r = 100000000000000L, m;
        while (l < r) {
            m = l + (r - l) / 2;
            if(tripsPossible(time, m, totalTrips))
                r = m;
            else
                l = m + 1;
        }
        
        return r;
    }
    
    private boolean tripsPossible(int [] time, long totalTime, int totalTrips) {
        long tripCount = 0;
        for(int t: time) {
            tripCount += (totalTime / t);
            if(tripCount >= totalTrips)
                return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int [] num = {1, 2, 3};
        long time = 1562500000000L;
        System.out.println(new Solution().tripsPossible(num, time, 5));
//        System.out.println(new Solution().minimumTime(num, 5));
    }
}
