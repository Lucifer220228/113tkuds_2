import java.util.Scanner;

public class ColumnSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 行數
        int M = scanner.nextInt(); // 列數

        int[][] arr = new int[N][M];

        // 輸入陣列
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        // 計算每一列(column)的總和
        for (int col = 0; col < M; col++) {
            int sum = 0;
            for (int row = 0; row < N; row++) {
                sum += arr[row][col];
            }
            System.out.print(sum);
            if (col != M - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        scanner.close();
    }
}
