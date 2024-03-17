package contest;

public class Solution3 {
    public int minimumDeletions(String word, int k) {
        int[] charCount = new int[26];
        int maxFreq = 0, minFreq = Integer.MAX_VALUE;
        int deletions = Integer.MAX_VALUE;

        for (char c : word.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (int count : charCount) {
            maxFreq = Math.max(maxFreq, count);
            minFreq = Math.min(minFreq, count);
        }

        for(int i = maxFreq; i - k >= minFreq; i--) {
            int deletion = 0;
            for(int count: charCount) {
                if(count < i - k)
                    deletion += count;
                else if(count > i)
                    deletion += (count - i);
            }

            deletions = Math.min(deletions, deletion);
        }

        return deletions == Integer.MAX_VALUE ? 0 : deletions;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().minimumDeletions("lllloollollo", 2));
    }
}
