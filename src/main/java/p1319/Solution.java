package p1319;

import data.UnionFind;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int makeConnected(int n, int[][] connections) {
        UnionFind unionFind = new UnionFind(n);
        
        int extraCables = 0;
        Set<Integer> components = new HashSet<>();
        
        for(int [] connection: connections) {
            if(!unionFind.union(connection[0], connection[1]))
                extraCables++;
        }
        
        for(int i = 0; i < n; i++) {
            components.add(unionFind.find(i));
        }
        
        int cableRequired =  components.size() - 1;
        if(cableRequired > extraCables)
            return -1;
        return cableRequired;
    }
}
