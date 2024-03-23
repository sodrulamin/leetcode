package p143;

import data.ListNode;
import util.Utils;

public class Solution {
    public void reorderList(ListNode head) {
        if(head == null)
            return;

        //find the middle of the list
        ListNode middle = findMiddle(head);

        //split the list into two half
        ListNode secondHalf = middle.next;
        middle.next = null;

        //reverse the second half
        secondHalf = reverseList(secondHalf);

        //merge the two halves into the result list
        mergeLists(head, secondHalf);
    }

    private ListNode findMiddle (ListNode head) {
        ListNode current = head.next;
        ListNode middle = head;

        while (current != null && current.next != null) {
            current = current.next.next;
            middle = middle.next;
        }

        return middle;
    }
    private ListNode findMiddle1 (ListNode head) {
        ListNode current = head.next;
        ListNode middle = head;
        boolean forward = false;

        while (current != null) {
            current = current.next;
            if(forward)
                middle = middle.next;
            forward = !forward;
        }

        return middle;
    }

    private ListNode reverseList (ListNode node) {
        ListNode current = node;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;

            current.next = prev;
            prev = current;

            current = next;
        }

        return prev;
    }

    private void mergeLists (ListNode first, ListNode second) {
        ListNode curr = first;
        while(second != null){
            ListNode node = curr.next;
            curr.next = second;
            second = node;
            curr = curr.next;
        }
    }

    private void mergeLists1 (ListNode first, ListNode second) {

        ListNode next = null;

        while (first != null) {
            //keep the next of first
            next = first.next;

            //assign one node of second into the first
            first.next = second;

            //forward the second once
            if(second != null)
                second = second.next;

            //forward the first twice so that it
            first = first.next;
            if(first != null)
                first.next = next;

            if(first != null)
                first = first.next;
        }
    }

    public static void main(String[] args) {
        int [] array = new int[] {1,2,3,4};

        new Solution().reorderList(Utils.createLinkedList(array));
    }
}
