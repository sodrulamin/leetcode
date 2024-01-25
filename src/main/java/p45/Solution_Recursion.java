package p45;

public class Solution_Recursion {
    public int jump(int[] nums) {
        return solve(nums, 0, 1, nums[0]);
    }

    private int solve(int [] nums, int jumpCount, int start, int end){
        if(end >= nums.length - 1)
            return jumpCount;

        int nextEnd = end;
        for(int index = start; index <= end; index++){
            nextEnd = Math.max(nextEnd, index + nums[index]);
        }

        return solve(nums, jumpCount + 1, end + 1, nextEnd);
    }
}
