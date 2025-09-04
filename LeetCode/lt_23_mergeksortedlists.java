package LeetCode;

public class lt_23_mergeksortedlists {
    class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        java.util.PriorityQueue<ListNode> pq = new java.util.PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) pq.add(node.next);
        }

        return dummy.next;
    }
}

}
