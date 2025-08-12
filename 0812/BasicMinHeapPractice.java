import java.util.ArrayList;

public class BasicMinHeapPractice {
    private ArrayList<Integer> heap;

    public BasicMinHeapPractice() {
        heap = new ArrayList<>();
    }

    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    public int extractMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    public int getMin() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index) < heap.get(parent)) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChild, rightChild, smallest;
        while (true) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            smallest = index;

            if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
                smallest = leftChild;
            }
            if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
                smallest = rightChild;
            }
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        BasicMinHeapPractice minHeap = new BasicMinHeapPractice();
        int[] nums = {15, 10, 20, 8, 25, 5};
        for (int num : nums) {
            minHeap.insert(num);
        }

        System.out.print("ExtractMin 順序: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.extractMin() + " ");
        }
    }
}
