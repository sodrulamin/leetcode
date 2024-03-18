package p452;

import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        //sort all the balloons primarily based on their start-x, secondarily based on their end-x value.
        Arrays.sort(points, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                if(o1[1] > o2[1])
                    return 1;

                return -1;
            }

            if(o1[0] > o2[0])
                return 1;
            return -1;
        });

        int n = points.length;
        int index = 0, arrow = 0;
        int [] balloon = null;

        //iterate over the sorted balloons.
        while (index < n) {
            //take the next available balloons
            balloon = points[index++];

            //find the common area with next balloons until there is no other common area.
            while (index < n) {
                //consider the common area as the current balloon position
                balloon = getCommonArea(balloon, points[index]);

                //if no common area found with next balloon then throw the arrow and break the loop
                if (balloon == null) {
                    arrow++;
                    break;
                }

                //some common area found, so try next balloon in the new common area.
                index++;
            }
        }

        //if there is any balloon remaining, use another arrow.
        if(balloon != null)
            arrow++;

        return arrow;
    }

    private int [] getCommonArea (int [] a, int [] b) {

        //if there is no common area
        if(a[1] < b[0])
            return null;

        //create a new area with min value of both area
        int [] area = new int[2];
        area[0] = Math.min(a[0], b[0]);
        area[1] = Math.min(a[1], b[1]);

        return area;
    }

    public static void main(String[] args) {
        int [][] balloons = {{-2147483646,-2147483645},{2147483646,2147483647}};

        System.out.println(new Solution().findMinArrowShots(balloons));
    }
}
