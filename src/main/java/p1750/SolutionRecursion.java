package p1750;

public class SolutionRecursion {
    public int minimumLength(String s) {
//        System.out.println("Checking string: " + s);
        if(s.length() < 2 || s.charAt(0) != s.charAt(s.length() - 1))
            return s.length();

        int left = 0, right = s.length() - 1;
        char ch = s.charAt(left++);
        while (left < s.length() && s.charAt(left) == ch)
            left++;
        ch = s.charAt(right--);
        while (right >= left && s.charAt(right) == ch)
            right--;

        if(right < left)
            return 0;

        return minimumLength(s.substring(left, right + 1));
    }

    public static void main(String[] args) {
        System.out.println(new SolutionRecursion().minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }
}
