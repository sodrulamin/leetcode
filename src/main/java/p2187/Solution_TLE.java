package p2187;

import java.util.PriorityQueue;

public class Solution_TLE {
    public long minimumTime(int[] time, int totalTrips) {
        if(time.length == 1)
            return (long) time[0] * totalTrips;
        
        PriorityQueue<Bus> queue = new PriorityQueue<>();
        for(int t : time)
            queue.add(new Bus(t));
        
        long totalTime = 0;
        while (totalTrips > 0) {
            totalTrips--;
            Bus bus = queue.poll();
            totalTime = bus.totalTime;
            bus.completeTrip();
            queue.offer(bus);
        }
        
        return totalTime;
    }
    
    private static class Bus implements Comparable<Bus> {
        int time;
        long totalTime;
        
        public Bus(int time) {
            this.time = time;
            this.totalTime = time;
        }
        
        public void completeTrip() {
            this.totalTime += this.time;
        }
    
        @Override
        public int compareTo(Bus o) {
            return (int) (this.totalTime - o.totalTime);
        }
    }
}
