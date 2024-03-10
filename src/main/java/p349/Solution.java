package p349;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean [] occurance = new boolean[1000];

        for(int a: nums1) {
            occurance[a] = true;
        }

        Set<Integer> set = new HashSet<>();

        for(int b: nums2) {
            if(occurance[b])
                set.add(b);
        }

        int [] result = new int[set.size()];
        int index = 0;

        for(int a: set) {
            result[index++] = a;
        }

        return result;
    }
}
