package p2958;

public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        //find the range of the input numbers
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int n: nums) {
            if(n > max)
                max = n;
            if(n < min)
                min = n;
        }

        //create new memory for assigning the frequency of the found range
        int range = max - min + 1;
        int [] freq = new int[range];

        //initiate sliding window algorithm
        int left = 0, n, result = 0;
        for(int right = 0; right < nums.length; right++) {
            n = nums[right] - min;
            freq[n]++;
            if(freq[n] > k) {
                result = Math.max(result, right - left);
                do {
                    freq[nums[left] - min]--;
                }
                while (nums[left++] != nums[right]);
            }
        }

        //there is a possibility that in the last index if(freq[n] > k) condition was not met.
        result = Math.max(result, nums.length - left);

        return result;
    }
}
