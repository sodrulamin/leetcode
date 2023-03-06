package p24;


class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;

        head = doSwap(head, head.next);
        ListNode currentNode = head;
        while (currentNode.next != null){
            //shift second time
            currentNode = currentNode.next;
            if(currentNode.next == null)
                return head;

            ListNode firstNode = currentNode.next;
            currentNode.next = doSwap(firstNode, firstNode.next);

            //shift first time
            currentNode = currentNode.next;
            if(currentNode.next == null)
                return head;

        }

        return head;
    }

    private ListNode doSwap(ListNode first, ListNode second){
        if(second == null)
            return first;

        first.next = second.next;
        second.next = first;
        return second;
    }

    public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}