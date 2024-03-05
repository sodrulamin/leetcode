package p1750;

public class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        char [] array = s.toCharArray();
        while (left < right) {
            if(array[left] != array[right])
                break;

            char ch = array[left++];
            while (left < right && array[left] == ch)
                left++;

            if(left == right)
                return 0;

            while (left < right && array[right] == ch)
                right --;
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }
}
