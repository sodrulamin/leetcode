package p2709;

import java.util.*;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 25/02/2024
 */
public class Solution {

    public boolean canTraverseAllPairs(int[] nums) {
        if(nums.length == 1)
            return true;

        int n = nums.length;
        Map<Integer, List<Integer>> numberToIndex = new HashMap<>(n);
        UnionFind unionFind = new UnionFind(n);
        int max = Integer.MIN_VALUE;

        for(int index = 0; index < n; index++) {
            int number = nums[index];
            List<Integer> indices = numberToIndex.computeIfAbsent(number, key -> new ArrayList<>());
            indices.add(index);
            if(number > max)
                max = number;
        }

        boolean [] sieve = new boolean[max + 1];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        for(int num = 2; num <= max; num++) {
            if(!sieve[num])
                continue;
            List<Integer> allIndices = new ArrayList<>();
            for(int j = num; j <= max; j += num) {
                sieve[j] = false;
                if(!numberToIndex.containsKey(j))
                    continue;

                List<Integer> indices = numberToIndex.get(j);
                allIndices.addAll(indices);
            }

            if(allIndices.size() <= 1)
                continue;

            int firstIndex = allIndices.get(0);

            for(int i = 1; i < allIndices.size(); i++) {
                unionFind.union(firstIndex, allIndices.get(i));
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(unionFind.find(i) != 0)
                return false;
        }

        return true;
    }

    private static class UnionFind {
        int [] parent;

        public UnionFind (int n) {
            this.parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find (int num) {
            if(parent[num] == num)
                return num;

            return parent[num] = find(parent[num]);
        }

        public void union (int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY)
                return;

            if(rootX < rootY)
                parent[rootY] = rootX;
            else
                parent[rootX] = rootY;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().canTraverseAllPairs(new int[]{2,3,6}));
        System.out.println(new Solution().canTraverseAllPairs(new int[]{7,36,14,42}));
    }
}
