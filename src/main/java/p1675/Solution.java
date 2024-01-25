package p1675;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int minimumDeviation(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return Integer.MAX_VALUE;
        }
        
        PriorityQueue<Integer> evens = new PriorityQueue<>(nums.length, Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        
        for (int num : nums)
        {
            if (num % 2 == 0) {
                evens.offer(num);
                min = Math.min(num, min);
            }
            else {
                evens.offer(num * 2);
                min = Math.min(num * 2, min);
            }
        }
        
        int res = Integer.MAX_VALUE;
        while (evens.peek() % 2 == 0) {
            int max = evens.poll();
            res = Math.min(res, max - min);
            int newNum = max / 2;
            evens.offer(newNum);
            min = Math.min(min, newNum);
        }
        res = Math.min(evens.peek() - min, res);
        return res;
    }
    
    public static void main(String[] args) {
        int [] nums = {4,5,7,5,1,7,9,4,2};
    
        System.out.println(new Solution().minimumDeviation(nums));
    }
}
