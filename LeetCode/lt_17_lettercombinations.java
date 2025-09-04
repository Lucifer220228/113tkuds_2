package LeetCode;

import java.util.List;

public class lt_17_lettercombinations {
    class Solution {
    private static final String[] KEYS = {
        "",    // 0
        "",    // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs",// 7
        "tuv", // 8
        "wxyz" // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new java.util.ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        backtrack(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder sb, String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = KEYS[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(res, sb, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

}
