package p237;

import data.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        if(node.next.next == null) {
            node.next = null;
            return;
        }

        deleteNode(node.next);
    }
}
