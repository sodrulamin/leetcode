package p2348;

public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long sum = 0;
        int count = 0;
        for(int n: nums) {
            if(n == 0)
                count++;
            else if(count > 0){
                sum += ((long) count * (count + 1) / 2);
                count = 0;
            }
        }
    
        if(count > 0)
            sum += ((long) count * (count + 1) / 2);
        
        return sum;
    }
}
