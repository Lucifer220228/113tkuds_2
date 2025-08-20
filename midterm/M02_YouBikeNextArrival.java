import java.util.*;
import java.io.*;

public class M02_YouBikeNextArrival {
    // 將 HH:mm 轉換為 "自 00:00 起的分鐘數"
    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        String[] times = new String[n];
        int[] minutes = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = sc.nextLine().trim();
            minutes[i] = toMinutes(times[i]);
        }

        String queryStr = sc.nextLine().trim();
        int query = toMinutes(queryStr);

        // 二分搜尋：找第一個大於 query 的位置
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (minutes[mid] > query) {
                ans = mid;
                right = mid - 1; // 繼續往左找
            } else {
                left = mid + 1;
            }
        }

        if (ans == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(times[ans]);
        }
    }
}
