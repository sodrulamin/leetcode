package p438;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int [] count = new int[26];

        Queue<Integer> currentList = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < p.length(); i++){
            count[p.charAt(i) - 'a']++;
        }

        int index, number;

        for(int i = 0; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            if(count[index] > 0){
                count[index]--;
                currentList.add(index);
                if(currentList.size() == p.length())
                    result.add(i - p.length() + 1);
                continue;
            }

            while (count[index] == 0 && currentList.size() > 0) {
                number = currentList.poll();
                count[number]++;
            }

            if(count[index] > 0) {
                count[index]--;
                currentList.add(index);
                if(currentList.size() == p.length())
                    result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
