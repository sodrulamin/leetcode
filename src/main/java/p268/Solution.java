package p268;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 20/02/2024
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int [] index = new int[nums.length + 1];
        for (int num : nums) {
            index[num] = 1;
        }
        for(int i = 0; i < index.length; i++) {
            if(index[i] == 0)
                return i;
        }
        return 0;
    }
}
