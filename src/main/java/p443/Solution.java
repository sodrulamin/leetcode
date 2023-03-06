package p443;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int compress(char[] chars) {
        int index = 0, count, len = 0, digits, i;
        char ch;
        
        while (index < chars.length) {
            ch = chars[index];
            count = index;
            while (index < chars.length && chars[index] == ch) {
                index++;
            }
            
            count = index - count;
            
            chars[len++] = ch;
            if(count == 1)
                continue;
            
            if(count >= 1000)
                digits = 4;
            else if (count >= 100)
                digits = 3;
            else if (count >= 10)
                digits = 2;
            else
                digits = 1;
            i = 1;
            while (count > 0) {
                chars[len + digits - i++] = (char) ('0' + (count % 10));
                count = count / 10;
            }
            len += digits;
        }
        
        return len;
    }
    
    
    
    public static void main(String[] args) {
        char [] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(new Solution().compress(chars));
        System.out.println(Arrays.toString(chars));
    }
}
