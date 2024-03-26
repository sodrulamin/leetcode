package p41;

public class SolutionWithSpaceN {
    public int firstMissingPositive(int[] nums) {
        int [] count = new int[nums.length + 1];
        for(int n: nums) {
            if(n >= 0 && n < count.length)
                count[n] = 1;
        }
        
        for(int i = 1; i < count.length; i++)
            if(count[i] == 0)
                return i;
        
        return count.length;
    }
}
