import java.util.*;

public class M11_HeapSortWithTie {
    static class Pair {
        int score;
        int index;
        Pair(int s, int i) {
            score = s;
            index = i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(sc.nextInt(), i);
        }

        // 使用 Bottom-up 建立 Max-Heap
        buildHeap(arr);

        // Heap Sort 過程
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i); // 最大值換到最後
            heapify(arr, 0, i); // 維護前 i 個元素的堆
        }

        // 輸出（遞增序）
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].score + (i == n - 1 ? "" : " "));
        }
    }

    // 建堆 O(n)
    private static void buildHeap(Pair[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    // Heapify (維護最大堆)
    private static void heapify(Pair[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1, right = 2 * i + 2;

        if (left < n && greater(arr[left], arr[largest])) {
            largest = left;
        }
        if (right < n && greater(arr[right], arr[largest])) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, n);
        }
    }

    // 比較規則：score 大的優先；若相同，index 小的優先
    private static boolean greater(Pair a, Pair b) {
        if (a.score != b.score) return a.score > b.score;
        return a.index < b.index;
    }

    private static void swap(Pair[] arr, int i, int j) {
        Pair tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

/*
 * Time Complexity: O(n log n)
 * 說明：
 * 1. 建堆 (Build-Heap)：O(n)。
 * 2. Heap Sort 過程：每次取出最大元素 O(log n)，共 n 次 → O(n log n)。
 * 整體為 O(n log n)，其中 n 為輸入長度。
 *
 * Space Complexity: O(1)
 * 只在陣列內部做交換，沒有額外使用額外結構。
 */
