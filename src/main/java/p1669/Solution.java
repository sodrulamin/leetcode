package p1669;

import data.ListNode;

public class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int x = b - a + 2; //exclude both start and end, so add 2

        ListNode first = list1;
        while (a > 1) {
            first = first.next;
            a--;
        }

        ListNode last = first;
        while (x > 0) {
            last = last.next;
            x--;
        }

        first.next = list2;
        while (first.next != null) {
            first = first.next;
        }

        first.next = last;

        return list1;
    }

}
