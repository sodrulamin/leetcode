package p506;

import java.util.PriorityQueue;

public class SolutionPriorityQueue {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> score[o2] - score[o1]);

        for(int i = 0; i < score.length; i++) {
            pq.add(i);
        }

        String [] result = new String[score.length];
        int i = 1, n;
        while (!pq.isEmpty()) {
            n = pq.poll();
            if(i > 3)
                result[n] = String.valueOf(i);
            else if(i == 3)
                result[n] = "Bronze Medal";
            else if(i == 2)
                result[n] = "Silver Medal";
            else
                result[n] = "Gold Medal";

            i++;
        }

        return result;
    }
}
