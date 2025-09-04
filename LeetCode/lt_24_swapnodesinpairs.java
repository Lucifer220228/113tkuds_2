package LeetCode;

public class lt_24_swapnodesinpairs {
    class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // swap
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // move pointers
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}

}
