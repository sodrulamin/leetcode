package p3005;

public class Solution {
    public int maxFrequencyElements(int[] nums) {
        int [] frequency = new int[101];
        int maxFrequency = 0, count = 0;
        for(int n: nums) {
            frequency[n]++;
            if(frequency[n] > maxFrequency) {
                maxFrequency = frequency[n];
                count = 1;
            }
            else if(frequency[n] == maxFrequency) {
                count++;
            }
        }

        return count * maxFrequency;
    }
}
