package p739;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 31/01/2024
 */
public class Solution {
    private static final int MAX_TEMP = 100;
    public int[] dailyTemperatures(int[] temperatures) {
        int [] index = new int [MAX_TEMP + 1];
        int [] ans = new int[temperatures.length];

        for(int i = temperatures.length - 1; i >= 0; i--) {
            int temp = temperatures[i];
            index[temp] = i;
            while (++temp <= MAX_TEMP) {
                int position = index[temp];
                int diff = position - i;
                if(diff <= 0)
                    continue;

                if(ans[i] == 0 || ans[i] > diff)
                    ans[i] = diff;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int [] temperature = {73,74,75,71,69,72,76,73};

        new SolutionFastest().dailyTemperatures(temperature);
    }
}
