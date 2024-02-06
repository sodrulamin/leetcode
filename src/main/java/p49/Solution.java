package p49;

import java.util.*;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 06/02/2024
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getKey (str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        if(map.isEmpty())
            return new ArrayList<>();

        return new ArrayList<>(map.values());
    }

    private String getKey(String str) {
        int [] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int j : count) {
            sb.append(j).append(',');
        }
        return sb.toString();
    }
}
