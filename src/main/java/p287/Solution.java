package p287;

public class Solution {
    /**
     * Finds the duplicate entry of the given array using Floyd's cycle detection algorithm. The details of the
     * algorithm can be found <a href="https://www.youtube.com/watch?v=LUm2ABqAs1w">here</a>
     * @param nums contains numbers.
     * @return the number which occurs more thane once.
     */
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
