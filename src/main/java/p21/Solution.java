package p21;

import data.ListNode;

import java.util.List;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0, null);
        addNode(head, list1, list2);

        return head.next;
    }

    private void addNode(ListNode current, ListNode list1, ListNode list2){
        if(list1 == null && list2 == null)
            return;

        if(list1 == null){
            current.next = new ListNode(list2.val, null);
            addNode(current.next, list1, list2.next);
            return;
        }

        if(list2 == null || list1.val < list2.val){
            current.next = new ListNode(list1.val, null);
            addNode(current.next, list1.next, list2);
            return;
        }


        current.next = new ListNode(list2.val, null);
        addNode(current.next, list1, list2.next);
    }
    
}
