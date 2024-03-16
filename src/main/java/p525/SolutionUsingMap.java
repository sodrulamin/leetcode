package p525;

import java.util.HashMap;
import java.util.Map;

public class SolutionUsingMap {
    public int findMaxLength(int[] nums) {
        int diff = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1)
                diff++;
            else
                diff--;

            Integer previous = map.get(diff);
            if(previous == null) {
                map.put(diff, i);
            }
            else {
                maxLen = Math.max((i - previous), maxLen);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {0,1,1};

        System.out.println(new SolutionUsingMap().findMaxLength(nums));
    }
}
