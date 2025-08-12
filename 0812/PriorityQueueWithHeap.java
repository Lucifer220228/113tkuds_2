import java.util.*;

class Task {
    String name;
    int priority;
    long timestamp;

    public Task(String name, int priority, long timestamp) {
        this.name = name;
        this.priority = priority;
        this.timestamp = timestamp;
    }
}

public class PriorityQueueWithHeap {
    private PriorityQueue<Task> pq;
    private long timeCounter;

    public PriorityQueueWithHeap() {
        timeCounter = 0;
        pq = new PriorityQueue<>((a, b) -> {
            if (b.priority != a.priority) {
                return b.priority - a.priority; // 高優先級先
            }
            return Long.compare(a.timestamp, b.timestamp); // 先來先服務
        });
    }

    public void addTask(String name, int priority) {
        pq.offer(new Task(name, priority, timeCounter++));
    }

    public String executeNext() {
        if (pq.isEmpty()) return null;
        return pq.poll().name;
    }

    public String peek() {
        if (pq.isEmpty()) return null;
        return pq.peek().name;
    }

    public void changePriority(String name, int newPriority) {
        List<Task> temp = new ArrayList<>();
        while (!pq.isEmpty()) {
            Task t = pq.poll();
            if (t.name.equals(name)) {
                t.priority = newPriority;
            }
            temp.add(t);
        }
        pq.addAll(temp);
    }

    public static void main(String[] args) {
        PriorityQueueWithHeap queue = new PriorityQueueWithHeap();
        queue.addTask("備份", 1);
        queue.addTask("緊急修復", 5);
        queue.addTask("更新", 3);

        System.out.println(queue.executeNext()); // 緊急修復
        System.out.println(queue.executeNext()); // 更新
        System.out.println(queue.executeNext()); // 備份
    }
}

