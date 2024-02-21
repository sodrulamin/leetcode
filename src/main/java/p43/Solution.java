package p43;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 21/02/2024
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] ans = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int val = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = ans[i + j + 1] + val;
                ans[i + j + 1] = (sum % 10);
                ans[i + j] = ans[i + j] + sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < n + m; i++) {
            if (ans[i] == 0 && first) continue;
            sb.append(ans[i]);
            first = false;
        }
        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
//        new Solution().multiply("12", "345");
        System.out.println(new Solution().multiply("9", "99"));
    }
}
