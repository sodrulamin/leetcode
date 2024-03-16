package p930;

public class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    /**
     * Calculate the total number of sub-arrays possible, which sums at most to the given value of <code>goal</code>
     * @param nums contains the numbers
     * @param goal this is the max value the sum of a sub-array can be.
     * @return the total number of sub-arrays possible
     */
    private int atMost(int[] nums, int goal) {
        int right, left = 0, sum = 0, result = 0;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];

            //if sum exceeds goal, we must slide the left side of
            while (sum > goal && left <= right) {
                sum -= nums[left];
                left++;
            }

            //if the window length is n, there is total n sub-array possible
            //each sub-array starting from the left + i and ending at right, here i = 0 ... n - 1
            result += right - left + 1;

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSubarraysWithSum(new int[] {1,0,1,0,1}, 2));
//        System.out.println(new Solution().numSubarraysWithSum(new int[] {0,0,0,0,0}, 0));
    }
}
