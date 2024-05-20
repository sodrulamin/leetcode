package p1863;

public class Solution {
    private int sum;
    public int subsetXORSum(int[] nums) {
        sum = 0;

        getXor(nums, 0, 0);

        return sum;
    }

    private void getXor (int [] nums, int index, int xor) {
        if(index == nums.length)
            return;

        getXor(nums, index + 1, xor);

        xor = xor ^ nums[index];
        sum += xor;

        getXor(nums, index + 1, xor);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsetXORSum(new int[]{5,1,6}));
    }
}
