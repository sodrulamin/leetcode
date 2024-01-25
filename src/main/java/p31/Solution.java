package p31;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] a) {
        int i = -1;
        
        for(int k = a.length - 1; k > 0; k--) {
            if(a[k - 1] < a[k]){
                i = k - 1;
                break;
            }
        }
        
        if(i > -1) {
            int j = a.length - 1;
            while (a[j] <= a[i])
                j--;
            
            swap(a, i, j);
        }
        
        i++;
        int j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int [] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    public static void main(String[] args) {
        int [] nums = {3,2,1};
        
        new Solution().nextPermutation(nums);
    
        System.out.println(Arrays.toString(nums));
    }
}
