package p567;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] count = new int[26];

        Queue<Integer> currentList = new LinkedList<>();

        for(int i = 0; i < s1.length(); i++){
            count[s1.charAt(i) - 'a']++;
        }

        int index, number;

        for(int i = 0; i < s2.length(); i++) {
            index = s2.charAt(i) - 'a';
            if(count[index] > 0){
                count[index]--;
                currentList.add(index);
                if(currentList.size() == s1.length())
                    return true;
                continue;
            }

            while (count[index] == 0 && currentList.size() > 0) {
                number = currentList.poll();
                count[number]++;
            }

            if(count[index] > 0) {
                count[index]--;
                currentList.add(index);
                if(currentList.size() == s1.length())
                    return true;
            }
        }

        return false;
    }
}
