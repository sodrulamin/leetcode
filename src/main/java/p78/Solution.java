package p78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        subsets(nums, 0, new ArrayList<>(), result);

        return result;
    }

    public void subsets(int [] nums, int index, List<Integer> list, List<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        subsets(nums, index + 1, list, result);

        list.removeLast();
        subsets(nums, index + 1, list, result);
    }
}
