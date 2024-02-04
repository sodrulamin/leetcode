package p76;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 04/02/2024
 */
public class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length())
            return "";

        int minWindow = Integer.MAX_VALUE;
        int startIndex = 0;
        Queue<Char> occurance = new LinkedList<>();
        Set<Character> set = new HashSet<>();

        int [] tArray = new int[52];  //A = 0, a = 26
        for(char a: t.toCharArray()) {
            tArray[getTArrayIndex(a)]++;
            set.add(a);
        }

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!set.contains(ch))
                continue;
            occurance.add(new Char(ch, i));
            int index = getTArrayIndex(ch);
            tArray[index]--;
            Char first = occurance.peek();
            index = getTArrayIndex(first.aChar);
            while (tArray[index] < 0) {
                tArray[index]++;
                occurance.poll();
                first = occurance.peek();
                index = getTArrayIndex(first.aChar);
            }

            if(isFound(tArray)) {
                int window = i - first.index + 1;
                if(window < minWindow) {
                    startIndex = first.index;
                    minWindow = window;
                }
            }
        }

        if(minWindow == Integer.MAX_VALUE)
            return "";

        return s.substring(startIndex, startIndex + minWindow);
    }

    private int getTArrayIndex (char ch) {
        if(ch > 'Z')
            return ch - 'a' + 26;

        return ch - 'A';
    }

    private boolean isFound (int [] tArray) {
        for(int a: tArray)
            if(a > 0)
                return false;

        return true;
    }

    private static class Char {
        public char aChar;
        public int index;

        public Char (char aChar, int index) {
            this.aChar = aChar;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        new Solution().minWindow("ADOBECODEBANC", "ABC");
    }
}
