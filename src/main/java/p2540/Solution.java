package p2540;


public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int indexA = 0, indexB = 0;

        while (indexA < nums1.length && indexB < nums2.length) {
            if(nums1[indexA] < nums2[indexB])
                indexA++;
            else if(nums1[indexA] > nums2[indexB])
                indexB++;
            else
                return nums1[indexA];
        }

        return -1;
    }
}
