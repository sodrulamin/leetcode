package p30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_Fastest {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        int totalWordsLength = wordLength * words.length;
        Map<String, Integer> hash = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        char[] s2 = s.toCharArray();
        
        for (String value : words) {
            hash.putIfAbsent(value, hash.size());
        }
        
        int[] count = new int[hash.size()];
        for (String word : words) {
            count[hash.get(word)]++;
        }
        
        for (int i = 0; i < wordLength; i++) {
            for (int j = i; j <= s.length() - totalWordsLength; j += wordLength) {
                int[] localCount = new int[hash.size()];
                for (int k = j + totalWordsLength - wordLength; k >= j; k -= wordLength) {
                    String str = new String(s2, k, wordLength);     // [ k, k+wordLength )
                    Integer key = hash.get(str);
                    
                    //all possible mismatch cases are checked below.
                    if (key == null || count[key] < ++localCount[key]) {
                        j = k;
                        break;
                    }
                    
                    if (j == k) {
                        ans.add(j);
                    }
                }
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String [] words = {"foo","bar"};
        
        System.out.println(new Solution_Fastest().findSubstring(s, words));
    }
}
