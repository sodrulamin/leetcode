package p2864;

public class Solution {
    public String maximumOddBinaryNumber(String s) {
        int oneCount = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '1')
                oneCount++;
        }

        StringBuilder sb = new StringBuilder(s.length());
        int n = s.length() - 1;
        while (n-- > 0) {
            if(oneCount-- > 1)
                sb.append('1');
            else
                sb.append('0');
        }

        sb.append('1');

        return sb.toString();
    }
}
