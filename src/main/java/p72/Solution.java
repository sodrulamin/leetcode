package p72;

import java.util.Arrays;

public class Solution {
    /**
     * Recursive solution.
     * For each position, check four sub-problems:
     * 1. match
     * 2. insert
     * 3. delete
     * 4. replace
     * <p>
     * We only modify the first string since no matter which one we choose, the result is the same.
     * The key point is to find out the sub-problem we have solved duplicate and cache the recursion.
     * Noticed that each sub-problem is specified by i and j pointer, so we can cache the result of these sub-problems.
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();
        int [][] cache = new int[word1.length() + 1][word2.length() + 1];
        
        for(int [] arr: cache) {
            Arrays.fill(arr, -1);
        }
        
        char [] s1 = word1.toCharArray();
        char [] s2 = word2.toCharArray();
        
        return match(s1, s2, 0, 0, cache);
    }
    
    private int match(char [] s1, char [] s2, int i, int j, int [][] cache) {
    
        //If we already have an ans, return immediately
        if(cache[i][j] != -1)
            return cache[i][j];
        
        //if we reach the end of s1, s2.length - j chars need to inserted at the end of s1 to convert s1 to s2
        if (s1.length == i) {
            return s2.length - j;
        }
        
        //if we reach the end of s2, s1.length - i chars need to deleted from the end of s2 to convert s1 to s2
        if (s2.length == j) {
            return s1.length - i;
        }
        
        int res;
        //If both char are equal no operation is required.
        if (s1[i] == s2[j]) {
            res = match(s1, s2, i + 1, j + 1, cache);
        }
        //we must need to do one of the following operations
        else {
            
            //Case1: insert
            // - Inserting one char in s1, is equal to deleting one char from s2. Because, if we insert same char as s2
            // in s1, we don't need to check the next char from s2, as this one was inserted into s1 already.
            // - It creates a match, so we must increase j + 1
            int insert = match(s1, s2, i, j + 1, cache);
            
            //Case2: delete
            // - Delete current char from s1, meaning we don't need to check current char of s1. But nothing changed in
            // our target string s2.
            // - This doesn't create any match, so, we can't increase j
            int delete = match(s1, s2, i + 1, j, cache);
            
            //Case3: replace
            // - Replacing current char of s1, with current char of s2.
            // - This creates a match, so j + 1 is used.
            // - This changes the cur char of s1 with a match, so i + 1 is used.
            int replace = match(s1, s2, i + 1, j + 1, cache);
            
            //each of the above operations cost 1. So, we must add 1 with the result.
            // we must take the minimum of the above three cases.
            res = Math.min(Math.min(insert, delete), replace) + 1;
        }
        
        cache[i][j] = res;
        
        return res;
    }
}
