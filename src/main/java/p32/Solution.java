package p32;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() < 2)
            return 0;
        
        int [] array = new int[s.length()];
        Arrays.fill(array, -1);
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add(i);
            }
            else {
                if(!stack.isEmpty()) {
                    int prev = stack.pop();
                    array[i] = prev;
                }
            }
        }
    
        int prev = s.length() - 1;
        while (prev > 0) {
            while (prev > 0 && array[prev] == -1)
                prev--;
            if(prev == 0)
                break;
            int end = prev;
            prev = array[prev];
            while (prev > 0 && array[prev - 1] != -1)
                prev = array[prev - 1];
    
            maxLen = Math.max(maxLen, end - prev + 1);
        }
        
        
        return maxLen;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Solution().longestValidParentheses("(()"));
        System.out.println(new Solution().longestValidParentheses("()(()()"));
    }
    
}
