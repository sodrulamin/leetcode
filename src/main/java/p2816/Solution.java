package p2816;

import data.ListNode;

public class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode preHead = new ListNode(0, head);

        ListNode left = preHead;
        ListNode right = head;

        while (right != null) {
            right.val *= 2;
            if(right.val > 9) {
                left.val++;
                right.val %= 10;
            }

            left = left.next;
            right = right.next;
        }

        if(preHead.val > 0)
            return preHead;
        return head;
    }
}
