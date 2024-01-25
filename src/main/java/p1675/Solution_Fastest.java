package p1675;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution_Fastest {
    static final int[] q = new int[1600000];
    
    public int minimumDeviation(int[] nums) {
        ///make all the numbers even.
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                nums[i] *= 2;
            }
        }
        
        //sort the array in increasing order
        Arrays.sort(nums);
        
        
        int qstart = 0;
        int qend = 0;
        int best = nums[n - 1] - nums[0];
        int numptr = n - 2;
        
        //put the max number into queue
        q[qend++] = nums[n - 1];
        
        int min = nums[0];
        while (true) {
            //until numptr is reaches the first element
            //and the number indexed in numptr is greater than first element of the queue
            final int pick = numptr >= 0 && nums[numptr] > q[qstart] ? nums[numptr--] : q[qstart++];
            best = Math.min(best, pick - min);
            if (pick % 2 == 1)
                return best;
            min = Math.min(min, q[qend++] = pick / 2);
        }
    }
    
    public static void main(String[] args) {
        int [] nums = {4,5,7,5,1,7,9,4,2};
    
        System.out.println(new Solution_Fastest().minimumDeviation(nums));
    }
}
