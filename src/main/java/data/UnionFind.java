package data;

public class UnionFind {
    private final int [] parent;
    
    public UnionFind(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    public int find (int a) {
        if(parent[a] == a)
            return a;
        
        parent[a] = find(parent[a]);
        return parent[a];
    }
    
    public boolean union (int x, int y) {
        int xset = find(x);
        int yset = find(y);
        if(xset == yset)
            return false;
        
        if(yset < xset)
            parent[xset] = yset;
        else
            parent[yset] = xset;
        return true;
    }
}