package p2441;

public class Solution {
    public int findMaxK(int[] nums) {
        int [] found = new int[1001];
        int result = -1;

        for(int n: nums) {
            if(n < 0) {
                n = -n;

                //found positive earlier
                if(found[n] == 1)
                    result = Math.max(result, n);

                //never found earlier
                else if(found[n] == 0)
                    found[n] = -1;
            }
            else {
                //found negative earlier
                if(found[n] == -1)
                    result = Math.max(result, n);

                //never found earlier
                else if(found[n] == 0)
                    found[n] = 1;
            }
        }

        return result;
    }
}
