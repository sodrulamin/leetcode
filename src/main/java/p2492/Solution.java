package p2492;

import data.UnionFind;

import java.util.Arrays;

public class Solution {
    public int minScore(int n, int[][] roads) {
        UnionFind unionFind = new UnionFind(n + 1);
        
        int [] minEdge = new int[n + 1];
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        for (int[] road : roads) {
            unionFind.union(road[0], road[1]);
            minEdge[road[0]] = Math.min(minEdge[road[0]], road[2]);
            minEdge[road[1]] = Math.min(minEdge[road[1]], road[2]);
        }
        int result = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            if(unionFind.find(i) == 1)
                result = Math.min(result, minEdge[i]);
        }
        
        return result;
    }
    
}
