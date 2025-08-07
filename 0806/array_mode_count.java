public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3, 7, 3, 1, 1, 1}; // 自訂整數陣列

        int mode = arr[0]; // 初始眾數
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            System.out.println("比對中：" + arr[i] + " 出現次數 = " + count);

            if (count > maxCount) {
                maxCount = count;
                mode = arr[i];
            }
        }

        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}

/*
這段程式使用兩層迴圈：

for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        ...
    }
}
每個元素與全部元素比對一次，總共會執行 n × n 次比較。

時間複雜度為 O(n²)

如果允許使用 Java 的 HashMap，可以在一層迴圈內完成次數統計，再找出最大值，這樣可將時間複雜度改善為 O(n)。
 */