package p3075;

import java.util.Arrays;

public class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        long sum = 0;
        int index = 0;
        for(int i = happiness.length - 1; i >= happiness.length - k; i--) {

            int n = happiness[i] - index++;
            if(n <= 0)
                break;

            sum += n;
        }

        return sum;
    }

    public static void main(String[] args) {
        int [] happiness = new int[]{1,2,3};

        System.out.println(new Solution().maximumHappinessSum(happiness, 2));
    }
}
