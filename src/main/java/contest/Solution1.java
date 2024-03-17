package contest;

import java.util.Arrays;

public class Solution1 {
    public boolean isSubstringPresent(String s) {
        StringBuilder builder = new StringBuilder(s.length());
        for(int i = s.length() -1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }

        String reverse = builder.toString();
        for(int i = 0; i < s.length() - 1; i++) {
            if(reverse.contains(s.substring(i, i + 2)))
                return true;
        }

        return false;
    }

}
