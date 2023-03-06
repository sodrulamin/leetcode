package p16;

import java.util.*;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int j, k, sum, result = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            j = i + 1;
            k = nums.length - 1;
            while (j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }

                if(sum < target){
                    j++;
                    if(target - sum < Math.abs(target - result))
                        result = sum;
                }
                else {
                    if(sum - target < Math.abs(target - result))
                        result = sum;
                    k--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int [] nums = {-1,2,1,-4};
        int target = 1;

        System.out.println(new Solution().threeSumClosest(nums, target));
    }
}
