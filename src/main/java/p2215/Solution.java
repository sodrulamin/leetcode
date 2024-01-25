package p2215;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(getDifference(nums1, nums2));
        result.add(getDifference(nums2, nums1));
        return result;
    }
    
    private List<Integer> getDifference(int [] nums1, int [] nums2) {
        boolean [] seen = new boolean[2001];
        List<Integer> list = new ArrayList<>();
        
        for(int n : nums2) {
            seen[n + 1000] = true;
        }
        int index;
        for(int n: nums1) {
            index = n + 1000;
            if(seen[index])
                continue;
            seen[index] = true;
            list.add(n);
        }
        
        return list;
    }
}
