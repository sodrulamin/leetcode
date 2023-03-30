package p1402;

import java.util.Arrays;

public class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int presum = 0, res = 0;
        for (int i = n - 1; i >= 0; i--) {
            presum += satisfaction[i];
            if (presum < 0) {
                break;
            }
            res += presum;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int [] data = {-1,-8,0,5,-9};
        System.out.println(new Solution().maxSatisfaction(data));
    }
}
