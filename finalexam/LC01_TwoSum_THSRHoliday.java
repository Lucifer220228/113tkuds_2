package finalexam;

import java.util.*;

public class LC01_TwoSum_THSRHoliday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 讀取 n 與 target
        int n = sc.nextInt();
        long target = sc.nextLong();
        
        long[] seats = new long[n];
        for (int i = 0; i < n; i++) {
            seats[i] = sc.nextLong();
        }
        
        // HashMap<數字, 索引>
        Map<Long, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            long x = seats[i];
            if (map.containsKey(x)) {
                // 找到答案
                System.out.println(map.get(x) + " " + i);
                return;
            }
            // 記錄「需要的數字」：target - x
            map.put(target - x, i);
        }
        
        // 沒找到解
        System.out.println("-1 -1");
    }
}

