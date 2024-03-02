package p977;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length - 1;

        int [] result = new int[nums.length];

        while (left < right) {
            if(nums[left] > nums[right])
                result[pos--] = nums[left++];
            else
                result[pos--] = nums[right--];
        }

        result[pos] = nums[left];

        return result;
    }
}
