package p1481;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 16/02/2024
 */
public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                map.get(j).count++;
            }
            else {
                map.put(j, new Pair(j, 1));
            }
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>();

        queue.addAll(map.values());

        while (k > 0 && !queue.isEmpty()) {
            Pair pair = queue.poll();
            k -= pair.count;
        }

        return k < 0 ? queue.size() + 1 : queue.size();
    }

    private static class Pair implements Comparable<Pair> {
        int value;
        int count;

        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
        @Override
        public int compareTo(Pair o) {
            return this.count - o.count;
        }
    }

    public static void main(String[] args) {
        new Solution().findLeastNumOfUniqueInts(new int[] {4,3,1,1,3,3,2}, 3);
    }
}
