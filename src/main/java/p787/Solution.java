package p787;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<Flight>> adjacent = new HashMap<>();

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];

            List<Flight> list = adjacent.computeIfAbsent(from, k1 -> new ArrayList<>());
            list.add(new Flight(to, cost));
        }

        int [] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Flight> flightQueue = new LinkedList<>();
        flightQueue.offer(new Flight(src, 0));
        distance[src] = 0;

        int steps = 0;

        while (!flightQueue.isEmpty() && steps <= k){
            steps++;
            //we will visit all the nodes currently in the queue at this level.
            int remainingNode = flightQueue.size();

            while (remainingNode > 0){
                remainingNode--;

                Flight flight = flightQueue.poll();

                List<Flight> nextFlights = adjacent.get(flight.toCity);
                if(nextFlights == null)
                    continue;

                for(Flight nextFlight: nextFlights){
                    int nextCost = nextFlight.cost + flight.cost;
                    if(nextCost < distance[nextFlight.toCity]){
                        distance[nextFlight.toCity] = nextCost;
                        flightQueue.offer(new Flight(nextFlight.toCity, nextCost));
                    }
                }
            }
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];

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
