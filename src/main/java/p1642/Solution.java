package p1642;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 17/02/2024
 */
public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int currentPosition = 0;
        while (currentPosition < heights.length - 1){
            int jumpHeight = heights[currentPosition + 1] - heights[currentPosition];


            if(jumpHeight <= 0) {
                currentPosition++;
                continue;
            }

            bricks -= jumpHeight;
            queue.offer(jumpHeight);

            if(bricks < 0) {
                bricks += queue.poll();
                ladders--;
            }

            if(ladders < 0)
                break;

            currentPosition++;
        }

        return currentPosition;
    }

    private int furthestBuilding(int[] heights, int index, int bricks, int ladders) {
        if(index == heights.length - 1)
            return index;

        int currentHeight = heights[index];
        int nextHeight = heights[index + 1];
        int jumpHeight = nextHeight - currentHeight;

        if(jumpHeight <= 0)
            return furthestBuilding(heights, index + 1, bricks, ladders);

        int result = index;

        if(bricks >= jumpHeight)
            result = furthestBuilding(heights, index + 1, bricks - jumpHeight, ladders);

        if(result == heights.length - 1)
            return result;

        if(ladders > 0)
            result = Math.max(result, furthestBuilding(heights, index + 1, bricks, ladders - 1));

        return result;
    }

    public static void main(String[] args) {
        new Solution().furthestBuilding(new int[] {4,2,7,6,9,14,12}, 5, 1);
    }
}
