package p57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> newList = new ArrayList<>();
        int index = 0;

        //find the position where the newInterval should be inserted
        while (index < intervals.length) {
            if(intervals[index][1] >= newInterval[0])
                break;

            newList.add(intervals[index]);
            index++;
        }

        //if insert at the last then just create the result
        if(index >= intervals.length) {
            newList.add(newInterval);
            return createResult(newList);
        }

        //keep merging all intervals that overlaps with newInterval
        int [][] merged = mergeIntervals(newInterval, intervals[index++]);
        while (merged.length == 1 && index < intervals.length) {
            merged = mergeIntervals(merged[0], intervals[index++]);
        }

        //add the merged intervals into the list
        newList.addAll(Arrays.asList(merged));

        //add all the remaining intervals, if there is any, into the list.
        while (index < intervals.length) {
            newList.add(intervals[index++]);
        }

        return createResult(newList);
    }

    /**
     * convert the list int [] into a two-dimensional array.
     * @param list contains all the int [].
     * @return the two-dimensional array.
     */
    private int [][] createResult (List<int []> list) {
        int [][] result = new int[list.size()][];

        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    /**
     * Merge two interval and create one or two new intervals.
     * @param interval1 first interval
     * @param interval2 second interval
     * @return the merged intervals
     */
    public int [][] mergeIntervals(int [] interval1, int [] interval2) {

        //if second interval is ahead, return recursive result
        if(interval1[0] > interval2[0])
            return mergeIntervals(interval2, interval1);

        //first interval is ahead
        if(interval1[1] < interval2[0]) {
            //first interval is totally ahead of second one.
            return new int[][] {interval1, interval2};
        }
        else if (interval1[1] < interval2[1]) {
            //merge them and create one new interval
            return new int[][] {new int[]{interval1[0], interval2[1]}};
        }

        //second interval totally consumed by first one.
        return new int[][]{interval1};
    }

    public static void main(String[] args) {
        int [][] intervals = {};//{{1,3},{6,9}};
        int [] newInterval = {2, 5};

        System.out.println(Arrays.deepToString(new Solution().insert(intervals, newInterval)));
    }
}
