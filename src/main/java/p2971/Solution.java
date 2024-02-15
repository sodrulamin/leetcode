package p2971;

import java.util.Arrays;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 15/02/2024
 */
public class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        long sum = 0;
        for(int num: nums) {
            sum += num;
        }

        for(int i = nums.length - 1; i > 1; i--) {
            sum -= nums[i];
            if(nums[i] >= sum)
                continue;
            return sum + nums[i];
        }

        return -1;
    }
}
