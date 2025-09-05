package finalexam;

import java.util.*;

public class LC03_NoRepeat_TaipeiMetroTap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        // Map<字元, 上次出現的索引>
        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0;   // 視窗左界
        int ans = 0;    // 最長長度
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            if (map.containsKey(c)) {
                // 更新左界：跳到該字元上次位置 +1（但不能左移回去）
                left = Math.max(left, map.get(c) + 1);
            }
            
            // 更新當前視窗長度
            ans = Math.max(ans, right - left + 1);
            
            // 記錄最新出現位置
            map.put(c, right);
        }
        
        System.out.println(ans);
    }
}

