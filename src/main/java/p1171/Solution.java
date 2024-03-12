package p1171;

public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head == null)
            return null;

        int sum = 0;
        ListNode current = head;
        while (current != null) {
            sum += current.val;
            if(sum == 0) {
                return removeZeroSumSublists(current.next);
            }

            current = current.next;
        }

        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}
