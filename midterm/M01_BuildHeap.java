// M01_BuildHeap.java
import java.util.*;

public class M01_BuildHeap {
    static boolean isMaxHeap;

    // 下沉操作
    private static void heapifyDown(int[] heap, int n, int i) {
        int largestOrSmallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (isMaxHeap) {
            if (left < n && heap[left] > heap[largestOrSmallest]) {
                largestOrSmallest = left;
            }
            if (right < n && heap[right] > heap[largestOrSmallest]) {
                largestOrSmallest = right;
            }
        } else { // min-heap
            if (left < n && heap[left] < heap[largestOrSmallest]) {
                largestOrSmallest = left;
            }
            if (right < n && heap[right] < heap[largestOrSmallest]) {
                largestOrSmallest = right;
            }
        }

        if (largestOrSmallest != i) {
            int tmp = heap[i];
            heap[i] = heap[largestOrSmallest];
            heap[largestOrSmallest] = tmp;
            heapifyDown(heap, n, largestOrSmallest);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String type = sc.next();   // max 或 min
        isMaxHeap = type.equals("max");

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 自底向上建堆
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyDown(arr, n, i);
        }

        // 輸出建堆後陣列
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * - HeapifyDown 在高度 h 的節點需要 O(h)。
 * - 高度 h 的節點數約為 n / 2^(h+1)。
 * - 總時間複雜度 = Σ (h * n / 2^(h+1)) = O(n)。
 * 因此自底向上建堆比逐一插入 O(n log n) 更快。
 */
