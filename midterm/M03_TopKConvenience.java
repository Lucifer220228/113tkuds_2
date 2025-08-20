import java.util.*;

public class M03_TopKConvenience {
    static class Item {
        String name;
        int qty;
        Item(String n, int q) {
            name = n;
            qty = q;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), K = sc.nextInt();
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int qty = sc.nextInt();
            items.add(new Item(name, qty));
        }

        // Min-Heap 依 qty (升冪)，同 qty 則依字典序
        PriorityQueue<Item> pq = new PriorityQueue<>(
            (a, b) -> (a.qty == b.qty ? b.name.compareTo(a.name) : a.qty - b.qty)
        );

        for (Item it : items) {
            pq.offer(it);
            if (pq.size() > K) pq.poll();
        }

        List<Item> result = new ArrayList<>(pq);
        result.sort((a, b) -> {
            if (b.qty != a.qty) return b.qty - a.qty;
            return a.name.compareTo(b.name);
        });

        for (Item it : result) {
            System.out.println(it.name + " " + it.qty);
        }
    }
}

/*
 * Time Complexity: O(n log K + K log K)
 * 說明：
 * 1. 對 n 筆資料逐一插入 Min-Heap，維持大小 K → O(n log K)。
 * 2. 最後將 Heap 轉成 List 並排序 → O(K log K)。
 * 3. K 遠小於 n 時，效率遠優於 O(n log n)。
 */
