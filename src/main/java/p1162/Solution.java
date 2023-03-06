package p1162;

import java.util.*;

public class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int [][] distance = new int[n][n];
        for (int [] array: distance){
            Arrays.fill(array, Integer.MAX_VALUE);
        }
        int resultDistance = -1;
        Queue<WaterLand> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == 0)
                    continue;

                assignDistance(grid, distance, queue, i, j, 0, n);
            }
        }

        while (!queue.isEmpty()){
            WaterLand waterLand = queue.poll();
            assignDistance(grid, distance, queue, waterLand.x, waterLand.y, distance[waterLand.x][waterLand.y], n);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(distance[i][j] == Integer.MAX_VALUE)
                    continue;
                resultDistance = Math.max(resultDistance, distance[i][j]);
            }
        }

        return resultDistance;
    }

    private void assignDistance(int [][] grid, int [][] distance, Queue<WaterLand> queue, int currentX, int currentY,
                                int currentDistance, int n){
        int x, y, dist;
        //top left
        if(currentX > 0 && currentY > 0){
            x = currentX - 1;
            y = currentY - 1;
            dist = currentDistance + 2;
            pickIfPossible(grid, distance, queue, x, y, dist);
        }

        //top middle
        if(currentY > 0){
            x = currentX;
            y = currentY - 1;
            dist = currentDistance + 1;
            pickIfPossible(grid, distance, queue, x, y, dist);
        }

        //top right
        if(currentX < n - 1 && currentY > 0){
            x = currentX + 1;
            y = currentY - 1;
            dist = currentDistance + 2;
            pickIfPossible(grid, distance, queue, x, y, dist);
        }

        //left
        if(currentX > 0){
            x = currentX - 1;
            y = currentY;
            dist = currentDistance + 1;
            pickIfPossible(grid, distance, queue, x, y, dist);
        }

        //right
        if(currentX < n - 1){
            x = currentX + 1;
            y = currentY;
            dist = currentDistance + 1;
            pickIfPossible(grid, distance, queue, x, y, dist);
        }

        //bottom left
        if(currentX > 0 && currentY < n - 1){
            x = currentX - 1;
            y = currentY + 1;
            dist = currentDistance + 2;
            pickIfPossible(grid, distance, queue, x, y, dist);
        }

        //bottom middle
        if(currentY < n - 1){
            x = currentX;
            y = currentY + 1;
            dist = currentDistance + 1;
            pickIfPossible(grid, distance, queue, x, y, dist);
        }

        //bottom right
        if(currentX < n - 1 && currentY < n - 1){
            x = currentX + 1;
            y = currentY + 1;
            dist = currentDistance + 2;
            pickIfPossible(grid, distance, queue, x, y, dist);
        }
    }

    private void pickIfPossible(int [][] grid, int [][] distance, Queue<WaterLand> queue, int x, int y, int dist){
        if(grid[x][y] != 0 || distance[x][y] <= dist)
            return;

        distance[x][y] = dist;
        queue.add(new WaterLand(x, y));
    }

    private static class WaterLand {
        int x;
        int y;

        public WaterLand(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int [][] grid = {{1,0,0,0,0,1,0,0,0,1},{1,1,0,1,1,1,0,1,1,0},{0,1,1,0,1,0,0,1,0,0},{1,0,1,0,1,0,0,0,0,0},{0,1,0,0,0,1,1,0,1,1},{0,0,1,0,0,1,0,1,0,1},{0,0,0,1,1,1,1,0,0,1},{0,1,0,0,1,0,0,1,0,0},{0,0,0,0,0,1,1,1,0,0},{1,1,0,1,1,1,1,1,0,0}};

        System.out.println(new Solution().maxDistance(grid));
    }
}
