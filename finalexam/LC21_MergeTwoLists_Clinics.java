package finalexam;

import java.util.*;

public class LC21_MergeTwoLists_Clinics {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ListNode l1 = null, l2 = null, curr;

        // 建立 l1
        ListNode dummy1 = new ListNode(0);
        curr = dummy1;
        for (int i = 0; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }
        l1 = dummy1.next;

        // 建立 l2
        ListNode dummy2 = new ListNode(0);
        curr = dummy2;
        for (int i = 0; i < m; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }
        l2 = dummy2.next;

        ListNode merged = mergeTwoLists(l1, l2);

        // 輸出合併後序列
        curr = merged;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" ");
            curr = curr.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // 將剩餘的鏈接上
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }
}

