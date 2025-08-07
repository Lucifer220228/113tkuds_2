import java.util.Scanner;

public class q2seqsearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();             // 陣列長度
        int[] arr = new int[n];                // 宣告陣列

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();        // 讀入每個元素
        }

        int key = scanner.nextInt();           // 讀入要查找的 key
        int position = -1;                     // 預設找不到

        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                position = i + 1;              // 第幾個（從 1 開始）
                break;
            }
        }

        if (position != -1) {
            System.out.println("Yes");
            System.out.println(position);
        } else {
            System.out.println("No");
            System.out.println(-1);
        }

        scanner.close();
    }
}
