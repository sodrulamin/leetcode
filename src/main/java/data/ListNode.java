package data;


public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode generate (int [] array) {
        ListNode head = new ListNode(array[0]);
        ListNode cur = head;
        for(int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }

        return head;
    }

    public static void print (ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if(node != null)
                System.out.print(" --> ");
        }
        System.out.println();
    }
}
