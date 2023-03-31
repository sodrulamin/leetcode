package p87;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/scramble-string/solutions/3357439/easy-solutions-in-java-python-and-c-look-at-once-with-exaplanation/">...</a>
 */
public class Solution {
    private final HashMap<String, Boolean> map = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        
        if(n != s2.length())
            return false;
        
        if(s1.equals(s2))
            return true;
        
        if(n == 1)
            return false;
        
        String key = s1 + " " + s2;
        Boolean result = map.get(key);
        if(result != null)
            return result;
        
        for(int i = 1; i < n; i++) {
            result = isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i));
            if(result) {
                map.put(key, true);
                return true;
            }
            
            result = isScramble(s1.substring(0, i), s2.substring(n - i))
                    && isScramble(s1.substring(i), s2.substring(0, n - i));
            if(result) {
                map.put(key, true);
                return true;
            }
        }
        
        map.put(key, false);
        return false;
    }
}
