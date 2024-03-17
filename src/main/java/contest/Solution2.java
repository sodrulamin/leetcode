package contest;

public class Solution2 {
    public long countSubstrings(String s, char c) {
        long count = 0;
        char [] array = s.toCharArray();
        for(char ch: array) {
            if(ch == c) {
                count++;
            }
        }

        if(count == 0)
            return 0;
        if(count == 1)
            return 1;

        return count * (count - 1) / 2 + count;
    }
}
