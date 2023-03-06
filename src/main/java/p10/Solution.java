package p10;

public class Solution {
    public boolean isMatch(String text, String pattern){
        return isMatch(text, pattern, 0, 0);
    }

    private boolean isMatch(String text, String pattern, int textIndex, int patternIndex){
        if(patternIndex == pattern.length() - 1){
            return textIndex == text.length() - 1;
        }

        boolean match = textIndex < text.length()
                && (text.charAt(textIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.');

        if(patternIndex + 2 < pattern.length() && pattern.charAt(patternIndex + 1) == '*')
            return isMatch(text, pattern, textIndex, patternIndex + 2)
                    || (match && isMatch(text, pattern, textIndex + 1, patternIndex));

        return match && isMatch(text, pattern, textIndex + 1, patternIndex + 1);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().isMatch("aab", "c*a*b"));
//        System.out.println(new Solution().isMatch("aa", "a"));
//        System.out.println(new Solution().isMatch("aa", "a*"));
        System.out.println(new Solution().isMatch("ab", ".*c"));
    }
}
