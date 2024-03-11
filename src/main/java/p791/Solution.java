package p791;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final int BASE = 'a';
    public String customSortString(String order, String s) {
        int [] count = new int[26];
        int index = 0;

        for(char ch: s.toCharArray()) {
            index = ch - BASE;
            count[index]++;
        }

        StringBuilder builder = new StringBuilder();
        for(char ch: order.toCharArray()) {
            index = ch - BASE;
            while (count[index] > 0) {
                builder.append(ch);
                count[index]--;
            }
        }

        for(int i = 0; i < 26; i++) {

            while (count[i] > 0) {
                count[i]--;
                builder.append((char)(i + BASE));
            }
        }

        return builder.toString();
    }
}
