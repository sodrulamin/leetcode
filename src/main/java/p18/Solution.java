package p18;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> tempSet = new HashSet<>();
        Arrays.sort(nums);
        int left, right;
        long sum, targetL = target;

        for(int i = 0; i < nums.length - 3; i ++){
            for(int j = i + 1; j < nums.length - 2; j++){
                left = j + 1;
                right = nums.length - 1;
                while (left < right){
                    sum = nums[i];
                    sum = sum + nums[j] + nums[left] + nums[right];
                    if(sum == targetL){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        tempSet.add(list);
                    }

                    if(sum > targetL)
                        right--;
                    else
                        left++;
                }
            }
        }

        return new ArrayList<>(tempSet);
    }

    public static void main(String[] args) {
        int [] nums = {1000000000,1000000000,1000000000,1000000000};
//        System.out.println(Arrays.toString(nums));
        int target = -294967296;
        System.out.println(new Solution().fourSum(nums, target));
    }
}
