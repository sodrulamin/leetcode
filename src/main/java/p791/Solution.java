package p791;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()) {
            Integer count = map.getOrDefault(ch, 0);
            map.put(ch, count + 1);
        }

        StringBuilder builder = new StringBuilder();
        for(char ch: order.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            while (count > 0) {
                builder.append(ch);
                count--;
            }
            map.remove(ch);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            int count = entry.getValue();
            char ch = entry.getKey();

            while (count > 0) {
                count--;
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
