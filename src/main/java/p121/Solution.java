package p121;

public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minValue = Integer.MAX_VALUE;
    
        for(int i: prices){
            minValue = Math.min(minValue, i);
            maxProfit = Math.max(maxProfit, i - minValue);
        }
        
        return maxProfit;
    }
    
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
