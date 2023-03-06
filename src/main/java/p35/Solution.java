package p35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        //If the target is greater than the last value, it must reside at the end of the array.
        if(target > nums[nums.length - 1])
            return nums.length;
        
        //If the target is less than the first value, it must reside at the start of the array.
        if(target < nums[0])
            return 0;
        
        //the target must reside inside the array.
        return searchInRange(nums, target, 0, nums.length - 1);
    }
    
    /**
     * Find the target in the given sorted array in divide and conquer algorithm.
     * @param nums Sorted array of integer, where target should be searched.
     * @param target The target value which should be searched.
     * @param startIndex Starting index for the current search area where the target should be resided.
     * @param endIndex Ending index for the current search area where the target should be resided.
     * @return the index where the target was found or can be put if wanted to insert.
     */
    private int searchInRange(int [] nums, int target, int startIndex, int endIndex){
        
        //if we are down to the array of length less than 2. The ans is binary. Either startIndex or next of startIndex.
        if(endIndex - startIndex < 2) {
            if(nums[startIndex] < target)
                return startIndex + 1;
            return startIndex;
        }
    
        //calculate the middle index for current search area.
        //for example startIndex = 0, endIndex = 3, middle will be 1
        //startIndex = 1 endIndex = 6, middle will be 3
        int middle = (startIndex + endIndex) / 2;
        if(nums[middle] == target)
            return middle;
        
        //if target is greater it must reside on right side.
        if(nums[middle] < target)
            return searchInRange(nums, target, middle + 1, endIndex);
        
        //target is on left side.
        return searchInRange(nums, target, startIndex, middle);
    }
}
