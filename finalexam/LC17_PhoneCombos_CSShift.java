package finalexam;

import java.util.*;

public class LC17_PhoneCombos_CSShift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String digits = sc.nextLine().trim();
        if (digits.isEmpty()) return; // 空字串 → 無輸出
        
        String[] map = {
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        
        StringBuilder path = new StringBuilder();
        dfs(digits, 0, map, path);
    }
    
    private static void dfs(String digits, int idx, String[] map, StringBuilder path) {
        if (idx == digits.length()) {
            System.out.println(path.toString());
            return;
        }
        char d = digits.charAt(idx);
        // 題目保證僅含 '2'~'9'；若要更健壯也可在這裡直接 return 或丟例外
        String letters = map[d - '2'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            dfs(digits, idx + 1, map, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

