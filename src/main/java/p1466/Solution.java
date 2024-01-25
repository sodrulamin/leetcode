package p1466;

import java.util.*;

public class Solution {
    
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Connection>> adjMap = new HashMap<>();
        
        for(int [] road: connections) {
            int a = road[0];
            int b = road[1];
            
            List<Connection> list = adjMap.computeIfAbsent(a, k -> new LinkedList<>());
            list.add(new Connection(b, true));
            
            list = adjMap.computeIfAbsent(b, k -> new LinkedList<>());
            list.add(new Connection(a, false));
        }
        
        boolean [] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        visited[0] = true;
        int reversed = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int node = queue.poll();
                size--;
                
                List<Connection> list = adjMap.get(node);
                for(Connection connection: list) {
                    if(visited[connection.destination])
                        continue;
                    queue.add(connection.destination);
                    visited[connection.destination] = true;
                    if(connection.reverse)
                        reversed++;
                }
            }
        }
        
        return reversed;
    }
    
    private static class Connection {
        public boolean reverse;
        public int destination;
        
        public Connection (int destination, boolean reverse) {
            this.reverse = reverse;
            this.destination = destination;
        }
    }
}
