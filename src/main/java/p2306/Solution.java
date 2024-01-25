package p2306;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> map = new HashMap<>();

        for(String str: ideas){
            char ch = str.charAt(0);

            Set<String> set = map.computeIfAbsent(ch, k -> new HashSet<>());
            set.add(str.substring(1));
        }
        long count = 0;

        for(int i = 0; i < 26; i++){
            char charA = (char) ('a' + i);
            Set<String> setA = map.get(charA);
            if(setA == null)
                continue;

            for(int j = i + 1; j < 26; j++){

                char charB = (char) ('a' + j);
                Set<String> setB = map.get(charB);
                if(setB == null)
                    continue;

                long commonCount = 0;
                for(String strA: setA){
                    if(setB.contains(strA))
                        commonCount++;
                }

                count += (setA.size() - commonCount) * (setB.size() - commonCount) * 2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String [] array = {
                "coffee","donuts","time","toffee"
        };
        System.out.println(new Solution().distinctNames(array));
    }
}
