package p25;

import data.ListNode;

public class Solution_Recursion {
    public ListNode reverseKGroup(ListNode head, int k) {
        //if head is null return null
        //if k == 1 then no change is required.
        if(head == null || k < 2)
            return head;


        /* Cut the chain in 3 parts.
        * 1. prevChain: this node contains the last value of previous chain. Previous chain is the already processed chain.
        * 2. current chain: The chain that will be reversed in current iteration.
        *       at first - currentChainStart will contain the starting node of current chain and currentChainEnd will
        *                   contain the last node of current chain.
        *       after processing - currentChainStart will become the last node of current chain and currentChainEnd will
        *                   become the first node of current chain.
        * 3. remainingChain: this node will contain the first node of remaining chain to be processed.
        *
         */
        ListNode prevChain = null, currentChainStart, currentChainEnd = null, remainingChain = head;

        //we will assign this value after first processing is done.
        head = null;

        //until all nodes are processed.
        while (remainingChain != null){
            currentChainStart = remainingChain;

            //cut the chain and take current chain with length k. Will process this chain in this iteration.
            int count = 0;
            while (count < k && remainingChain != null){
                currentChainEnd = remainingChain;
                remainingChain = remainingChain.next;
                count++;
            }

            //if we found enough node only then we reverse them.
            if(count == k){
                reverse(currentChainStart, k);
                if(head == null)
                    head = currentChainEnd; //remember this node has become the first node of reversed chain.

                if (prevChain != null) {
                    //must link the last node of previous chain with first node of current processed chain.
                    prevChain.next = currentChainEnd;
                }
                prevChain = currentChainStart; //remember this node has become the last node of reversed chain.
            }
            //this case only happen if k > total node count of the list.
            else if(head == null){
                head = currentChainStart; // as no reverse happened so start node remains start of the chain.
            }
            //this case only happens if last < k nodes remains unchanged.
            else if(prevChain != null)
                prevChain.next = currentChainStart;

        }

        return head;
    }

    /**
     * Recursively reverse the linked list starting from the given node. And return the last node of the linked list
     * after processing.
     *
     * For example - before calling this method if list looks like 1 --> 2 --> 3 -- [any value] will reverse it
     * like 3 --> 2 --> 1 --> null
     *
     * After processing this method will return node with value 1
     *
     * @param node current node of the linked list. This node will be appended at the last of result from recursive call.
     * @param nodeCount remaining node count for this list.
     * @return the last node of the processed linked list.
     */
    private ListNode reverse(ListNode node, int nodeCount){
        if(nodeCount < 2)
            return node;
        ListNode result = reverse(node.next, nodeCount - 1);
        result.next = node;
        node.next = null;
        return node;
    }

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6};
        ListNode head = null, current = null;
        for(int n: array){
            if(head == null){
                head = new ListNode(n, null);
                current = head;
            }
            else {
                current.next = new ListNode(n, null);
                current = current.next;
            }
        }


        head = new Solution_Recursion().reverseKGroup(head, 1);
        printList(head);
    }

    private static void printList(ListNode head){

        while (head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }
}
