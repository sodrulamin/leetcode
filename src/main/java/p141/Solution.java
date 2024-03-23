package p141;

import data.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        return visit(head, 0);
    }

    private boolean visit(ListNode node, int position) {
        if(node == null)
            return false;

        if(position > 10000)
            return true;

        return visit(node.next, position + 1);
    }
}
