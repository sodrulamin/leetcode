package p791;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SolutionManualComparator {

    private static final int [] score = new int[26];
    public String customSortString(String order, String s) {
        Arrays.fill(score, Integer.MAX_VALUE);
        char [] arr = order.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            score[arr[i] - 'a'] = i;
        }

        List<Character> list = new ArrayList<>(arr.length);
        for(char ch: s.toCharArray())
            list.add(ch);

        list.sort(new CharComparator());

        arr = new char[s.length()];
        int index = 0;
        for(Character ch: list)
            arr[index++] = ch;

        return new String(arr);
    }

    private static class CharComparator implements Comparator<Character> {

        @Override
        public int compare(Character c1, Character c2) {
            // Implement your custom sorting logic here
            // For example, to sort in descending order:
            return score[c1 - 'a'] - score[c2 - 'a'];  // Uses the underlying character integer values
        }
    }

    public static void main(String[] args) {
        System.out.println(new SolutionManualComparator().customSortString("cba", "abcd"));
    }
}
