package p1291;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 02/02/2024
 */
public class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        int firstDigit = String.valueOf(low).charAt(0) - '0';



        int digitCountLow = countDigit(low);
        int digitCountHigh = countDigit(high);

        while (digitCountLow <= digitCountHigh) {

            while (firstDigit < 11 - digitCountLow) {
                int number = generateNumber(firstDigit, digitCountLow);
                firstDigit++;
                if(number < low)
                    continue;

                if(number > high)
                    break;
                result.add(number);
            }
            firstDigit = 1;
            digitCountLow++;
        }

        return result;
    }

    private static int countDigit (int number) {
        int count = 0;

        while (number > 0) {
            count++;
            number /= 10;
        }

        return count;
    }

    private static int generateNumber (int firstDigit, int digitCount) {
        int result = 0;
        while (digitCount > 0) {
            result = result * 10 + firstDigit;
            firstDigit++;
            digitCount--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sequentialDigits(8511, 23553));
    }

}
