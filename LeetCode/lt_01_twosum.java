package LeetCode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // key: 數字, value: 索引
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // 需要的另一半
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i }; // 找到解答
            }
            map.put(nums[i], i); // 存當前數字
        }
        return new int[] {}; // 理論上不會執行到這裡，因為題目保證一定有解
    }
}

