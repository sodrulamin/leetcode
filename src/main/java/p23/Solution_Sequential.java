package p23;

import data.ListNode;

public class Solution_Sequential {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0, null);

        addNode(head, lists);

        return head.next;
    }

    private void addNode(ListNode currentNode, ListNode[] list){
        int index = -1, min = Integer.MAX_VALUE;

        for(int i = 0; i < list.length; i++){
            ListNode node = list[i];
            if(node == null){
                continue;
            }

            if(node.val < min){
                min = node.val;
                index = i;
            }
        }

        if(index == -1)
            return;

        currentNode.next = new ListNode(list[index].val, null);
        list[index] = list[index].next;
        addNode(currentNode.next, list);
    }
}
