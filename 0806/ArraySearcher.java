public class ArraySearcher {

    // 2. 搜尋指定數值，回傳索引或 -1
    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 4. 計算指定數值在陣列中出現的次數
    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 1. 建立陣列
        int[] data = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        // 5. 測試搜尋數字 67 和 100
        int target1 = 67;
        int index1 = findElement(data, target1);
        System.out.println("搜尋 " + target1 + " 結果: " + (index1 != -1 ? "找到於索引 " + index1 : "找不到"));

        int target2 = 100;
        int index2 = findElement(data, target2);
        System.out.println("搜尋 " + target2 + " 結果: " + (index2 != -1 ? "找到於索引 " + index2 : "找不到"));

        // 額外測試出現次數
        System.out.println(target1 + " 出現次數: " + countOccurrences(data, target1));
        System.out.println(target2 + " 出現次數: " + countOccurrences(data, target2));
    }
}
