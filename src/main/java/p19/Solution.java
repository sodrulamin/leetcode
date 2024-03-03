package p19;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        while (n-- > 1)
            current = current.next;

        ListNode deleted = head;
        ListNode previous = null;

        while (current.next != null) {
            current = current.next;
            previous = deleted;
            deleted = deleted.next;
        }

        if(previous == null)
            return head.next;

        previous.next = deleted.next;
        deleted.next = null;

        return head;
    }
}
