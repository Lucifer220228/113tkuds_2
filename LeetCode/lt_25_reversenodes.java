package LeetCode;

public class lt_25_reversenodes {
    class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy, nex = dummy, pre = dummy;
        int count = 0;

        // Count the length of list
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        // Loop until we process all groups of k
        while (count >= k) {
            cur = pre.next;
            nex = cur.next;

            // Reverse k nodes
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }

            pre = cur;
            count -= k;
        }

        return dummy.next;
    }
}

}
