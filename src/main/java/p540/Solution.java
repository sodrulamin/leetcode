package p540;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        return findSingleElement(nums, 0, nums.length - 1);
    }
    
    /**
     * Find the non-duplicate element in the search area defined by startIndex and endIndex.
     * @param nums Sorted array of integer where the non-duplicate element to be searched.
     * @param startIndex Starting index of the search area.
     * @param endIndex End index of the search area.
     * @return the non-duplicate element found in the search area.
     */
    private int findSingleElement(int [] nums, int startIndex, int endIndex){
        //we have end up with search area of length 1. So, this is our ans.
        if(startIndex == endIndex)
            return nums[startIndex];
        
        int middle = (startIndex + endIndex) / 2;
        
        //middle element is a duplicate with its left element. We will exclude this element from next search area.
        if(nums[middle] == nums[middle - 1]){
            //if the length of right side of the middle element is odd we must search this area.
            if((endIndex - middle - 1) % 2 == 0)
                return findSingleElement(nums, middle + 1, endIndex);
    
            //if the length of left side of the middle element is odd we must search this area.
            return findSingleElement(nums, startIndex, middle - 2);
        }
        //middle element is a duplicate with its right element. We will exclude this element from next search area.
        else if (nums[middle] == nums[middle + 1]){
            //if the length of right side of the middle element is odd we must search this area.
            if((middle - 1 - startIndex) % 2 == 0)
                return findSingleElement(nums, startIndex, middle - 1);
    
            //if the length of left side of the middle element is odd we must search this area.
            return findSingleElement(nums, middle + 2, endIndex);
        }
        
        //no duplicate found for middle element.
        return nums[middle];
    }
    
    public static void main(String[] args) {
        int [] nums = {1,1,2,3,3,4,4,8,8};
    
        System.out.println(new Solution().singleNonDuplicate(nums));
    }
}
