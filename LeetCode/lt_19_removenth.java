package LeetCode;

public class lt_19_removenth {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy, second = dummy;

        // move first n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // move both until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // remove target node
        second.next = second.next.next;

        return dummy.next;
    }
}

}
