package p2487;

import data.ListNode;

public class Solution {
    public ListNode removeNodes(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode prevNode = head;
        ListNode currentNode = head.next;

        while(currentNode != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        head.next = null;
        head = prevNode;

        currentNode = head.next;
        while(currentNode != null){
            if(currentNode.val < prevNode.val){
                currentNode = currentNode.next;
            }
            else{
                ListNode nextNode = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
                currentNode = nextNode;
            }

        }
        head.next = null;
        head = prevNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.generate(new int[]{5,2,13,3,8});

        ListNode.print(head);
        head = new Solution().removeNodes(head);
        ListNode.print(head);
    }
}
