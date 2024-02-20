package p2402;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 21/02/2024
 */
public class SolutionFast {
    public int mostBooked(int n, int[][] meetings) {
        int [] totalMeetings = new int[n];
        PriorityQueue<Room> freeRoom = new PriorityQueue<>(Comparator.comparingInt(o -> o.roomNumber));
        PriorityQueue<Room> usedRoom = new PriorityQueue<>((o1, o2) -> {
            if(o1.nextAvailable == o2.nextAvailable)
                return o1.roomNumber - o2.roomNumber;
            return (int) (o1.nextAvailable - o2.nextAvailable);
        });

        for(int room = 0; room < n; room++) {
            freeRoom.add(new Room(room, 0));
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for(int [] arr: meetings) {
            int start = arr[0];
            int duration = arr[1] - arr[0];

            while (!usedRoom.isEmpty() && usedRoom.peek().nextAvailable <= start)
                freeRoom.add(usedRoom.poll());

            Room room;
            if(!freeRoom.isEmpty()) {
                room = freeRoom.poll();
                room.nextAvailable = start + duration;
            }
            else {
                room = usedRoom.poll();
                room.nextAvailable = room.nextAvailable + duration;
            }
            totalMeetings[room.roomNumber]++;
            usedRoom.offer(room);

        }

        int maxBookedRoom = 0;

        for(int room = 1; room < n; room++) {
            if(totalMeetings[room] > totalMeetings[maxBookedRoom]) {
                maxBookedRoom = room;
            }
        }

        return maxBookedRoom;
    }

    private static class Room {
        long nextAvailable;
        int roomNumber;

        public Room (int roomNumber, long nextAvailable) {
            this.roomNumber = roomNumber;
            this.nextAvailable = nextAvailable;
        }
    }
}
