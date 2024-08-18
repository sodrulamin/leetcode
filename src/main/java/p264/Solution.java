package p264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int nthUglyNumber(int n) {
        Set<Integer> found = new HashSet<>();
        Queue<Integer> queue = new PriorityQueue<>();

        int result=1, num;
        queue.add(1);


        while (n > 0) {
            n--;

            result = queue.poll();
            num = result * 2;
            if(!found.contains(num)) {
                found.add(num);
                queue.add(num);
            }

            num = result * 3;
            if(!found.contains(num)) {
                found.add(num);
                queue.add(num);
            }

            num = result * 5;
            if(!found.contains(num)) {
                found.add(num);
                queue.add(num);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}
