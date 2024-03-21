package p206;

import data.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;

            current.next = prev;
            prev = current;

            current = next;
        }

        return prev;
    }
}
