package p20;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char ch;
        for(int i = 0; i < s.length(); i++){
            ch = s.charAt(i);
            switch (ch){
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                default:
                    stack.push(ch);
                    break;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("([)]"));
    }
}
