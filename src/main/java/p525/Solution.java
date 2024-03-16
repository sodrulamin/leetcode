package p525;

import java.util.Arrays;

public class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0, n = nums.length;
        int [] sumMap = new int[n * 2 + 1];
        Arrays.fill(sumMap, Integer.MAX_VALUE);
        int diff = n;
        sumMap[n] = -1;

        for(int i = 0; i < n; i++) {
            if(nums[i] == 1)
                diff++;
            else
                diff--;

            int previous = sumMap[diff];
            if(previous == Integer.MAX_VALUE) {
                sumMap[diff] = i;
            }
            else {
                maxLen = Math.max((i - previous), maxLen);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxLength(new int[] {0,1,1}));
    }
}
