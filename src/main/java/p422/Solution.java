package p422;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for(int n: nums) {
            int i = Math.abs(n);
            if(nums[i - 1] < 0)
                result.add(i);
            else
                nums[i - 1] *= -1;
        }

        return result;
    }
}
