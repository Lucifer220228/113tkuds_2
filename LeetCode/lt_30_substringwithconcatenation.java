package LeetCode;

import java.util.List;

public class lt_30_substringwithconcatenation {
    class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new java.util.ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        java.util.Map<String, Integer> wordMap = new java.util.HashMap<>();
        for (String word : words) wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);

        // 分成 wordLen 個起點的滑動窗口
        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            java.util.Map<String, Integer> seen = new java.util.HashMap<>();
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String sub = s.substring(j, j + wordLen);
                if (wordMap.containsKey(sub)) {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    count++;
                    // 如果某個單詞出現次數過多，縮小窗口
                    while (seen.get(sub) > wordMap.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                    // 當窗口大小等於 words.length，說明找到一個解
                    if (count == wordCount) res.add(left);
                } else {
                    seen.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        return res;
    }
}

}
