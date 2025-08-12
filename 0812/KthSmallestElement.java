import java.util.*;

public class KthSmallestElement {
    public static int findKthSmallest_MaxHeap(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    public static int findKthSmallest_MinHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) minHeap.offer(num);
        for (int i = 1; i < k; i++) minHeap.poll();
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 10, 4, 3, 20, 15};
        System.out.println(findKthSmallest_MaxHeap(arr1, 3)); // 7
        System.out.println(findKthSmallest_MinHeap(arr1, 3)); // 7
    }
}
