package p1071;

public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length() < str2.length())
            return gcdOfStrings(str2, str1);


        int length = str2.length();
        while (length > 0){
            if(gcdOfStrings(str1, str2, length))
                return str1.substring(0, length);
            length--;
        }

        return "";
    }

    private boolean gcdOfStrings(String str1, String str2, int strLength){
        if(str1.length() % strLength != 0 || str2.length() % strLength != 0)
            return false;

        return isGCD(str1, str2, strLength) && isGCD(str2, str1, strLength);
    }

    private boolean isGCD(String str1, String str2, int length){
        int index = 0;
        while (index < str1.length() - 1){
            if(!isMatch(str1, str2, index, length))
                return false;
            index += length;
        }

        return true;
    }

    private boolean isMatch(String str1, String str2, int index, int length){
        for(int i = 0; i < length; i++){
            if(str2.charAt(i) != str1.charAt(index + i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().gcdOfStrings("REQAGELREQAGELREQAGELREQAGELREQAGEL", "REQAGELREQAGELREQAGELREQAGELREQAGELREQAGELREQAGELREQAGELREQAGEL"));
//        System.out.println(new Solution().gcdOfStrings("ABCABC", "ABC"));
        System.out.println(new Solution().gcdOfStrings("NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM", "NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM"));
    }
}