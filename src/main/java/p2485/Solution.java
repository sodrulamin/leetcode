package p2485;

public class Solution {
    public int pivotInteger(int n) {
        n = (n * (n + 1)) / 2;

        double ans =  Math.sqrt(n);

        if(ans == (int) ans)
            return (int) ans;

        return -1;
    }
}
