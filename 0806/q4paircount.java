import java.util.Scanner;

public class q4paircount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();        // 陣列長度
        int[] arr = new int[n];

        // 讀入陣列元素（實際上不影響計算，但題目要求需讀入）
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 計算 C(n, 2) = n * (n - 1) / 2
        int pairCount = n * (n - 1) / 2;

        System.out.println(pairCount);
        scanner.close();
    }
}
