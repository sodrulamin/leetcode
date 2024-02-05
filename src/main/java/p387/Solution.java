package p387;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 05/02/2024
 */
public class Solution {
    public int firstUniqChar(String s) {
        int [] foundChars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            foundChars[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(foundChars[ch - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
