package p206;

import data.ListNode;

public class SolutionRecursion {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;

        ListNode dummy = new ListNode(0);

        reverse(head, dummy);

        return dummy.next;
    }

    private ListNode reverse (ListNode node, ListNode dummy) {
        if(node.next == null) {
            dummy.next = node;
            return node;
        }

        ListNode reversed = reverse(node.next, dummy);
        reversed.next = node;
        node.next = null;

        return node;
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,5};

        new SolutionRecursion().reverseList(createNode(array));
    }

    private static ListNode createNode (int [] array) {
        ListNode head = null, current = null;

        for(int val: array) {
            if(current == null) {
                current = new ListNode(val);
                head = current;
            }
            else {
                current.next = new ListNode(val);
                current = current.next;
            }
        }

        return head;
    }
}
