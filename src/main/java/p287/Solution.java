package p287;

public class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        do {
            fast = nums[nums[fast]];    //two steps
            slow = nums[slow];          //one steps
        }
        while (fast != slow);


        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }
}
