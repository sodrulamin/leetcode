package p169;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 12/02/2024
 */
public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            int found = map.getOrDefault(num, 0) + 1;
            if(found > n/2){
                return num;
            }

            map.put(num, found);
        }

        return nums[0];
    }
}
