package p34;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res = {-1, -1};
        
        if(nums.length == 0)
            return res;
        
        res[0] = getFirstIndex(nums, target, 0, nums.length - 1);
        
        if(res[0] != -1)
            res[1] = getLastIndex(nums, target, res[0], nums.length - 1);
        
        return res;
    }
    
    private int getFirstIndex(int [] nums, int target, int i, int j) {
        if(i == j) {
            if(nums[i] == target)
                return i;
            return -1;
        }
        
        int m = (i + j) / 2;
        if(nums[m] >= target)
            return getFirstIndex(nums, target, i, m);
        
        return getFirstIndex(nums, target, m + 1, j);
    }
    
    private int getLastIndex(int [] nums, int target, int i, int j) {
        if(i == j) {
            if(nums[i] == target)
                return i;
            return i - 1;
        }
    
        int m = (i + j) / 2;
        if(nums[m] <= target)
            return getLastIndex(nums, target, m + 1, j);
        return getLastIndex(nums, target, i, m);
    }
    
    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target = 6;
    
        System.out.println(Arrays.toString(new Solution().searchRange(nums, target)));
    }
}
