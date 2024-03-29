package p1171;

import data.ListNode;
import util.Utils;

import java.util.HashMap;
import java.util.Map;

public class SolutionMap {
    private static final Map<Integer, ListNode> sumMap = new HashMap<>();
    public ListNode removeZeroSumSublists(ListNode head) {
        sumMap.clear();

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        sumMap.put(0, dummyNode);

        ListNode current = head;
        int prefixSum = 0;
        while (current != null) {
            prefixSum += current.val;
            if(sumMap.containsKey(prefixSum)) {
                removeNodes(current, prefixSum);
            }
            else {
                sumMap.put(prefixSum, current);
            }
            current = current.next;
         }

        return dummyNode.next;
    }

    private void removeNodes (ListNode current, int prefixSum) {
        ListNode start = sumMap.get(prefixSum);
        ListNode temp = start;
        int sum = prefixSum;

        while (temp != current) {
            temp = temp.next;
            sum += temp.val;

            if(temp != current)
                sumMap.remove(sum);
        }

        start.next = current.next;
    }

    public static void main(String[] args) {
        ListNode node = Utils.createLinkedList(new int[] {1,3,2,-3,-2,5,5,-5,1});

        new SolutionMap().removeZeroSumSublists(node);
    }
}
