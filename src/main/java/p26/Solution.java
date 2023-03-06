package p26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1, insertIndex = 1, lastNumber = nums[0];
        while (index < nums.length){
            if(nums[index] != lastNumber){
                lastNumber = nums[index];
                nums[insertIndex++] = lastNumber;
            }
            index++;
        }

        return insertIndex;
    }
}
