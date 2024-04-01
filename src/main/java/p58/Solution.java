package p58;

public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        char [] array = s.toCharArray();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(array[i] == ' ') {
                if(count > 0)
                    return count;
            }
            else
                count++;
        }

        return count;
    }
}
