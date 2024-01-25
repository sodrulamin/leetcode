package p142;

import data.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        
        if(head.val == Integer.MAX_VALUE)
            return head;
        
        head.val = Integer.MAX_VALUE;
        return detectCycle(head.next);
    }
}
