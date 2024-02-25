package p2709;

import java.util.*;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 25/02/2024
 */
public class SolutionTimeLimit {
    public boolean canTraverseAllPairs(int[] nums) {

        if(nums.length == 1)
            return true;

        List<List<Integer>> indexToPrime = new ArrayList<>(nums.length);
        Map<Integer, List<Integer>> primeToIndex = new HashMap<>();
        Map<Integer, List<Integer>> numberToPrime = new HashMap<>();

        UnionFind unionFind = new UnionFind(nums.length);

        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            List<Integer> primes = numberToPrime.computeIfAbsent(n, key -> new ArrayList<>());
            if(!primes.isEmpty()) {
                indexToPrime.add(primes);
                for(int prime: primes) {
                    addPrimeToIndex(primeToIndex, prime, i);
                }
                continue;
            }

            indexToPrime.add(new ArrayList<>());
            for(int j = 2; j * j <= nums[i]; j++) {
                if(n % j == 0) {
                    // j is a prime factor of index i
                    primes.add(j);
                    indexToPrime.get(i).add(j);
                    addPrimeToIndex(primeToIndex, j, i);
                    while (n % j == 0)
                        n /= j;
                }
            }

            if(n > 1) {
                primes.add(n);
                indexToPrime.get(i).add(n);
                addPrimeToIndex(primeToIndex, n, i);
            }
        }

        for(int i = 0; i < indexToPrime.size(); i++) {
            List<Integer> primes = indexToPrime.get(i);

            for(int prime: primes) {
                List<Integer> indices = primeToIndex.get(prime);
                for(int index: indices) {
                    unionFind.union(i, index);
                }
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(unionFind.find(i) != 0)
                return false;
        }

        return true;
    }

    private void addPrimeToIndex (Map<Integer, List<Integer>> primeToIndex, int prime, int index) {
        List<Integer> indices = primeToIndex.computeIfAbsent(prime, k -> new ArrayList<>());
        indices.add(index);
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
                parent[y] = rootX;
            else
                parent[x] = rootY;
        }
    }

    private void printIndexToPrime (List<List<Integer>> indexToPrime) {
        for(int i = 0 ; i < indexToPrime.size(); i++) {
            System.out.println("index - " + i + ": " + indexToPrime.get(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(new SolutionTimeLimit().canTraverseAllPairs(new int[] {4,3,12,8}));
    }
}
