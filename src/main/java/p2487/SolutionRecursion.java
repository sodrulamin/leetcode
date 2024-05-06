package p2487;

import data.ListNode;

public class SolutionRecursion {
    public ListNode removeNodes(ListNode head) {
        removeNode(head, head.next);

        if (head.next == null || head.next.val <= head.val)
            return head;

        return head.next;
    }

    private void removeNode (ListNode pre, ListNode cur) {
        if(cur == null)
            return;

        removeNode(cur, cur.next);

        if(cur.next == null)
            return;

        if(cur.next.val > cur.val) {
            pre.next = cur.next;
            cur.next = null;
        }
    }
}
