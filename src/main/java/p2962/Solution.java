package p2962;

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int n : nums) {
            if (n > max)
                max = n;
        }

        int middle = 0, c = 0;
        long result = 0;
        for (int num : nums) {
            if (num == max)
                c++;

            if (c > k) {
                c--;
                middle++;
                while (nums[middle] != max) {
                    middle++;
                }
                result += middle + 1;
            } else if (c == k) {
                while (nums[middle] != max) {
                    middle++;
                }

                result += middle + 1;
            }
        }

        return result;
    }
}