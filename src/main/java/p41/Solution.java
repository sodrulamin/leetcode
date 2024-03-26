package p41;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        //convert all the numbers which are negative or greater than n to n + 1
        for(int i = 0; i < n; i++) {
            if(nums[i] > n || nums[i] <= 0)
                nums[i] = n + 1;
        }

        //negate all the index that are present
        for(int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);
            if(index > n)
                continue;

            nums[index - 1] = Math.abs(nums[index - 1]) * -1;
        }

        //find the first positive number. Index of all positive numbers are absent in the array.
        for(int i = 0; i < n; i++)
            if(nums[i] > 0)
                return i + 1;

        //at most n + 1 could be missing
        return n + 1;
    }
}
