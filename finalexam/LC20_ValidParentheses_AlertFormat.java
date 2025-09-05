package finalexam;

import java.util.*;

public class LC20_ValidParentheses_AlertFormat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        // Map<閉括號, 對應的開括號>
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                // 碰到閉括號 → 檢查 stack 頂端
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                // 開括號 → push
                stack.push(c);
            }
        }

        // 結束時若 stack 空，則完全配對成功
        return stack.isEmpty();
    }
}

