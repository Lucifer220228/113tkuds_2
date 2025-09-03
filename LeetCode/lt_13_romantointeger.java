package LeetCode;

public class lt_13_romantointeger {
    class Solution {
    public int romanToInt(String s) {
        java.util.Map<Character, Integer> map = new java.util.HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;
            if (curr < next) {
                sum += next - curr;
                i++;
            } else {
                sum += curr;
            }
        }
        return sum;
    }
}

}
