import java.util.Scanner;

public class q5matrixmul {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 讀取矩陣大小

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] C = new int[n][n];

        // 讀取矩陣 A
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = scanner.nextInt();

        // 讀取矩陣 B
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                B[i][j] = scanner.nextInt();

        // 計算矩陣乘法 C = A × B
        for (int i = 0; i < n; i++) {         // 第 i 行
            for (int j = 0; j < n; j++) {     // 第 j 列
                int sum = 0;
                for (int k = 0; k < n; k++) { // 內積運算
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }

        // 輸出矩陣 C
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j]);
                if (j < n - 1) System.out.print(" ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
