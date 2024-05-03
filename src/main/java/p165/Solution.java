package p165;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String [] array1 = version1.split("\\.");
        String [] array2 = version2.split("\\.");

        int maxLen = Math.max(array1.length, array2.length);

        for(int i = 0; i < maxLen; i++){
            String str1 = i < array1.length ? array1[i] : "0";
            String str2 = i < array2.length ? array2[i] : "0";

            int a = Integer.parseInt(str1);
            int b = Integer.parseInt(str2);

            if(a > b)
                return 1;
            if(a < b)
                return -1;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1.0", "1.0.0"));
    }
}
