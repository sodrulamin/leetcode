package p739;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 31/01/2024
 */
class SolutionTimeLimit {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] ans = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            for(int j = i + 1; j < temperatures.length; j++) {
                if(temperatures[j] > temp) {
                    ans[i] = j - i;
                    break;
                }
            }
        }

        return ans;
    }


}