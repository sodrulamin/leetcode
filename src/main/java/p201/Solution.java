package p201;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 21/02/2024
 */
public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }

        return left << count;
    }
}
