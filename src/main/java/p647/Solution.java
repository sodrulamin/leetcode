package p647;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 10/02/2024
 */
public class Solution {
    public int countSubstrings(String s) {
        int result = s.length();

        for(int length = 2; length <= s.length(); length++) {
            for(int start = 0; start <= s.length() - length; start++) {
                if(isPalindrome(s, start, length))
                    result++;
            }
        }

        return result;
    }

    private boolean isPalindrome(String s, int start, int length) {
        int i = start, j = start + length - 1;

        while (i < j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution().countSubstrings("aaa");
    }
}
