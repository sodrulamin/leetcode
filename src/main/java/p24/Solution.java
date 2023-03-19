package p24;


import data.ListNode;

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
}