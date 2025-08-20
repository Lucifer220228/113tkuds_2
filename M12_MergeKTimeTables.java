// M12_MergeKTimeTables.java
import java.util.*;

public class M12_MergeKTimeTables {
    static class Entry implements Comparable<Entry> {
        int time;     // 當前時間
        int listId;   // 來自哪一份時刻表
        int index;    // 在該時刻表中的索引

        Entry(int time, int listId, int index) {
            this.time = time;
            this.listId = listId;
            this.index = index;
        }

        @Override
        public int compareTo(Entry other) {
            return Integer.compare(this.time, other.time);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt(); // 時刻表數量
        List<List<Integer>> lists = new ArrayList<>();

        // 讀取每一份時刻表
        for (int i = 0; i < K; i++) {
            int len = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                arr.add(sc.nextInt());
            }
            lists.add(arr);
        }

        // 最小堆
        PriorityQueue<Entry> pq = new PriorityQueue<>();
        // 將每一份時刻表的第一個放入堆
        for (int i = 0; i < K; i++) {
            if (!lists.get(i).isEmpty()) {
                pq.add(new Entry(lists.get(i).get(0), i, 0));
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Entry cur = pq.poll();
            result.add(cur.time);

            // 同來源表若還有下一個，推入堆
            int nextIdx = cur.index + 1;
            if (nextIdx < lists.get(cur.listId).size()) {
                pq.add(new Entry(lists.get(cur.listId).get(nextIdx), cur.listId, nextIdx));
            }
        }

        // 輸出結果
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result.get(i));
        }
        System.out.println();
    }
}
