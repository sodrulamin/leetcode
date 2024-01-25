package p983;

import java.util.Arrays;

public class Solution {
    
    public int mincostTickets(int[] days, int[] costs) {
        int [] dp = new int[days.length];
        return travel(days, dp, costs, 0);
    }
    
    private int travel(int [] days, int [] dp, int [] costs, int index) {
        if(index >= days.length)
            return 0;
        
        if(dp[index] != 0)
            return dp[index];
        
        dp[index] = costs[0] + travel(days, dp, costs, index + 1);
        
        int today = days[index];
        int nextIndex = index + 1;
        
        while (nextIndex < days.length && days[nextIndex] < today + 7)
            nextIndex++;
        dp[index] = Math.min(dp[index], costs[1] + travel(days, dp, costs, nextIndex));
    
        while (nextIndex < days.length && days[nextIndex] < today + 30)
            nextIndex++;
        dp[index] = Math.min(dp[index], costs[2] + travel(days, dp, costs, nextIndex));
        
        return dp[index];
    }
    
    public static void main(String[] args) {
        int [] days = {1,4,6,7,8,20};
        int [] cost = {2,7,15};
    
        System.out.println(new Solution().mincostTickets(days, cost));
    }
    
}
