package p2816;

import data.ListNode;

public class SolutionReverse {
    public ListNode doubleIt(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        head.next = null;
        cur = pre;
        int carry = 0;
        pre = null;

        while (cur != null) {
            cur.val = cur.val * 2 + carry;
            carry = cur.val / 10;
            cur.val = cur.val % 10;

            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        head = pre;
        if(carry > 0)
            pre = new ListNode(carry, head);

        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.generate(new int[] {1,8,9});

        head = new SolutionReverse().doubleIt(head);
        ListNode.print(head);
    }
}
