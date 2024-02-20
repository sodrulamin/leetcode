package p231;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 21/02/2024
 */
public class Solution {
    public boolean isPowerOfTwo2(int n) {
        if(n <= 0)
            return false;

        if(n == 1)
            return true;

        if(n % 2 != 0)
            return false;
        return isPowerOfTwo(n / 2);
    }

    public boolean isPowerOfTwo(int n) {
        return n >= 0 && (n & (n - 1)) == 0;
    }
}
