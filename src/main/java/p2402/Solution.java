package p2402;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 18/02/2024
 */
public class Solution {

    public int mostBooked(int n, int[][] meetings) {
        long [] roomAvailableTime = new long[n];
        int [] totalMeetings = new int[n];

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for(int [] arr: meetings) {
            int start = arr[0];
            int duration = arr[1] - arr[0];
            long soonestAvailableTime = Long.MAX_VALUE;
            int soonestAvailableRoom = -1;

            for(int room = 0; room < n; room++) {
                if(roomAvailableTime[room] <= start) {
                    roomAvailableTime[room] = start + duration;
                    totalMeetings[room]++;
                    soonestAvailableRoom = -1;
                    break;
                }
                else if(roomAvailableTime[room] < soonestAvailableTime) {
                    soonestAvailableRoom = room;
                    soonestAvailableTime = roomAvailableTime[room];
                }
            }

            if(soonestAvailableRoom == -1)
                continue;

            roomAvailableTime[soonestAvailableRoom] = soonestAvailableTime + duration;
            totalMeetings[soonestAvailableRoom]++;
        }

        int maxBookedRoom = 0;

        for(int room = 1; room < n; room++) {
            if(totalMeetings[room] > totalMeetings[maxBookedRoom]) {
                maxBookedRoom = room;
            }
        }

        return maxBookedRoom;
    }



    public static void main(String[] args) {
        int ans = -1;
//        new Solution().mostBooked(4, new int[][] {{18,19},{3,12},{17,19},{2,13},{7,10}});
//        ans = new Solution().mostBooked(2, new int[][] {{0,10},{1,5},{2,7},{3,4}});
        ans = new Solution().mostBooked(3, new int[][] {{1,20},{2,10},{3,5},{4,9},{6,8}});

        System.out.println(ans);
    }
}
