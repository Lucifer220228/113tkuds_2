import java.util.*;

class CacheItem {
    int key;
    String value;
    int frequency;
    long time;

    CacheItem(int key, String value, long time) {
        this.key = key;
        this.value = value;
        this.time = time;
        this.frequency = 1;
    }
}

public class MultiLevelCacheSystem {
    private int[] capacities = {2, 5, 10};
    private List<PriorityQueue<CacheItem>> levels;
    private long timer;

    public MultiLevelCacheSystem() {
        timer = 0;
        levels = new ArrayList<>();
        for (int cap : capacities) {
            levels.add(new PriorityQueue<>((a, b) -> {
                if (a.frequency != b.frequency) return a.frequency - b.frequency;
                return Long.compare(a.time, b.time);
            }));
        }
    }

    public String get(int key) {
        for (int i = 0; i < levels.size(); i++) {
            for (CacheItem item : new ArrayList<>(levels.get(i))) {
                if (item.key == key) {
                    item.frequency++;
                    item.time = timer++;
                    promoteItem(i, item);
                    return item.value;
                }
            }
        }
        return null;
    }

    public void put(int key, String value) {
        CacheItem newItem = new CacheItem(key, value, timer++);
        insertItem(0, newItem);
    }

    private void insertItem(int level, CacheItem item) {
        if (levels.get(level).size() >= capacities[level]) {
            CacheItem evicted = levels.get(level).poll();
            if (level + 1 < levels.size()) insertItem(level + 1, evicted);
        }
        levels.get(level).offer(item);
    }

    private void promoteItem(int level, CacheItem item) {
        if (level == 0) return;
        levels.get(level).remove(item);
        insertItem(0, item);
    }

    public static void main(String[] args) {
        MultiLevelCacheSystem cache = new MultiLevelCacheSystem();
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        System.out.println(cache.get(1));
        cache.put(4, "D");
        cache.put(5, "E");
    }
}
