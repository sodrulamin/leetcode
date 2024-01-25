package p15;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> takenNumbers = new HashSet<>();

        int target = 0, j, k, sum;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            j = i + 1;
            k = nums.length - 1;
            while (j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    takenNumbers.add(list);
                }

                if(sum < target){
                    j++;
                }
                else {
                    k--;
                }
            }
        }

        return new ArrayList<>(takenNumbers);
    }
}
