package p169;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 12/02/2024
 */
public class SolutionFast {
    public int majorityElement(int[] nums) {
        int count = 0;
        int element = 0;

        for (int num : nums) {
            if (count == 0) {
                element = num;
                count = 1;
            } else if (element == num) {
                count++;
            } else {
                count--;
            }
        }

        return element;
    }
}
