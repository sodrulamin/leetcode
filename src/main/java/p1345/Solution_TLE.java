package p1345;

import java.util.*;

public class Solution_TLE {
    public int minJumps(int[] arr) {
        if(arr.length == 1)
            return 0;
        
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            List<Integer> indices = indexMap.computeIfAbsent(num, k -> new LinkedList<>());
            indices.add(i);
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[arr.length];
        queue.add(0);
        visited[0] = true;
        
        int count = 0, size, index, nextNum;
        while (!queue.isEmpty()) {
            count++;
            size = queue.size();
            while (size > 0) {
                size--;
                index = queue.poll();
                nextNum = index - 1;
                if(nextNum >= 0 && !visited[nextNum]) {
                    queue.offer(nextNum);
                    visited[nextNum] = true;
                }
                
                nextNum = index + 1;
                if(nextNum < arr.length && !visited[nextNum]) {
                    if(nextNum == arr.length - 1)
                        return count;
                    queue.offer(nextNum);
                    visited[nextNum] = true;
                }
                
                List<Integer> adjList = indexMap.get(arr[index]);
                for(int i : adjList) {
                    if(i == arr.length - 1)
                        return count;
                    if(!visited[i]) {
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
                adjList.clear();
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
    public static void main(String[] args) {
        int [] nums = {100,-23,-23,404,100,23,23,23,3,404};
        
        System.out.println(new Solution_TLE().minJumps(nums));
    }
    
    private static void printGraph(Map<Integer, Set<Integer>> adjMap, int [] arr) {
        for(int i : adjMap.keySet()) {
            System.out.print(arr[i] + ": ");
            for(int j : adjMap.get(i)) {
                System.out.print(arr[j] + ", ");
            }
    
            System.out.println();
        }
    }
    
   
}
