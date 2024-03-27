package p713;

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        long product = 1;
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k && left <= right) {
                product /= nums[left++];
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{10,5,2,6};

        System.out.println(new Solution().numSubarrayProductLessThanK(nums, 100));
    }
}
