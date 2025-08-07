import java.util.HashMap;
import java.util.Map;

public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3, 7, 3, 1, 1, 1}; // 自訂整數陣列

        HashMap<Integer, Integer> countMap = new HashMap<>();
        int mode = arr[0];
        int maxCount = 0;

        for (int num : arr) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
            System.out.println("比對中：" + num + " 出現次數 = " + count);

            if (count > maxCount) {
                maxCount = count;
                mode = num;
            }
        }

        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}

/*
時間複雜度：O(n)
每個元素只處理一次，查找與插入 HashMap 都是 O(1)
 */