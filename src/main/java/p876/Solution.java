package p876;

public class Solution {
    public ListNode middleNode(ListNode head) {
        if(head.next == null)
            return head;


        ListNode middle = head;
        boolean forwardMiddle = true;

        while (head.next != null) {
            head = head.next;
            if(forwardMiddle)
                middle = middle.next;
            forwardMiddle = !forwardMiddle;
        }

        return middle;
    }
}
