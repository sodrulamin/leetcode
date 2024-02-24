package p2092;

import java.util.*;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 24/02/2024
 */
class Solution {
    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        int maxMeetTime = 0;

        for (int[] meeting : meetings)
            maxMeetTime = Math.max(maxMeetTime, meeting[2]);



        List<List<int[]>> list = new ArrayList<>();
        for(int i = 0; i <= maxMeetTime; i++ ) {
            list.add(new ArrayList<>());
        }

        for (int[] meeting : meetings) {
            int time = meeting[2];
            int a = meeting[0];
            int b = meeting[1];

            list.get(time).add(new int[]{a, b});
        }



        int[] parent = new int[n];
        for(int i = 0; i < parent.length; i++) parent[i] = i;
        parent[firstPerson] = 0;

        for (List<int[]> ints : list) {
            if (ints.isEmpty()) continue;

            for (int[] anInt : ints) {
                int a = anInt[0];
                int b = anInt[1];

                union(a, b, parent);
            }

            for (int[] anInt : ints) {
                int a = anInt[0];
                int b = anInt[1];
                find(a, parent);
                find(b, parent);

                if (parent[a] != 0) parent[a] = a;
                if (parent[b] != 0) parent[b] = b;
            }


        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < parent.length; i++) {
            find(i, parent);

            if (parent[i] == 0 ) result.add(i);
        }

        return result;
    }


    private static int find(int a, int[] parent) {
        if ( a == parent[a] ) return a;
        return parent[a] = find(parent[a], parent);
    }

    private static void union(int a, int b, int[] parent) {
        a = find(a, parent);
        b = find(b, parent);

        if ( a != b) {
            if ( a <= b) {
                parent[b] = a;
            } else{
                parent[a] = b;
            }
        }
    }
}
