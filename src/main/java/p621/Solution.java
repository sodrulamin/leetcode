package p621;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] frequency = new int[26];
        int maxFrequency = 0, maxFrequencyCount = 0;

        for(char ch: tasks) {
            int count = ++frequency[ch - 'A'];
            if(count > maxFrequency) {
                maxFrequency = count;
                maxFrequencyCount = 1;
            }
            else if(count == maxFrequency) {
                maxFrequencyCount++;
            }
        }

        return Math.max((n + 1) * (maxFrequency - 1) + maxFrequencyCount, tasks.length);
    }
}
