import java.util.Scanner;

public class q3binsearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();            // 陣列長度
        int[] arr = new int[n];               // 宣告整數陣列

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();       // 讀入已排序的整數
        }

        int key = scanner.nextInt();          // 要搜尋的 key
        int left = 0;
        int right = n - 1;
        int index = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                index = mid;
                break;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(index);
        scanner.close();
    }
}
