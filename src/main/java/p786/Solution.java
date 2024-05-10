package p786;

import java.util.Arrays;

public class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int [] result = new int[2];
        if(k == 1) {
            result[0] = arr[0];
            result[1] = arr[arr.length - 1];
            return result;
        }

        int [] visited = new int[arr.length];
        Arrays.fill(visited, -1);
        visited[arr.length - 1] = 0;

        int index = arr.length - 1, right = arr.length - 1;
        double min, cur;

        while (k-- > 1) {

            while (visited[right] == right - 1)
                right--;

            min = arr[visited[index] + 1] / (double) arr[index];

            for(int j = right; j > 0; j--) {
                cur = arr[visited[j] + 1] / (double) arr[j];
                if(min > cur) {
                    min = cur;
                    index = j;
                }
            }

            visited[index]++;
        }

        result[0] = arr[visited[index]];
        result[1] = arr[index];

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().kthSmallestPrimeFraction(new int[]{1,13,17,59}, 6)));
    }
}
