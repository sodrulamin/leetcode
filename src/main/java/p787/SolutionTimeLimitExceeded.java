package p787;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SolutionTimeLimitExceeded {
    private int minCost = Integer.MAX_VALUE;
    private int sourceNode;
    private int destNode;
    private int maxHop;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<Flight>> adjacent = new HashMap<>();
        this.sourceNode = src;
        this.destNode = dst;
        this.maxHop = k;

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];

            List<Flight> list = adjacent.computeIfAbsent(from, k1 -> new ArrayList<>());
            list.add(new Flight(to, cost));
        }

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        visited[src] = true;
        bfs(adjacent, src, 0, 0, visited);

        if (minCost == Integer.MAX_VALUE) return -1;

        return minCost;
    }

    private void bfs(HashMap<Integer, List<Flight>> route, int currentNode, int currentHop, int currentCost,
                     boolean[] visited) {
        if (currentNode == this.destNode) {
            minCost = Math.min(minCost, currentCost);
            return;
        }

        if (currentCost > minCost || currentHop > maxHop) return;

        List<Flight> list = route.get(currentNode);
        if (list == null) return;

        for (Flight flight : list) {
            if (flight.toCity == this.sourceNode || visited[flight.toCity]) continue;
            visited[flight.toCity] = true;
            bfs(route, flight.toCity, currentHop + 1, currentCost + flight.cost, visited);
            visited[flight.toCity] = false;
        }
    }

    private static class Flight {
        int toCity;
        int cost;

        public Flight(int toCity, int cost) {
            this.toCity = toCity;
            this.cost = cost;
        }
    }
}
