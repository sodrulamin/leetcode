package p1481;

import java.util.Arrays;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 16/02/2024
 */
public class SolutionFastest {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int[] node = new int[arr.length+1];
        int cnt = 0;
        int length=1;
        for (int i = 0; i < arr.length; i++) {
            if (i+1 < arr.length && arr[i] == arr[i+1]) {
                length++;
            } else {
                cnt++;
                node[length]++;
                length=1;
            }
        }
        for(int i=1;i<node.length;i++) {
            int canRemove = Math.min(k/i, node[i]);
            cnt-=canRemove;
            k-=canRemove*i;
        }
        return cnt;
    }

    public static void main(String[] args) {
        SolutionFastest solution = new SolutionFastest();
        System.out.println(solution.findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3));
    }
}
