package p2477;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_PostOrder {
    public long minimumFuelCost(int[][] roads, int seats) {
        if(roads.length == 0)
            return 0;

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for(int [] edge: roads){
            List<Integer> list = adjMap.computeIfAbsent(edge[0], k -> new ArrayList<>());
            list.add(edge[1]);

            list = adjMap.computeIfAbsent(edge[1], k -> new ArrayList<>());
            list.add(edge[0]);
        }

        boolean [] visited = new boolean[roads.length + 1];

        PassengerCount passengerCount = postOrderTraversal(adjMap, 0, visited, seats);

        return (long) (passengerCount.totalCost - Math.ceil(passengerCount.totalPassenger / (double) seats));
    }

    private PassengerCount postOrderTraversal(Map<Integer, List<Integer>> adjMap, int currentNode, boolean [] visited,
                                         double seats){

        PassengerCount passengerCount = new PassengerCount();
        visited[currentNode] = true;

        List<Integer> adj = adjMap.get(currentNode);
        if(adj == null){
            passengerCount.totalPassenger = 1;
        }
        else {
            for(int nextNode: adj){
                if(visited[nextNode])
                    continue;
                PassengerCount pCount = postOrderTraversal(adjMap, nextNode, visited, seats);
                passengerCount.totalCost += pCount.totalCost;
                passengerCount.totalPassenger += pCount.totalPassenger;
            }
            passengerCount.totalPassenger++;
        }

        passengerCount.totalCost += Math.ceil(passengerCount.totalPassenger / seats);

        return passengerCount;
    }



    private static class PassengerCount{
        int totalPassenger;
        long totalCost;
    }


    public static void main(String[] args) {
        int [][] edges = {{0,1},{0,2},{0,3}};

        System.out.println(new Solution_PostOrder().minimumFuelCost(edges, 5));
    }

}
