package p452;

import java.util.Arrays;
import java.util.Comparator;

public class SolutionFast {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int prevEnd = points[0][1];
        int index = 1;
        int arrow = 1;

        while (index < points.length) {
            if(points[index][0] > prevEnd) {
                prevEnd = points[index][1];
                arrow++;
            }
            index++;
        }

        return arrow;
    }
}
