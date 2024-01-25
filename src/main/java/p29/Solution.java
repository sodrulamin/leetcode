package p29;

public class Solution {
    public int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
        while (a - b >= 0) {
            x = 0;
            while (a - (b << (x + 1)) >= 0){
                x++;
            }
            
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Solution().divide(-2147483648, -1));
        System.out.println(new Solution().divide(-1000, 18));
    }
}
