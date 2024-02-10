package p647;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 10/02/2024
 */
public class SolutionFastest {
    int length = 0, count = 0;

    public int countSubstrings(String s) {
        length = s.length();

        for (int i = 0; i < length; i++) {
            i = countAndReturnNextIndex(s, i);
        }
        return count;
    }

    public int countAndReturnNextIndex(String s, int k) {

        int left = k - 1, right = k;
        while (right < length - 1 && s.charAt(right) == s.charAt(right + 1))
            right++;
        int countOfSameChar = right - left;
        if (countOfSameChar >= 1) {
            //5 = 5 + 4 + 3 + 2 +1
            //4 = 4 + 3 + 2 + 1
            count += (countOfSameChar * (countOfSameChar + 1)) / 2;
        }
        int nextIndex = right++;
        while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return nextIndex;

    }
}
