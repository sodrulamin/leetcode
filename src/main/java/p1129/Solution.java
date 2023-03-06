package p1129;

import java.util.*;

public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> redAdj = new HashMap<>();
        Map<Integer, List<Integer>> blueAdj = new HashMap<>();
        int [] minDistance = new int[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        for(int [] edge: redEdges){
            List<Integer> adj = redAdj.computeIfAbsent(edge[0], k -> new ArrayList<>());
            adj.add(edge[1]);
        }

        for(int [] edge: blueEdges){
            List<Integer> adj = blueAdj.computeIfAbsent(edge[0], k -> new ArrayList<>());
            adj.add(edge[1]);
        }

        doBfs(n, redAdj, blueAdj, minDistance, true);
        doBfs(n, redAdj, blueAdj, minDistance, false);


        return modifyAndReturn(minDistance);
    }

    private int [] modifyAndReturn(int [] minDistance){
        for(int i = 0; i < minDistance.length; i++){
            if(minDistance[i] == Integer.MAX_VALUE)
                minDistance[i] = -1;
        }

        return minDistance;
    }

    private void doBfs(int n, Map<Integer, List<Integer>> redAdj, Map<Integer, List<Integer>> blueAdj,
                       int [] minDistance, boolean startRed){
        Queue<Integer> redQueue = new LinkedList<>();
        Queue<Integer> blueQueue = new LinkedList<>();

        boolean [] visitedRed = new boolean[n];
        boolean [] visitedBlue = new boolean[n];

        if(startRed){
            visitedBlue[0] = true;
            redQueue.add(0);
        }
        else {
            visitedRed[0] = true;
            blueQueue.add(0);
        }

        int distance = 0, node;
        while (!redQueue.isEmpty() || !blueQueue.isEmpty()){
            if(!redQueue.isEmpty()){
                while (!redQueue.isEmpty()){
                    node = redQueue.poll();
                    minDistance[node] = Math.min(minDistance[node], distance);
                    visitedRed[node] = true;

                    List<Integer> adj = blueAdj.get(node);
                    if(adj == null)
                        continue;

                    for(int next: adj){
                        if(visitedBlue[next])
                            continue;

                        blueQueue.add(next);
                    }
                }
                distance++;
                continue;
            }

            while (!blueQueue.isEmpty()){
                node = blueQueue.poll();
                minDistance[node] = Math.min(minDistance[node], distance);
                visitedBlue[node] = true;

                List<Integer> adj = redAdj.get(node);
                if(adj == null)
                    continue;

                for(int next: adj){
                    if(visitedRed[next])
                        continue;

                    redQueue.add(next);
                }
            }
            distance++;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int [][] redEdges = {{0,1},{1,2}};
        int [][] blueEdges = {};

        System.out.println(Arrays.toString(new Solution().shortestAlternatingPaths(n, redEdges, blueEdges)));
    }
}
