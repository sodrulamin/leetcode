package p2958;

import java.util.HashMap;
import java.util.Map;

public class SolutionWithMap {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int left = 0, result = 0;
        for(int right = 0; right < nums.length; right++) {
            int f = frequency.getOrDefault(nums[right], 0) + 1;

            if(f > k){
                result = Math.max(result, right - left);

                do {
                    frequency.put(nums[left], frequency.get(nums[left]) - 1);
                } while (nums[left++] != nums[right]);
                f--;
            }

            frequency.put(nums[right], f);
        }

        result = Math.max(result, nums.length - left);

        return result;
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,1,2,3,1,2};

        System.out.println(new SolutionWithMap().maxSubarrayLength(array, 2));
    }
}
