package p27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0, insertIndex = 0;
        while (index < nums.length){
            if(nums[index] != val){
                nums[insertIndex++] = nums[index];
            }
            index++;
        }

        return insertIndex;
    }
}
