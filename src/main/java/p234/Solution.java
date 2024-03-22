package p234;

import data.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return false;

        //determine the middle of the linked list
        ListNode halfWay = head;
        ListNode current = head.next;
        boolean forward = false;
        while (current != null) {
            if(forward)
                halfWay = halfWay.next;
            forward = !forward;
            current = current.next;
        }

        //cut the linked list into two pieces, One will be in head, another will be in current
        current = halfWay.next;
        halfWay.next = null;

        //reverse the second half of the linked list
        current = reverseList(current);

        //now match the first half(head) with the reversed second half(current)
        while (current != null) {
            if(current.val != head.val)
                return false;
            current = current.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverseList (ListNode node) {
        ListNode prev = null, cur = node, next = null;
        while (cur != null) {
            next = cur.next;

            cur.next = prev;
            prev = cur;

            cur = next;
        }

        return prev;
    }

}
