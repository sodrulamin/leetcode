package util;

import data.ListNode;

public class Utils {
    public static ListNode createLinkedList (int [] array) {
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for(int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }

        return head;
    }
}
