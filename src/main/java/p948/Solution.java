package p948;

import java.util.Arrays;

public class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int left = 0, right = tokens.length - 1;
        int score = 0;

        while (left <= right) {
            if(power >= tokens[left]) {
                score++;
                power -= tokens[left++];
            }
            else if(score > 0 && left < right) {
                score--;
                power += tokens[right--];
            }
            else
                break;
        }

        return score;
    }
}
