package p2477;

import java.util.ArrayList;
import java.util.List;

public class Solution_DFS {
    private long result = 0;
    private int seats;

    public long minimumFuelCost(int[][] roads, int seats) {
        this.seats = seats;

        int n = roads.length + 1;
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adjList.get(road[0]).add(road[1]);
            adjList.get(road[1]).add(road[0]);
        }

        dfs(0, 0, adjList);

        return result;
    }

    private int dfs(int city, int prev, List<List<Integer>> adjList) {
        int peopleCount = 1;
        for (Integer neighbour : adjList.get(city)) {
            if (neighbour == prev) continue;
            peopleCount += dfs(neighbour, city, adjList);
        }

        if (city != 0) result += (peopleCount + seats - 1) / seats;
        return peopleCount;
    }
}
