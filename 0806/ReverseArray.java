import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取陣列長度
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // 讀取陣列元素
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 輸出反轉後的陣列
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i != 0) {
                System.out.print(" ");
            }
        }

        System.out.println(); // 換行
        scanner.close();
    }
}
