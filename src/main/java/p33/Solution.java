package p33;

public class Solution {
    public int search(int[] nums, int target) {
        return getTargetIndex(nums, target, 0, nums.length - 1);
    }
    
    private int getTargetIndex(int [] nums, int target, int i, int j) {
        if(i == j) {
            if(nums[i] == target)
                return i;
            return -1;
        }
        
        int m = (i + j) / 2;
        if(target == nums[m])
            return m;
        
        //Pivot is not in right side. So we must focus on right side
        if(nums[m] < nums[j]) {
            //if target is in right side. Search in right side.
            if(target > nums[m] && target <= nums[j])
                return getTargetIndex(nums, target, m + 1, j);
            
            //else search in left side.
            return getTargetIndex(nums, target, i, m);
        }
        //Pivot is not in left side. So we must focus on left side.
        else {
            //if target is in left side. Search in left side.
            if(target >= nums[i] && target < nums[m])
                return getTargetIndex(nums, target, i, m);
            
            //else search in right side.
            return getTargetIndex(nums, target, m + 1, j);
        }
    }
    
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,9};
    
        System.out.println(new Solution().search(nums, 4));
    }
}
