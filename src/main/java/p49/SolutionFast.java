package p49;

import java.util.*;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 06/02/2024
 */
public class SolutionFast {
    private List<List<String>> res;

    public List<List<String>> groupAnagrams(String[] strs) {
        return new AbstractList<List<String>>() {
            public List<String> get(int index) {
                if (res == null) init();
                return res.get(index);
            }

            public int size() {
                if (res == null) init();
                return res.size();
            }

            private void init() {
                Map<String, List<String>> map = new HashMap<>();
                for (String s : strs) {
                    int[] count = new int[26];
                    for (char c : s.toCharArray()) {
                        count[c - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 26; i++) {
                        if (count[i] != 0) {
                            sb.append('a' + i);
                            sb.append(count[i]);
                        }
                    }
                    String key = sb.toString();
                    map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
                    res = new ArrayList<>(map.values());
                }
            }
        };
    }
}
