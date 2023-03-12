package p23;

public class Solution {
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        return mergeListsInRange(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeListsInRange(ListNode [] lists, int start, int end) {
        if(start == end)
            return lists[start];
        
        int mid = (start + end) / 2;
        ListNode left = mergeListsInRange(lists, start, mid);
        ListNode right = mergeListsInRange(lists, mid + 1, end);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        
        while (left != null && right != null) {
            if(left.val < right.val) {
                current.next = left;
                current = current.next;
                left = left.next;
            }
            else {
                
                current.next = right;
                current = current.next;
                right = right.next;
            }
        }
        
        while (left != null) {
            current.next = left;
            current = current.next;
            left = left.next;
        }
    
        while (right != null) {
            current.next = right;
            current = current.next;
            right = right.next;
        }
        
        return head.next;
    }
}
