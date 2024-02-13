package p2108;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 13/02/2024
 */
public class Solution {
    public String firstPalindrome(String[] words) {
        for(String str: words){
            if(isPalindrome(str)){
                return str;
            }
        }

        return "";
    }

    private boolean isPalindrome(String str) {

        for(int i = 0; i < str.length() / 2; i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
