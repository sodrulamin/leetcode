package p19;

import data.ListNode;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        else if (head.next == null && n == 1)
            return null;

        ListNode current, deleteNode, prev = null;
        current = head;
        while (n > 0 && current != null){
            n--;
            current = current.next;
        }


        if(n > 0)
            return head;

        deleteNode = head;
        while (current != null){
            current = current.next;
            prev = deleteNode;
            deleteNode = deleteNode.next;
        }

        if(deleteNode == head){
            head = head.next;
        }
        else {
            prev.next = deleteNode.next;
        }
        deleteNode.next = null;

        return head;
    }
    

    public static void main(String[] args) {
        int [] nums = {1, 2};
        ListNode head = null;
        ListNode current = null;
        for(int i : nums){
            if(head == null){
                head = new ListNode(i);
                head.next = null;

                current = head;
            }
            else {
                current.next = new ListNode(i, null);
                current = current.next;
            }
        }

        head = new Solution().removeNthFromEnd(head, 2);
        System.out.print("[");
        while (head != null){
            System.out.print(head.val);
            head = head.next;
            if(head != null) System.out.print(",");
        }

        System.out.println("]");
    }
}
