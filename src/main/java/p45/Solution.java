package p45;

import java.util.Arrays;

public class Solution {
    public int jump(int[] nums) {
        int [] jumCount = new int[nums.length];
        Arrays.fill(jumCount, Integer.MAX_VALUE);

        jumCount[0] = 0;
        int nextIndex;

        for(int i = 0; i < nums.length; i++){
            nextIndex = i + nums[i];
            if(nextIndex >= nums.length)
                nextIndex = nums.length - 1;

            for(int j = nextIndex; j > i && jumCount[j] > jumCount[i] + 1; j--)
                jumCount[j] = jumCount[i] + 1;
        }

        return jumCount[nums.length - 1];
    }

    public static void main(String[] args) {
//        int [] nums = {2,3,1,1,4};
        int [] nums = {2,1};
        System.out.println(new Solution().jump(nums));
    }
}
