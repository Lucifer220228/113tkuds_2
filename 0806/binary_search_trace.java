import java.util.Scanner;

public class binary_search_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13}; // 升冪排序陣列
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入要搜尋的數字：");
        int target = scanner.nextInt();

        int left = 0;
        int right = arr.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("搜尋範圍：left = " + left + ", right = " + right + 
                               ", mid = " + mid + " → arr[mid] = " + arr[mid]);

            if (arr[mid] == target) {
                found = true;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (found) {
            System.out.println("結果：已找到！");
        } else {
            System.out.println("結果：未找到！");
        }

        scanner.close();
    }
}

/*
時間複雜度比較
演算法	    時間複雜度	 說明
線性搜尋	O(n)	    每次只能檢查一個元素
二元搜尋法	O(log n)	每次搜尋可排除一半資料，更快！

二元搜尋的前提是：陣列 必須已排序！
 */