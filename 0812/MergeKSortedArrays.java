import java.util.*;

class ArrayNode {
    int value, arrayIndex, elementIndex;

    public ArrayNode(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

public class MergeKSortedArrays {
    public static List<Integer> merge(int[][] arrays) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<ArrayNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.offer(new ArrayNode(arrays[i][0], i, 0));
            }
        }

        while (!minHeap.isEmpty()) {
            ArrayNode node = minHeap.poll();
            result.add(node.value);

            int nextIndex = node.elementIndex + 1;
            if (nextIndex < arrays[node.arrayIndex].length) {
                minHeap.offer(new ArrayNode(arrays[node.arrayIndex][nextIndex], node.arrayIndex, nextIndex));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] input = {{1,4,5}, {1,3,4}, {2,6}};
        System.out.println(merge(input)); // [1,1,2,3,4,4,5,6]
    }
}
