package p2360;

import java.util.Arrays;

public class Solution {
    private int maxCycle;
    public int longestCycle(int[] edges) {
        int [] visited = new int[edges.length];
        int [] visitNumber = new int[edges.length];
        Arrays.fill(visited, -1);
        Arrays.fill(visitNumber, -1);
        
        maxCycle = -1;
        int number = 0;
        for(int i = 0; i < edges.length; i++) {
            if(visited[i] == -1) {
                visitDFS(edges, visited, visitNumber, i, 0, number);
                number++;
            }
        }
        
        return maxCycle;
    }
    
    private void visitDFS (int [] edges, int [] visited, int [] visitNumber, int currentNode, int count, int number) {
        if(currentNode == edges.length)
            return;
        
        if(visited[currentNode] != -1) {
            if(visitNumber[currentNode] == number)
                maxCycle = Math.max(maxCycle, Math.abs(visited[currentNode] - count));
            return;
        }
        
        visited[currentNode] = count;
        visitNumber[currentNode] = number;
        if(edges[currentNode] == -1)
            return;
        
        visitDFS(edges, visited, visitNumber, edges[currentNode], count + 1, number);
    }
    
    public static void main(String[] args) {
        int [] edges = {3,3,4,2,3};
    
        System.out.println(new Solution().longestCycle(edges));
    }
}
