package p1011;

public class Solution_Fastest {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0, max = 500 * weights.length / days;
        
        while (min < max) {
            int middle = (min + max) / 2;
            if (isEnough(weights, middle, days))
                max = middle;
            else min = middle + 1;
        }
        
        return min;
    }
    
    /**
     * Check if the given capacity is enough to ship all the weights within given days.
     * @param weights array of weights
     * @param capacity capacity of the ship to be considered.
     * @param days maximum allocated days to ship all the weights.
     * @return true, if it is possible to ship all the weights with given constraints. Otherwise, return false.
     */
    private boolean isEnough(int[] weights, int capacity, int days) {
        int cnt = 0, sum = 0;
        for (int w : weights) {
            if (w > capacity)
                return false;
            if ((sum += w) > capacity) {
                cnt++;
                if (cnt >= days)
                    return false;
                sum = w;
            }
        }
        
        return true;
    }
}
