package p2000;

public class Solution {
    public String reversePrefix(String word, char ch) {
        char [] arr = word.toCharArray();

        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == ch) {
                index = i;
                break;
            }
        }

        if(index == 0)
            return word;

        int start = 0;
        while (start < index) {
            ch = arr[start];
            arr[start] = arr[index];
            arr[index] = ch;
            start++;
            index--;
        }

        return new String(arr);
    }
}
