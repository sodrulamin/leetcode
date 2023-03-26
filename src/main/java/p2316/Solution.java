package p2316;

import data.UnionFind;

public class Solution {
    public long countPairs(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for(int [] edge: edges) {
            unionFind.union(edge[0], edge[1]);
        }
        
        long sum = 0;
        int [] count = new int[n];
        for(int i = 0; i < n; i++) {
            count[unionFind.find(i)]++;
        }
        
        long multiplier = n;
        for(int num : count) {
            if(num == 0)
                continue;
            
            multiplier -= num;
            sum = sum + num * multiplier;
            if(multiplier == 0)
                break;
        }
        
        return sum;
    }
}
