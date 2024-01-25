package p2359;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int [] distFromNode1 = new int[edges.length];
        int [] distFromNode2 = new int[edges.length];

        Arrays.fill(distFromNode1, -1);
        Arrays.fill(distFromNode2, -1);

        bfs(edges, node1, distFromNode1);
        bfs(edges, node2, distFromNode2);

        int resultNode = -1;
        int minDist = Integer.MAX_VALUE;

        for(int i = 0; i < edges.length; i++){
            if(distFromNode1[i]  == -1 || distFromNode2[i] == -1)
                continue;

            int maxDist = Math.max(distFromNode1[i], distFromNode2[i]);
            if(maxDist >= minDist)
                continue;

            minDist = maxDist;
            resultNode = i;
        }

        return resultNode;
    }

    private void bfs(int [] edge, int src, int [] distance){
        LinkedList<Integer> queue = new LinkedList<>();

        boolean [] visited = new boolean[edge.length];
        Arrays.fill(visited, false);

        distance[src] = 0;
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()){
            int current = queue.poll();
            int nextNode = edge[current];
            if(nextNode == -1 || visited[nextNode])
                continue;

            queue.add(nextNode);
            visited[nextNode] = true;
            distance[nextNode] = distance[current] + 1;
        }
    }
}
