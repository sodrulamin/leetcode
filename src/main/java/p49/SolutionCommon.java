package p49;

import java.util.*;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 06/02/2024
 */
public class SolutionCommon {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] tmp = str.toCharArray();

            Arrays.sort(tmp);

            String key = new String(tmp);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
