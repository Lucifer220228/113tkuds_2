package finalexam;

import java.util.*;

public class LC23_MergeKLists_Hospitals {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int k = sc.nextInt();
        sc.nextLine();

        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {
            String line = sc.nextLine().trim();
            if (line.equals("-1")) {
                lists[i] = null;
                continue;
            }
            String[] tokens = line.split(" ");
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            for (String t : tokens) {
                int val = Integer.parseInt(t);
                if (val == -1) break;
                curr.next = new ListNode(val);
                curr = curr.next;
            }
            lists[i] = dummy.next;
        }

        ListNode merged = mergeKLists(lists);

        // 輸出合併後序列
        ListNode curr = merged;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" ");
            curr = curr.next;
        }
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) pq.offer(node.next);
        }

        return dummy.next;
    }
}

