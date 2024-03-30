package p992;

public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return subArrayCount(nums, k) - subArrayCount(nums, k - 1);
    }

    private int subArrayCount (int [] nums, int k) {
        int [] count = new int[nums.length + 1];
        int distinct = 0, left = 0, result = 0;
        for(int right = 0; right < nums.length; right++) {
            int n = nums[right];
            if(count[n] == 0)
                distinct++;
            count[n]++;

            while (distinct > k) {
                n = nums[left++];
                count[n]--;
                if(count[n] == 0)
                    distinct--;
            }

            result += (right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2));
    }
}
