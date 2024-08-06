package p3016;

public class Solution {
    public int minimumPushes(String word) {
        int [] occur = new int[26];

        for(char ch: word.toCharArray()) {
            occur[ch - 'a']++;
        }

        int max;
        int result = 0;
        int count = 8;
        do {
            max = 0;
            int index = 0;
            for(int i = 0; i < 26; i++) {
                if(max < occur[i]) {
                    max = occur[i];
                    index = i;
                }
            }
            occur[index] = 0;

            result += (count/8) * max;
            count++;
        } while (max > 0);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}
